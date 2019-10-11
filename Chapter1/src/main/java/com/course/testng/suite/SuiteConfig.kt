package com.course.testng.suite

import org.testng.annotations.*

class SuiteConfig {
    @BeforeSuite
    fun beforeSuite() {
        println("beforeSuite运行了")
    }

    @AfterSuite
    fun afterSuite() {
        println("afterSuite运行了")
    }

    @AfterTest
    fun afterTest() {
        println("afterTest运行了")
    }

    @BeforeTest
    fun beforeTest() {
        println("beforeTest运行了")
    }
}
