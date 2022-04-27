package com.rogergcc.zemogaandroidmobiletest.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogergcc.zemogaandroidmobiletest.repository.DataRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val dataRepo: DataRepo
) : ViewModel() {
    fun getData() {
//        viewModelScope.launch(Dispatchers.IO) {
//            dataRepo.getData()
//        }
    }


//    private fun loadData(refresh: Boolean = false) {
//        isRequesting.set(true)
//        mRepository.getListHeroes(refresh, object : DataSource.GetHeroesCallback {
//            override fun onSuccess(data: List<HeroesModel>) {
//                homeList.clear()
//                homeList.addAll(data.map { HomeModel(it.name ?: "-", it.bio ?: "-", it.imageurl ?: "-") })
//            }
//
//            override fun onError(errorMessage: String) {
//                showMessage.value = errorMessage
//                isRequesting.set(false)
//
//            }
//
//            override fun onFinish() {
//                isRequesting.set(false)
//            }
//        })
//
//    }

//    fun fetchHomeNearPlaces(latitude: String, longitude: String) = liveData(Dispatchers.IO) {
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success((repo.invoke(latitude,longitude))))
//        } catch (e: Exception) {
//            emit(Resource.Failure(e))
//        }
//    }



//    fun fetchRestaurants() = liveData(viewModelScope.coroutineContext + Dispatchers.Main) {
//        emit(Resource.Loading())
//        try {
//            emit(repo.getRestaurants())
//        }catch (e: Exception){
//            emit(Resource.Failure(e))
//        }
//    }
//
//    fun getDisplayRestaurants(restaurants: List<Restaurant>): List<RestaurantDisplayItem> {
//        return restaurants.map { restaurant ->
//
//            return@map RestaurantDisplayItem(
//                id = restaurant.id,
//                displayName = "Restaurant ${restaurant.name}",
//
//                displayDistance = "at ${ restaurant.distance.roundToOneDecimalPlace() } KM distance",
//                imageUrl = restaurant.imageUrl,
//                type = when (restaurant.type) {
//                    "EAT_IN" -> RestaurantType.EAT_IN
//                    "TAKE_AWAY" -> RestaurantType.TAKE_AWAY
//                    else -> RestaurantType.DRIVE_THROUGH
//                },
//                latitude = restaurant.location.latitude,
//                longitude = restaurant.location.longitude
//            )
//        }
//    }


//    viewModel.fetchRestaurants().observe(viewLifecycleOwner) { result ->
//        when (result) {
//            is Resource.Loading -> {
//                showShimmerEffect()
//                TimberAppLogger.i("Resource Loading")
//            }
//            is Resource.Success -> {
//                hideShimmerEffect()
//                TimberAppLogger.i("Resource Success ${result.data} ")
//                if (result.data.isNullOrEmpty()) {
////                        binding.noData.show()
////                        binding.noDataLayout.noData.show()
//                    binding.emptyState.root.show()
//                } else {
//                    binding.emptyState.root.hide()
//                    // Parsing, filtering, displaying
//                    val restaurantParser = RestaurantParser()
//                    val restaurantRules = RestaurantRules()
//                    val parsedRestaurants = restaurantParser.parseRestaurants(result.data)
//                    val filteredRestaurants =
//                        restaurantRules.filterRestaurants(
//                            location?.latitude,
//                            location?.longitude,
//                            parsedRestaurants)
//                    //                        mAdapter.setData(result.data)
//                    displayRestaurants(filteredRestaurants)
//                }
//            }
//
//            is Resource.Failure -> {
//                hideShimmerEffect()
//                binding.emptyState.root.hide()
//                Toast.makeText(
//                    requireContext(),
//                    "Hubo un error al obtener registros",
//                    Toast.LENGTH_SHORT
//                ).show()
//                TimberAppLogger.e("Resource.Failure HomeFragmet ${result.exception} ")
//            }
//        }
//    }
//
//    val restaurantsDisplay = viewModel.getDisplayRestaurants(restaurants)
//    mAdapter.setData(restaurantsDisplay)
}
