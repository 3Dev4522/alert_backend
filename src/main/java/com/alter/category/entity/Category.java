package com.alter.category.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category {

    @Id
    private String id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "parent", cascade = { CascadeType.PERSIST })
    private List<SubCategory> subs = new ArrayList<>();

}
