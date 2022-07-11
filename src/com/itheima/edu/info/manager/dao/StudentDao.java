package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] stus = new Student[5];

    public boolean addStudent(Student stu) {
        // 1.创建一个学生的数组
        // 定义一个index为 -1 的变量
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            // 把每一项都取出来
            Student student = stus[i];
            // 查看取到的这一项是不是等于null
            if (student == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        } else {
            stus[index] = stu;
            return true;
        }

    }

    public static Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delId) {
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null && stu.getId().equals(delId)) {
                stus[i] = null;
            }
        }
    }

    public int getIndex(String id) {
        int Index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu.getId().equals(id)) {
                Index = i;
                break;
            }
        }
        return Index;
    }


    public void updateStudent(String updateId, Student newStu) {
        int index =  getIndex(updateId);
        stus[index] = newStu;
//        for (int i = 0; i < stus.length; i++) {
//            Student stu = stus[i];
//            if (stu.getId().equals(updateId)) {
//                stus[i] = newStu;
//                break;
//            }
//        }
    }
}
