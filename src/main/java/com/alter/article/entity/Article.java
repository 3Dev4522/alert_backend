package com.alter.article.entity;

import com.alter.category.entity.SubCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "sub_category", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;

    private String hostname;
    private String ai;
    private String original;
    private String href;

    @Column(nullable = false)
    private LocalDateTime created;

    public Article (SubCategory subCategory, String hostname, String ai, String original, String href, LocalDateTime created) {
        this.subCategory = subCategory;
        this.hostname = hostname;
        this.ai = ai;
        this.original = original;
        this.href = href;
        this.created = created;
    }
}
