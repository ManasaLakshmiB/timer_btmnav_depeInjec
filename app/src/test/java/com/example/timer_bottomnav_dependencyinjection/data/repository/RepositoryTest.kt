package com.example.timer_bottomnav_dependencyinjection.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayItemModel
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.data.remote.HolidayCall
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepositoryTest {

    // allow me to use the threads
    private val testDispatcher = StandardTestDispatcher()

    // allow me to run tasks on threads with priority
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    lateinit var repository: Repository

    @Mock
    lateinit var holidayCall: HolidayCall

    @Before
    fun startup() {
        MockitoAnnotations.openMocks(this)//Initialize all the mocks that we have in THIS class
        Dispatchers.setMain(testDispatcher)//assume this as the mian thread for testing
        repository = RepositoryImpl(holidayCall)
    }

//    @After
//    fun clear() {
//        Mockito.clearAllCaches()
//    }

    @Test
    fun getHolidayModel_Success() = runTest{

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

        val Holiday_samplelist = HolidayModel()
        Holiday_samplelist.addAll(mockresponse)

            `when`(holidayCall.getHolidayModel()).thenReturn(Holiday_samplelist)

            val result = repository.getHolidayModel()

           assertEquals(result.get(0).global ,mockresponse.get(0).global)
            assertEquals(result.get(0).localName ,mockresponse.get(0).localName)
        }
    }
