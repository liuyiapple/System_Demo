package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    //  创建StudentDao
    private StudentDao studentDao = new StudentDao();
    public static boolean isExists(String  id) {
        Student[] stus = StudentDao.findAllStudent();
        boolean exit = false;
        for (int i = 0; i < stus.length; i++) {
            Student student =  stus[i];
            if(student != null && student.getId().equals(id)) {
                exit = true;
                break;
            }
        }
        return exit;
    }

    public boolean addStudent(Student stu) {
        // 将学生对象，传递给StudentDao 库概念中的addStudent
        return studentDao.addStudent(stu);
        // 将返回的boolean类型结果，返还给StudentController


    }

    public Student[] findAllStudent() {
        // 获取到所有的学生对象数组
        Student[] allStudents =  studentDao.findAllStudent();
        // 遍历学生对象
        boolean flag = false;
        for (int i = 0; i < allStudents.length; i++) {
            Student student = allStudents[i];
            if(student != null) {
                flag = true;
                break;
            }
        }
        if(flag) {
            return allStudents;
        }else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newStu) {

        studentDao.updateStudent(updateId,newStu);

    }
}
