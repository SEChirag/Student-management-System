package com.test.Service;

import com.test.Entity.Model;
import com.test.Exceptions.StudentNotFoundException;
import com.test.Repository.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final repository Repo;

    public StudentService(repository Repo) {
        this.Repo = Repo;
    }

    public List<Model> getAllStudents(){
        return Repo.findAll();
    }

    public Model getbyid(Long id) throws Exception {
        return Repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Id not found->"+id));
    }

    public List<Model> addStudent(List<Model> model) {
        return Repo.saveAll(model);

    }

    public List<Model> updateStudent(List<Model> model) {
        return Repo.saveAll(model);
    }

    public  void deleteStudent(long id){
       Model student = Repo.findById(id).orElseThrow(()->new StudentNotFoundException("Id not found->"+id+"->you can't delete"));
Repo.delete(student);
        }

    public void deleteAllStudents() {
        Repo.deleteAll();
    }

    public List<Model> getEvenId() {
            return Repo.findAll()
                .stream()
                .filter(a -> a.getEven() % 2 == 0)
                .toList();
    }
    public Page<Model> getStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return Repo.findAll(pageable);
    }
}
