package com.shanerudolf.cbmcodechalllenge.utilTest

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.shanerudolf.cbmcodechalllenge.models.TeamModel
import com.shanerudolf.cbmcodechalllenge.utils.Const
import com.shanerudolf.cbmcodechalllenge.utils.FileUtil
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before



/**
 * Created by shane1 on 2/9/18.
 */
@RunWith(AndroidJUnit4::class)
class FileUtilTest{

    private var appContext: Context? = null

    @Before
    fun setup() {
        appContext = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun testFileUtilWithCorrectPath() {
        val teamModel = FileUtil.readJSONFromAssets<List<TeamModel>>(appContext!!, Const.teamJsonFilePath)
        Assert.assertNotNull(teamModel)
    }

    @Test
    fun testFileUtilWithWrongPath() {
        val teamModel = FileUtil.readJSONFromAssets<List<TeamModel>>(appContext!!, "abc")
        Assert.assertNull(teamModel)
    }

    @Test
    fun testFileUtilWithWrongDataType() {
        val teamModel = FileUtil.readJSONFromAssets<TeamModel>(appContext!!, Const.teamJsonFilePath)
        Assert.assertNull(teamModel)
    }
}