package com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.pager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogergcc.zemogaandroidmobiletest.R
import com.rogergcc.zemogaandroidmobiletest.databinding.FragmentSimpleListBinding
import com.rogergcc.zemogaandroidmobiletest.domain.model.Post
import com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.PostsFragmentDirections
import com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.post_list.PostAdapter
import com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.post_list.PostItemListener
import com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel.PostEvent
import com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel.PostViewModel

class SimpleListFragment : Fragment(R.layout.fragment_simple_list) {
    private var param1: Boolean = false

    private var _binding: FragmentSimpleListBinding? = null
    private val binding get() = _binding!!
    private val postViewModel: PostViewModel by activityViewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getBoolean("FavOnly")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSimpleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

    }

    override fun onStart() {
        super.onStart()

        if (param1) {
            binding.fbRefresh.visibility=View.VISIBLE
        } else {
            binding.fbRefresh.visibility=View.GONE
        }

        binding.fbRefresh.setOnClickListener {
            postViewModel.onEvent(PostEvent.RefreshPostList)
        }
        postViewModel.onEvent(PostEvent.LoadPostList)
        postViewModel.posts.observe(viewLifecycleOwner) { posts ->
            //Log.d("MyTesting", it.toString())
            if (param1) {
                initRecyclerView(selectFavOnly(posts))
            } else {
                initRecyclerView(posts)
            }
        }

    }

    private fun selectFavOnly(posts: List<Post>): List<Post> {
        return posts.filter { it.isFavourite == 1 }
    }

    private fun initRecyclerView(posts: List<Post>) {
        binding.rvSimpleList.layoutManager = LinearLayoutManager(activity)
        binding.rvSimpleList.adapter = PostAdapter(posts, object : PostItemListener {
            override fun onItemClick(post: Post) {
                postViewModel.onEvent(PostEvent.ClickOnPost(post))
                Log.e(Companion.TAG, "onItemClick: post TITLE ${post.title}")
                Log.e(Companion.TAG, "onItemClick: post BODY ${post.body}")
                val action = PostsFragmentDirections.actionPostsDetail()

                navController.navigate(action)
            }
        })
    }

    companion object {
        private const val TAG = "SimpleListFragment"
    }
}