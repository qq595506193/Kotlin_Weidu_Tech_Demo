package com.wd.tech.activity.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import butterknife.ButterKnife
import butterknife.Unbinder
import me.jessyan.autosize.AutoSizeConfig

abstract class BaseFragment : Fragment() {
    private var unbinder: Unbinder? = null

    /**
     * 视图是否已经初初始化
     */
    protected var isInit = false
    protected var isLoad = false
    protected val TAG = "BaseFragment"
    /**
     * 获取设置的布局
     *
     * @return
     */
    protected var contentView: View? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentView = inflater.inflate(setContentView(), container, false)
        unbinder = ButterKnife.bind(this, contentView!!)
        isInit = true
        AutoSizeConfig.getInstance().isCustomFragment = true
        /**初始化的时候去加载数据 */
        isCanLoadData()
        initData()// 初始化数据
        return contentView
    }

    /**
     * 初始化数据
     */
    protected abstract fun initData()

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        isCanLoadData()
    }

    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private fun isCanLoadData() {
        if (!isInit) {
            return
        }
        if (userVisibleHint) {
            lazyLoad()
            isLoad = true
        } else {
            if (isLoad) {
                stopLoad()
            }
        }
    }

    /**
     * 视图销毁的时候讲Fragment是否初始化的状态变为false
     */
    override fun onDestroyView() {
        super.onDestroyView()
        isInit = false
        isLoad = false

    }

    protected fun showToast(message: String) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

    }

    /**
     * 设置Fragment要显示的布局
     *
     * @return 布局的layoutId
     */
    protected abstract fun setContentView(): Int


    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    protected abstract fun lazyLoad()

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以调用此方法
     */
    protected fun stopLoad() {

    }


    override fun onDestroy() {
        super.onDestroy()
        if (unbinder != null) {
            unbinder!!.unbind()
        }
    }
}
