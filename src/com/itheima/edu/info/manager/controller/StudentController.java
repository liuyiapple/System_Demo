package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private static StudentService studentService = new StudentService();
    private static Scanner sc = new Scanner(System.in);

    public void start() {
        studentLoop:
        while (true) {
            System.out.println("--------欢迎来到<学生>管理系统-----");
            System.out.println("请输入你的选择： 1. 添加学生 2.删除学生 3. 修改学生 4.查看学生 5. 退出");
            String choose = sc.next();
            switch (choose) {
                case "1":
                    // System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    // System.out.println("删除学生");
                    deleteStudentById();
                    break;
                case "3":
                    // System.out.println("修改学生");
                    updateStudent();
                    break;
                case "4":
                    // System.out.println("查看学生");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统");
                    break studentLoop;
                default:
                    System.out.println("暂未找到匹配项");
            }
        }
    }

    public void updateStudent() {
        Student[] stus = studentService.findAllStudent();
        // 2. 判断数组的内存地址，是否为null
        if (stus == null) {
            System.out.println("暂无学生信息，请添加后重试");
            return;
        }
        String updateId = inputStudentId();
        Student newStu = inputStudentInfo(updateId);
        studentService.updateStudent(updateId, newStu);
        System.out.println("求该成功");
    }

    public void deleteStudentById() {
        Student[] stus = studentService.findAllStudent();
        // 2. 判断数组的内存地址，是否为null
        if (stus == null) {
            System.out.println("暂无学生信息，请添加后重试");
            return;
        }
        String delId = inputStudentId();

        studentService.deleteStudentById(delId);
        System.out.println("删除学生成功");

    }

    public void findAllStudent() {
        // 1. 调用业务员中的获取方法，得到学生的对象数组
        Student[] stus = studentService.findAllStudent();
        // 2. 判断数组的内存地址，是否为null
        if (stus == null) {
            System.out.println("暂无学生信息，请添加后重试");
            return;
        }
        // 3. 遍历数组，最终打印在控制套
        System.out.println("学号\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
            }
            System.out.println();
        }
    }


    // 添加学生信息
    public static void addStudent() {
        String id;
        while (true) {
            System.out.println("请添加学生id");
            id = sc.next();
            boolean flag = StudentService.isExists(id);
            if (flag) {
                System.out.println("当前学生Id已经存在，请重新添加");
            } else {
                break;
            }
        }
        Student newStu = inputStudentInfo(id);
        studentService.addStudent(newStu);
    }


    // 键盘录入学生Id
    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("请输入你要删除的学生Id");
            // 首先键盘录入需要删除的Id
            id = sc.next();
            // 调用studentService的isExists方法，查看当前输入的Id是否存在
            boolean exist = studentService.isExists(id);
            if (!exist) {
                System.out.println("当前Id不存在");
            } else {
                break;
            }
        }
        return id;
    }


    // 输入学生信息

    public static Student inputStudentInfo(String id) {

        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生的生日");

        String birthday = sc.next();

        Student newStu = new Student();
        newStu.setId(id);
        newStu.setName(name);
        newStu.setAge(age);
        newStu.setBirthday(birthday);
        return newStu;
    }
}
