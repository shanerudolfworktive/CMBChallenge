package com.shanerudolf.cbmcodechalllenge

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.shanerudolf.cbmcodechalllenge.models.TeamModel
import com.shanerudolf.cbmcodechalllenge.utils.Const
import com.shanerudolf.cbmcodechalllenge.utils.FileUtil
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.shanerudolf.cbmcodechalllenge", appContext.packageName)
    }
}
