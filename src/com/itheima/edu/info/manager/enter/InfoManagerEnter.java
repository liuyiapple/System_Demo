package com.itheima.edu.info.manager.enter;

import com.itheima.edu.info.manager.controller.StudentController;
import com.itheima.edu.info.manager.controller.TeacherController;

import java.util.Scanner;

public class InfoManagerEnter {
    public static void main(String[] args) {
        // 主菜单搭建
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("请输入你的选择：1.学生管理 2.老师管理 3.退出");
            Scanner sc = new Scanner(System.in);
            String choose =  sc.next();
            switch (choose) {
                case "1":
                    System.out.println("学生管理");
                    StudentController controller = new StudentController();
                    controller.start();
                    break;
                case "2":
                   // System.out.println("老师管理");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("暂未匹配到您的选择");

            }
        }


    }
}
