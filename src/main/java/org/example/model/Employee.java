package org.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marks_id", referencedColumnName = "id")
    private Marks marks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public org.example.model.Address getAddress() {
        return address;
    }

    public void setAddress(org.example.model.Address address) {
        this.address = address;
    }

    public org.example.model.Marks getMarks() {
        return marks;
    }

    public void setMarks(org.example.model.Marks marks) {
        this.marks = marks;
    }
}