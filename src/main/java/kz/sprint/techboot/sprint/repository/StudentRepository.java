package kz.sprint.techboot.sprint.repository;

import kz.sprint.techboot.sprint.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    List<Student> findAllByOrderByExamDesc();

    @Query(value = "SELECT st " +
            "FROM Student st " +
            "WHERE LOWER(st.name) LIKE LOWER( :searchName) " +
            "ORDER BY st.exam DESC ")
    List<Student> searchStuds(@Param("searchName") String gameName);
}
