package com.wd.tech.activity.base

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.Unbinder
import com.blankj.utilcode.util.LogUtils


abstract class BaseActivity : AppCompatActivity() {
    private val isStatus: Boolean = false//沉浸式
    private val isFullScreen: Boolean = false//全屏
    private var unbinder: Unbinder? = null

    //    @Override
    //    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState, @androidx.annotation.Nullable PersistableBundle persistentState) {
    //        super.onCreate(savedInstanceState, persistentState);
    //    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fullScreen(this)// 沉浸式
        supportActionBar!!.hide()//隐藏标题栏
        setContentView(bindLayoutId())
        ButterKnife.bind(this)
        unbinder = ButterKnife.bind(this)
        initView()
        initData()
    }


    protected abstract fun initData()

    protected abstract fun initView()


    /**
     * 绑定根布局id
     *
     * @return
     */
    protected abstract fun bindLayoutId(): Int

    /**
     * 显示toast
     *
     * @param msg
     */
    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 无参跳转
     *
     * @param clz
     */
    fun startActivity(clz: Class<*>) {
        startActivity(Intent(this, clz))
    }

    /**
     * 有参跳转
     *
     * @param clz
     */
    fun startActivity(bundle: Bundle, clz: Class<*>) {
        val intent = Intent(this, clz)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    /**
     * @param status
     */
    fun isStatus(status: Boolean) {
        if (status) {
            //沉浸式代码
        }
    }

    /**
     * 全屏
     *
     * @param
     */
    fun isFullscreen(fullscreenn: Boolean) {
        if (fullscreenn) {
            //全屏代码
        }
    }

    override fun onStart() {
        super.onStart()
        LogUtils.d("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.d("onReStart")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (unbinder != null) {
            unbinder!!.unbind()//解绑butterkinife
        }
    }

    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private fun fullScreen(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                val window = activity.window
                val decorView = window.decorView
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                decorView.systemUiVisibility = option
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
                //导航栏颜色也可以正常设置
                //                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                val window = activity.window
                val attributes = window.attributes
                val flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                val flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                attributes.flags = attributes.flags or flagTranslucentStatus
                //                attributes.flags |= flagTranslucentNavigation;
                window.attributes = attributes
            }
        }
    }
}
