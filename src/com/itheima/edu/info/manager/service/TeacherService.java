package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {
    private TeacherDao teacherDao = new TeacherDao();

    public boolean addTeacher(Teacher t) {
        return TeacherDao.addTeacher(t);
    }

    public boolean isExists(String id) {
//        return TeacherDao.isExists(id);
        boolean exists = false;
        Teacher[] teachers = TeacherDao.findAllTeacher();
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher != null && teacher.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeachers() {
        Teacher[] teachers = teacherDao.findAllTeacher();
        boolean flag = false;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher != null) {
                flag = true;
                break;
            }
        }
        if (flag) {

            return teachers;
        } else {
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void updateTeacher(String id, Teacher newTeacher) {
        teacherDao.updateTeacher(id,newTeacher);
    }
}
