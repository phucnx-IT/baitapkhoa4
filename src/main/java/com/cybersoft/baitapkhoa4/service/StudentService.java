package com.cybersoft.baitapkhoa4.service;

import com.cybersoft.baitapkhoa4.model.Student;
import com.cybersoft.baitapkhoa4.service.imp.StudentServiceImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceImp {
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> createNewStudent(Student student) {
        studentList.add(student);
        return studentList;
    }

    @Override
    public List<Student> createNewStudent(String name, Byte age) {
        Student newStudent = Student.builder().name(name).age(age).build();
        studentList.add(newStudent);
        return studentList;
    }
}
