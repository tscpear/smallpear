package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1() {
        System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethid() {
        System.out.println("这是测试方法前运行的");
    }

    @AfterMethod
    public void afterMethid() {
        System.out.println("这是再测试方法之后运行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类之后运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是在类之前运行的");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
