package com.alter.category.response;

import java.util.List;

public record ResponseCategory(String name, List<ResponseSub> subs) {
}
