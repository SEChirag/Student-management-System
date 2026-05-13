package com.test.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "student")
@NoArgsConstructor
public class Model {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    @Getter
    private String name;
    @Setter
    private long marks;
    @Setter
    @Getter
    private String section;
    @Setter
    @Getter
    private  String result;


    public Model(long id, String name , long marks ,String section , String result) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.section=section;
        this.result = result;


    }

    public void setId(long id) {
        this.id = id;
    }

    public long getmarks() {
        return marks;
    }

    public long getEven() {
        return id;
    }

}
