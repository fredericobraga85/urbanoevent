package com.urbanoevent

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.urbanoevent.database.AppDatabase
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanEventRepositoryImpl
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.observers.TestObserver
import io.reactivex.subscribers.TestSubscriber
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by cinq on 31/01/18.
 */
@RunWith(AndroidJUnit4::class)
class UrbanoEventRepositoryTest {


    var urbanoEventRepository : UrbanEventRepository? = null

    @Before
    fun setup() {

        val c = InstrumentationRegistry.getTargetContext()

        val database = Room.databaseBuilder(c, AppDatabase::class.java, "urban_event_db").allowMainThreadQueries().build()
        urbanoEventRepository = UrbanEventRepositoryImpl(database.urbanoEventDao())
    }

    @After
    fun tearDown() {

    }

    @Test
    fun test_should_Insert_UrbanoEvent() {

        var ue = UrbanoEvent()
        ue.id = 99L
        ue.title = "title_" + ue.id
        ue.desc = "desc_" + ue.id

        urbanoEventRepository?.addUrbanoEvent(ue)

        var resultObs = urbanoEventRepository?.getUrbanEvent(99)

        val testObserver = TestObserver<UrbanoEvent>()
        resultObs?.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val result  = testObserver.values()[0]

        assertEquals(result.title, "deu errado")

    }

//    @Test
//    fun should_Flush_All_Data(){
//        foodDao?.flushFoodData()
//        Assert.assertEquals(foodDao?.getFoodsCount(), 0)
//    }

//    // Copied from stackoverflow
//    @Throws(InterruptedException::class)
//    fun <T> getValue(liveData: LiveData<T>): T {
//        val data = arrayOfNulls<Any>(1)
//        val latch = CountDownLatch(1)
//        val observer = object : Observer<T> {
//            override fun onChanged(t: T?) {
//                data[0] = t
//                latch.countDown()
//                liveData.removeObserver(this)//To change body of created functions use File | Settings | File Templates.
//            }
//
//        }
//        liveData.observeForever(observer)
//        latch.await(2, TimeUnit.SECONDS)
//
//        return data[0] as T
//    }
}