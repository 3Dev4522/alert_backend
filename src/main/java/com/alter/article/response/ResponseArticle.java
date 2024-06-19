package com.alter.article.response;

import java.time.LocalDateTime;

public record ResponseArticle(
        String title,
        String content,
        LocalDateTime created
) {
}
