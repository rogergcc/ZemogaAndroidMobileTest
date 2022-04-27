package com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.rogergcc.zemogaandroidmobiletest.R
import com.rogergcc.zemogaandroidmobiletest.databinding.FragmentPostsBinding
import com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.pager.PostsListPagerAdapter
import com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel.PostEvent
import com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel.PostViewModel


class PostsFragment : Fragment(R.layout.fragment_posts) {

    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!

    private val postViewModel: PostViewModel by activityViewModels()
    private lateinit var navController: NavController


    private lateinit var postsListPagerAdapter: PostsListPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        binding.btDeleteAll.setOnClickListener {
            postViewModel.onEvent(PostEvent.DeleteAllPosts)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
//        binding.defaultToolbar.inflateMenu(R.menu.menu_posts)
//        binding.defaultToolbar.setOnMenuItemClickListener { item ->
//            Log.d("MyTesting", "ItemSelection")
//            when (item.itemId) {
//                R.id.mi_refresh -> {
//                    postViewModel.onEvent(PostEvent.RefreshPostList)
//                    true
//                }
//                else -> true
//            }
//        }
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.defaultToolbar
            .setupWithNavController(navController, appBarConfiguration)


        // ViewPager
        postsListPagerAdapter = PostsListPagerAdapter(childFragmentManager)
        binding.pager.adapter = postsListPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.pager)

    }


}