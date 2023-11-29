package co.edu.cue.GallegoShop.mapper.dtos;

import co.edu.cue.GallegoShop.domain.enums.Category;
import lombok.Builder;

public record ProductDto(
        Integer productId,
        String productName,
        String description,
        Integer price,
        Integer stock,
        Category category,
        String image
) {
}
