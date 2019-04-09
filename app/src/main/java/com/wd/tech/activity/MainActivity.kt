package com.wd.tech.activity

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.wd.tech.R
import com.wd.tech.activity.base.BaseActivity
import com.wd.tech.fragment.CommunityFragment
import com.wd.tech.fragment.InformationFragment
import com.wd.tech.fragment.MessageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun initData() {

    }

    override fun initView() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                when (p0) {
                    0 -> navigation.selectedItemId = R.id.navigation_information
                    1 -> navigation.selectedItemId = R.id.navigation_message
                    2 -> navigation.selectedItemId = R.id.navigation_community
                }
            }
        })

        view_pager!!.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(i: Int): Fragment? {
                when (i) {
                    0 -> return InformationFragment()
                    1 -> return MessageFragment()
                    2 -> return CommunityFragment()
                }
                return null
            }

            override fun getCount(): Int {
                return 3
            }
        }
    }

    override fun bindLayoutId(): Int {
        return R.layout.activity_main
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_information -> {
                view_pager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_message -> {
                view_pager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_community -> {
                view_pager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
