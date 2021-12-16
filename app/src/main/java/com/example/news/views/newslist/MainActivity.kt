package com.example.news.views.newslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.news.R
import com.example.news.databinding.ActivityMainBinding
import com.news.latestnews.views.FragmentLatestNews
import com.news.topnews.adapters.AdapterTopNews
import com.news.topnews.views.FragmentTopNews
import com.newsapp.shared.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val mBinding by binding<ActivityMainBinding>(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.apply {
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_top_news -> replaceFragment(FragmentTopNews.getInstance())
                    R.id.nav_latest_news -> replaceFragment(FragmentLatestNews.getInstance())
                }
                return@setOnItemSelectedListener true
            }
            bottomNavigation.setOnItemReselectedListener { return@setOnItemReselectedListener }
        }
    }

    /**
     *  replacing fragment on the bottom navigation click
     */
    private fun replaceFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(mBinding.container.id, frag).commit()
    }


    /**
     *  for handling back press on the latest news screen
     */
    override fun onBackPressed() {
        if (mBinding.bottomNavigation.selectedItemId == R.id.nav_latest_news)
            mBinding.bottomNavigation.selectedItemId = R.id.nav_top_news
        else super.onBackPressed()
    }

}