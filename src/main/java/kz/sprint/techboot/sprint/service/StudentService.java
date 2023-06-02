package kz.sprint.techboot.sprint.service;

import kz.sprint.techboot.sprint.model.Student;
import kz.sprint.techboot.sprint.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents(String key){
//        return studentRepository.findAllByOrderByExamDesc();
        return studentRepository.searchStuds("%"+key+"%");
    }

    public Student addStudent(Student student){
        if(student.getExam()<50){
            student.setMark("F");
        } else if (student.getExam()<60) {
            student.setMark("D");
        } else if (student.getExam()<75) {
            student.setMark("C");
        } else if (student.getExam()<90) {
            student.setMark("B");
        } else if (student.getExam()<100){
            student.setMark("A");
        }
        return studentRepository.save(student);
    }
}
