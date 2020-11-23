package com.spring.webflux.controller;

import com.spring.webflux.entity.Student;
import com.spring.webflux.handler.StudentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 18:18
 * @email rhys.ni@softtek.com
 */
@RestController
@RequestMapping(value = "/student")
public class StudentWebFluxController {
    @Autowired
    private final StudentHandler studentHandler;


    public StudentWebFluxController(StudentHandler studentHandler) {
        this.studentHandler = studentHandler;
    }

    @PostMapping(value = "/saveStudent")
    public Mono<Student> saveStudent(@RequestBody Student student) {
        return studentHandler.save(student);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteStudentById(@PathVariable("id") Long id) {
        return studentHandler.delete(id);
    }

    @PutMapping(value = "/update")
    public Mono<Student> update(@RequestBody Student student) {
        return studentHandler.update(student);
    }

    @GetMapping(value = "/queryAllStudent")
    public Flux<Student> queryAllStudent() {
        return studentHandler.queryAllStudent();
    }

    @GetMapping(value = "/{id}")
    public Mono<Student> queryStudentById(@PathVariable("id") Long id) {
        return studentHandler.queryStudentById(id);
    }
}
