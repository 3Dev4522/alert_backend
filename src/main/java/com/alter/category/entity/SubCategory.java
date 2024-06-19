package com.alter.category.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SubCategory {

    @Id
    private String name;

    @Column(nullable = false, name = "value")
    private String unique;

    @JoinColumn(name =  "parent")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;

    @Column(name = "avatar", nullable = false)
    private String avatar;

}
