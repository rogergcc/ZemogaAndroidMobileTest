package com.rogergcc.zemogaandroidmobiletest.presentation.screen.post_detail_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogergcc.zemogaandroidmobiletest.R
import com.rogergcc.zemogaandroidmobiletest.databinding.FragmentDetailBinding
import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment
import com.rogergcc.zemogaandroidmobiletest.presentation.screen.post_detail_screen.components.comments_list.CommentAdapter
import com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel.PostEvent
import com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel.PostViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val postViewModel: PostViewModel by activityViewModels()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        setHasOptionsMenu(true);
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        binding.defaultToolbar.inflateMenu(R.menu.menu_detail)
//        binding.defaultToolbar.setOnMenuItemClickListener { item ->
//            Log.d("MyTesting", "ItemSelection")
//            when (item.itemId) {
//                R.id.mi_delete -> {
//                    postViewModel.onEvent(PostEvent.DeletePost(postViewModel.selectedPost.value!!))
//                    true
//                }
//                R.id.mi_favourite -> {
//                    postViewModel.onEvent(
//                        PostEvent.ToggleFavouritePost(
//                            postId = postViewModel.selectedPost.value!!.id
//                        )
//                    )
//                    true
//                }
//                else -> true
//            }
//        }
//        binding.defaultToolbar.setupWithNavController(navController, appBarConfiguration)

        binding.characterFavorite.setOnClickListener {
            postViewModel.onEvent(
                PostEvent.ToggleFavouritePost(
                    postId = postViewModel.selectedPost.value!!.id
                )
            )
        }
    }

    override fun onStart() {
        super.onStart()

        postViewModel.selectedPost.value.let { post ->
            Log.d("MyTesting", post.toString())
            binding.tvBody.text = post!!.body
//            Toast.makeText(requireContext(), "IS FAV? ${post.isFavourite}", Toast.LENGTH_SHORT)
//                .show()

            val isFavorite = post?.isFavourite == 1

            binding.characterFavorite.setImageResource(
                if (isFavorite != null && isFavorite) {
                    R.drawable.ic_round_favorite_24
                } else {
                    R.drawable.ic_round_favorite_border_24
                }
            )
            postViewModel.onEvent(PostEvent.LoadPostAuthor(userId = post.userId!!))
            postViewModel.onEvent(PostEvent.LoadPostComments(postId = post.id!!))


        }

        postViewModel.selectedPostAuthor.observe(requireActivity(), Observer {
            //Log.d("MyTesting", it.toString())
            binding.tvUserName.text = it!!.name
            binding.tvUserEmail.text = it!!.email
            binding.tvUserPhone.text = it!!.phone
            binding.tvUserWebsite.text = it!!.website
        })
        postViewModel.selectedPostComments.observe(requireActivity(), Observer {
            //Log.d("MyTesting", it.toString())
            initRecyclerView(it!!)
        })

        postViewModel.deletionSuccess.observe(requireActivity(), Observer {
            //Log.d("MyTesting", it.toString())
            if (it) {
                navController.popBackStack()
            }
        })
    }

    private fun initRecyclerView(comments: List<Comment>) {
        binding.rvComments.layoutManager = LinearLayoutManager(activity)
        binding.rvComments.adapter = CommentAdapter(comments)
    }
}