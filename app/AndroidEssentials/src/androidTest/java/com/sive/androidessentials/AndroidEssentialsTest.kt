package com.sive.androidessentials

import android.app.Instrumentation
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase

class AndroidEssentialsTest : TestCase() {
    
    fun testGetValueBoolean() {
        assertTrue(AndroidEssentials.getValueBoolean(InstrumentationRegistry.getInstrumentation().targetContext, "siveLong", InstrumentationRegistry.getInstrumentation().targetContext.packageName ))

    }

    fun testGetValueInt() {

        assertEquals(0, AndroidEssentials.getValueInt(InstrumentationRegistry.getInstrumentation().targetContext, "siveInt", InstrumentationRegistry.getInstrumentation().targetContext.packageName ))

    }
    fun testGetValueLong(){
        assertEquals(0, AndroidEssentials.getValueLong(InstrumentationRegistry.getInstrumentation().targetContext, "siveLong", InstrumentationRegistry.getInstrumentation().targetContext.packageName ))

    }

    fun testGetValueDouble() {
        assertEquals(0, AndroidEssentials.getValueDouble(InstrumentationRegistry.getInstrumentation().targetContext, "siveLong", InstrumentationRegistry.getInstrumentation().targetContext.packageName ))


    }

    fun testGetValueString() {

        assertEquals("none", AndroidEssentials.getValueString(InstrumentationRegistry.getInstrumentation().targetContext, "siveLong", InstrumentationRegistry.getInstrumentation().targetContext.packageName ))

    }



    fun testCheckFileExistence() {
        assertFalse(AndroidEssentials.checkFileExistence(InstrumentationRegistry.getInstrumentation().targetContext, "siveFileAndroidEssentials"))

    }


    fun testGetFileContents() {
        assertEquals("none", AndroidEssentials.getFileContents("siveFileAndroidEssentials",  InstrumentationRegistry.getInstrumentation().targetContext))

    }

    fun testGetUserCountry() {
        AndroidEssentials.getUserCountry(InstrumentationRegistry.getInstrumentation().targetContext)
            ?.let { assertEquals(2, it.length) }
    }

    fun testCheckConnection() {
        assertTrue(AndroidEssentials.checkConnection(InstrumentationRegistry.getInstrumentation().targetContext))

    }
}