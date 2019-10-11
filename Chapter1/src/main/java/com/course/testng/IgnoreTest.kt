package com.course.testng

import org.testng.annotations.Test

class IgnoreTest {
    @Test
    fun ignore1() {
        println("ignore1  执行！")
    }

    @Test(enabled = false)
    fun ignore2() {
        println("ignore2 执行！")
    }
}
