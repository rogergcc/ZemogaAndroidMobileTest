package com.rogergcc.zemogaandroidmobiletest.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogergcc.zemogaandroidmobiletest.databinding.FragmentHomeBinding
import com.rogergcc.zemogaandroidmobiletest.data.remote.dto.GetDataDto
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()

    private val mAdapterPlacesList by lazy {
        PlaceAdapter() { placeItem ->
            goToPlaceDetailsView(placeItem)
        }
    }

    private fun goToPlaceDetailsView(placeItem: GetDataDto) {
//        TODO("Not yet implemented")
        Log.d(TAG, "place  $placeItem")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPlaces.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapterPlacesList
        }

//        mAdapterPlacesList.placeNearbyDetailsAction =

        viewModel.getData()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}
