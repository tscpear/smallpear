package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("服务端组的测试方法一");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("服务端组的测试方法二");

    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("客户端组的测试方法一");

    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("客户端组的测试方法二");

    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("beforeGroupsOnServer运行了");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("afterGroupsOnServer运行了");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("beforeGroupsOnServer运行了");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("afterGroupsOnServer运行了");
    }
}
