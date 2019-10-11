package com.course.testng.groups

import org.testng.annotations.AfterGroups
import org.testng.annotations.BeforeGroups
import org.testng.annotations.Test

class GroupsOnMethod {
    @Test(groups = arrayOf("server"))
    fun test1() {
        println("服务端组的测试方法一")
    }

    @Test(groups = arrayOf("server"))
    fun test2() {
        println("服务端组的测试方法二")

    }

    @Test(groups = arrayOf("client"))
    fun test3() {
        println("客户端组的测试方法一")

    }

    @Test(groups = arrayOf("client"))
    fun test4() {
        println("客户端组的测试方法二")

    }

    @BeforeGroups("server")
    fun beforeGroupsOnServer() {
        println("beforeGroupsOnServer运行了")
    }

    @AfterGroups("server")
    fun afterGroupsOnServer() {
        println("afterGroupsOnServer运行了")
    }

    @BeforeGroups("client")
    fun beforeGroupsOnClient() {
        println("beforeGroupsOnServer运行了")
    }

    @AfterGroups("client")
    fun afterGroupsOnClient() {
        println("afterGroupsOnServer运行了")
    }
}
