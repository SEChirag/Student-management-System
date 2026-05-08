package com.test.Repository;

import com.test.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repository extends JpaRepository<Model, Long> {
}
