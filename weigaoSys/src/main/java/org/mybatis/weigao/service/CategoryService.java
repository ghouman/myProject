package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.Category;
import org.mybatis.weigao.persistence.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAllCategory(String plate) {
        return categoryMapper.getAllCategory(plate);
    }

    public List<Category> getBrandByCategoryId(String categoryId) {
        return categoryMapper.getBrandByCategoryId(categoryId);
    }

    public List<Category> getFamilyByBrandId(String brandId) {
        return categoryMapper.getFamilyByBrandId(brandId);
    }

    public List<Category> getPartNoByFamilyId(String familyId) {
        return categoryMapper.getPartNoByFamilyId(familyId);
    }
}
