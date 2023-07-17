package com.cybersoft.baitapkhoa4.service.imp;

import com.cybersoft.baitapkhoa4.model.Student;

import java.util.List;

public interface StudentServiceImp {
    List<Student> createNewStudent(Student student);
    List<Student> createNewStudent(String name, Byte age);
}
