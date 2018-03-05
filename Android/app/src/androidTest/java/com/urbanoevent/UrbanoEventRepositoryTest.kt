package com.urbanoevent

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.urbanoevent.database.RoomDB
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanEventRepositoryImpl
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by cinq on 31/01/18.
 */
@RunWith(AndroidJUnit4::class)
class UrbanoEventRepositoryTest {


    var urbanoEventRepository : UrbanEventRepository? = null

    @Before
    fun setup() {

        val c = InstrumentationRegistry.getTargetContext()

        urbanoEventRepository = UrbanEventRepositoryImpl(c)
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

        var resultObs =  urbanoEventRepository?.addUrbanoEvent(ue)
                ?.flatMap { urbanoEventRepository?.getUrbanEvent(99L) }



        val testObserver = TestObserver<UrbanoEvent>()
        resultObs?.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val result  = testObserver.values()[0]

        assertEquals(result.id, 99L)
        assertEquals(result.title, "title_99")
        assertEquals(result.desc, "desc_99")

    }
}