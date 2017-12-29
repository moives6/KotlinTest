package zhaoxixiang.bwie.com.kotlintest

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer
import kotlinx.android.synthetic.main.activity_play_move.*
import zhaoxixiang.bwie.com.kotlintest.Util.VideoListener


class PlayMoveActivity : AppCompatActivity() {


    var imgb: SimpleDraweeView?=null
    var mContext: Context = this
    var isPlay: Boolean = false
    var isPause: Boolean = false
    lateinit var orientationUtils: OrientationUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_move)

        var bundle = this.intent.extras

        //标题
        tv_video_title.setText(bundle.get("title").toString())
        //模糊图
        iv_bottom_bg.setImageURI(bundle.get("imgblurred").toString())
        //广告
        tv_video_time.setText(bundle.get("type").toString())
        //详情文本
        tv_video_desc.setText(bundle.get("text").toString())
        //设置封面
        imgb=SimpleDraweeView(this)
        gsy_player.setThumbImageView(imgb)

        orientationUtils = OrientationUtils(this, gsy_player)

        imgb!!.setImageURI(bundle.get("imgplay").toString())


     var  urlt= bundle.get("url").toString()
        if(urlt!=null){
            gsy_player.setUp(urlt, false, null, null)
        }



        gsy_player.startPlayLogic()

        gsy_player.setIsTouchWiget(true);
        //关闭自动旋转
        gsy_player.isRotateViewAuto = false
        gsy_player.isLockLand = false
        gsy_player.isShowFullAnimation = false
        gsy_player.isNeedLockFull = true


        gsy_player.fullscreenButton.setOnClickListener {
            //直接横屏
            orientationUtils.resolveByClick()
            gsy_player.startWindowFullscreen(mContext, true, true)

        }

        gsy_player.setStandardVideoAllCallBack(object : VideoListener() {
            override fun onPrepared(url: String?, vararg objects: Any?) {
                super.onPrepared(url, *objects)
                //开始播放了才能旋转和全屏
                orientationUtils.isEnable = true

            }

            override fun onAutoComplete(url: String?, vararg objects: Any?) {
                super.onAutoComplete(url, *objects)

            }

            override fun onClickStartError(url: String?, vararg objects: Any?) {
                super.onClickStartError(url, *objects)
            }

            override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
                super.onQuitFullscreen(url, *objects)
                orientationUtils?.let { orientationUtils.backToProtVideo() }
            }
        })

        gsy_player.setLockClickListener { view, lock ->
            //配合下方的onConfigurationChanged
            orientationUtils.isEnable = !lock
        }
        gsy_player.backButton.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }



    //设置了沉浸式
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }



    override fun onBackPressed() {
        orientationUtils?.let {
            orientationUtils.backToProtVideo()
        }
        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        isPause = true
    }

    override fun onResume() {
        super.onResume()
        isPause = false
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoPlayer.releaseAllVideos()
        orientationUtils?.let {
            orientationUtils.releaseListener()
        }
    }


    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        if (isPlay && !isPause) {
            if (newConfig?.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {
                if (!gsy_player.isIfCurrentIsFullscreen) {
                    gsy_player.startWindowFullscreen(mContext, true, true)
                }
            } else {
                //新版本isIfCurrentIsFullscreen的标志位内部提前设置了，所以不会和手动点击冲突
                if (gsy_player.isIfCurrentIsFullscreen) {
                    StandardGSYVideoPlayer.backFromWindowFull(this);
                }
                orientationUtils?.let { orientationUtils.isEnable = true }
            }
        }
    }

}
