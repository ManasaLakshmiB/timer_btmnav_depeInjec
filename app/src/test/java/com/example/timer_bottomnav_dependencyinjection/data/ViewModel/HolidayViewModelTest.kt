package com.example.timer_bottomnav_dependencyinjection.data.ViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayItemModel
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.data.repository.Repository
import com.example.timer_bottomnav_dependencyinjection.ui.holiday.HolidayViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class HolidayViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var repository: Repository

    lateinit var viewModel: HolidayViewModel
    @Before
    fun startup(){
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)

            viewModel = HolidayViewModel(repository)
    }
    @Test
    fun verifyHolidayItemModelSuccess()= runTest {

        val mockresponse = listOf(
            HolidayItemModel(
                countryCode ="USA",
           global=true,
           localName="USA"
            ),
            HolidayItemModel(
                countryCode ="USA",
                global=true,
                localName="USA"
            ),

        )

        val Holiday_sample = HolidayModel()
        Holiday_sample.addAll(mockresponse)

        Mockito.`when`(repository.getHolidayModel()).thenReturn(Holiday_sample)
        viewModel.getHolidayData()

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(viewModel.HolidayliveData.value?.get(1)?.countryCode, Holiday_sample.get(0).countryCode)
        assertEquals(viewModel.HolidayliveData.value?.get(1)?.global, Holiday_sample.get(0).global)
        assertEquals(viewModel.HolidayliveData.value?.get(1)?.localName, Holiday_sample.get(0).localName)




    }
}