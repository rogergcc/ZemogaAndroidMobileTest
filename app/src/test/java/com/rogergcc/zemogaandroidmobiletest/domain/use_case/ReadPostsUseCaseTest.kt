package com.rogergcc.zemogaandroidmobiletest.domain.use_case

import com.rogergcc.zemogaandroidmobiletest.domain.repository.PostRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Created on mayo.
 * year 2022 .
 */
class ReadPostsUseCaseTest{

    @RelaxedMockK
    private lateinit var  postRepository: PostRepository

    lateinit var readPostsUseCase: ReadPostsUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        readPostsUseCase= ReadPostsUseCase(postRepository)
    }
    @Test
    fun `when de api doent return anythin the get values from database`()= runBlocking {

        //Given
        coEvery { postRepository.getPosts() }
    }


}