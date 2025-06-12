package com.dhh.recomendador.financial_recommendation_api.mapper;

import com.dhh.recomendador.financial_recommendation_api.model.Product;
import com.dhh.recomendador.financial_recommendation_api.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductDTO toDto(Product product);

    Product toEntity(ProductDTO productDto);
}
