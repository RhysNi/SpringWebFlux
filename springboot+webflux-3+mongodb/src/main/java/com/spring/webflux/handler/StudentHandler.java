package com.spring.webflux.handler;

import com.spring.webflux.entity.Student;
import com.spring.webflux.respository.StudentRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 17:27
 * @email rhys.ni@softtek.com
 */
@Component
public class StudentHandler {
    final StudentRepository studentRepository;

    public StudentHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //新建一个初始值为0的AtomicLong
    private static final AtomicLong idGenerator = new AtomicLong(0);

    public Mono<Student> save(Student student) {
        Long id= idGenerator.incrementAndGet();
        student.setId(id);
        return studentRepository.insert(student);
    }

    public Mono<Long> delete(Long id) {
        return studentRepository.deleteById(id).flatMap(mono -> Mono.create(StudentMonoSink -> StudentMonoSink.success(id)));
    }

    public Mono<Student> update(Student student) {
        return studentRepository.save(student);
    }

    public Mono<Student> queryStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Flux<Student> queryAllStudent() {
        return studentRepository.findAll();
    }
}
