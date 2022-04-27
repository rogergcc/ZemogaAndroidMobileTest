package com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PostsListPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        val fragment = SimpleListFragment()
        fragment.arguments = Bundle().apply {
            when(position) {
                0 -> putBoolean("FavOnly", false)
                1 -> putBoolean("FavOnly", true)
            }
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "All"
            1 -> "Favourites"
            else -> "Default"
        }
    }
}