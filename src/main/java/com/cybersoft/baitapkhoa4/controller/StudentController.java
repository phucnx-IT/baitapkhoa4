package com.cybersoft.baitapkhoa4.controller;

import com.cybersoft.baitapkhoa4.common.ResponseHelper;
import com.cybersoft.baitapkhoa4.model.Student;
import com.cybersoft.baitapkhoa4.service.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImp studentService;

    @PostMapping("/requestparam")
    public ResponseEntity<?> createNewStudentWithRequestParam(@RequestParam(required = true) String name, @RequestParam (defaultValue = "18") Byte age){
        List<Student> studentList = studentService.createNewStudent(name, age);
        return ResponseHelper.getResponse(studentList, HttpStatus.CREATED);
    }

    @PostMapping("/requestbody")
    public ResponseEntity<?> createNewStudentWithRequestBody(@RequestBody Student student){
        List<Student> studentList = studentService.createNewStudent(student);
        return ResponseHelper.getResponse(studentList,HttpStatus.CREATED);
    }

    @PostMapping("/pathvariable/{name}/{age}")
    public ResponseEntity<?> createNewStudentWithRequestBody(@PathVariable String name, @PathVariable Byte age){
        List<Student> studentList = studentService.createNewStudent(name, age);
        return ResponseHelper.getResponse(studentList,HttpStatus.CREATED);
    }
}
