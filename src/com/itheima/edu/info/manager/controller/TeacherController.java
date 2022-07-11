package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Teacher;
import com.itheima.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();

    public void start() {
        TeacherLoop:
        while (true) {
            System.out.println("-------欢迎来到<老师>管理系统------------");
            System.out.println("请输入你的选择： 1.添加老师 2. 删除老师 3. 修改老师 4. 查看老师 5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    // System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    // System.out.println("删除老师");
                    deleteTeacherById();
                    break;
                case "3":
                    // System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
                    // System.out.println("查看老师");
                    findAllTeachers();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统");
                    break TeacherLoop;
                default:
                    System.out.println("没有相关操作");

            }
        }
    }

    private void updateTeacher() {
        String id = inputTeacherId();
        Teacher newTeacher =  inputTeacherInfo(id);

        teacherService.updateTeacher(id,newTeacher);
        System.out.println("修改成功");
    }

    public void deleteTeacherById() {
       String id = inputTeacherId();
        teacherService.deleteTeacherById(id);
        System.out.println("删除成功");
    }

    public void findAllTeachers() {
        Teacher[] teachers = teacherService.findAllTeachers();
        if (teachers == null) {
            System.out.println("没有老师信息");
            return;
        }

        // 遍历数组
        System.out.println("学号\t姓名\t年龄\t生日");
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null) {
                System.out.println(t.getId() + "\t" + t.getName() + "\t" + t.getAge() + "\t" + t.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("请输入老师的ID");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if (exists) {
                System.out.println("当前工号已被占用，请重新输入");
            } else {
                break;
            }
        }
        Teacher t =  inputTeacherInfo(id);

        boolean result = teacherService.addTeacher(t);
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }


    // 封装 输入id查找id 的方法
    public String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("请输入老师Id");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if (!exists) {
                System.out.println("当前没有Id，请重新输入");
            } else {
                break;
            }
        }
        return id;
    }


    // 封装老师对象
    public  Teacher inputTeacherInfo (String id) {
        System.out.println("请输入老师的姓名");
        String name = sc.next();
        System.out.println("请输入老师的年龄");
        int age = sc.nextInt();
        System.out.println("请输入老师的生日");
        String birthday = sc.next();

        // 封装成老师的额对象
        Teacher t = new Teacher();

        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setBirthday(birthday);
        return t;
    }
}
