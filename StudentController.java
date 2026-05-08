package com.test.Controller;

import com.test.Entity.Model;
import com.test.Service.StudentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@CrossOrigin("*")
@RestControllerAdvice
@RestController
@RequestMapping("/API")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

@GetMapping("/all")
public List<Model> getAllStudents(){
    return service.getAllStudents()
            .stream()
            .sorted((a, b) -> Long.compare(a.getId(), b.getId()))
            .toList();
    }
@GetMapping("/{id}")
    public Model getbyid(@PathVariable Long id) throws  Exception {
        return service.getbyid(id);
    }
@PostMapping("/add")
public List<Model> addStudent(@RequestBody List<Model> model) {
        return service.addStudent(model);
}
@PutMapping("/update")
    public List<Model> updateStudent(@RequestBody List<Model> model) {
        return service.updateStudent(model);
}

@DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable long id) throws Exception {
        service.deleteStudent(id);
}
@DeleteMapping("/allDelete")
    public void deleteAllStudents() {
        service.deleteAllStudents();
}
@GetMapping("/getEven")
    public List<Model> getEvenId(){
            return service.getEvenId();

}
    @GetMapping("/students")
    public Page<Model> getStudents(@RequestParam int page, @RequestParam int size) {

        return service.getStudents(page, size);
    }
}
