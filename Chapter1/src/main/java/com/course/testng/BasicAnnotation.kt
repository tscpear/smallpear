package com.course.testng

import org.testng.annotations.*

class BasicAnnotation {
    @Test
    fun testCase1() {
        println("这是测试用例1")
    }

    @Test
    fun testCase2() {
        println("这是测试用例2")
    }

    @BeforeMethod
    fun beforeMethid() {
        println("这是测试方法前运行的")
    }

    @AfterMethod
    fun afterMethid() {
        println("这是再测试方法之后运行的")
    }

    @BeforeClass
    fun beforeClass() {
        println("这是在类之后运行的")
    }

    @AfterClass
    fun afterClass() {
        println("这是在类之前运行的")
    }

    @BeforeSuite
    fun beforeSuite() {
        println("beforeSuite测试套件")
    }

    @AfterSuite
    fun afterSuite() {
        println("afterSuite测试套件")
    }
}
