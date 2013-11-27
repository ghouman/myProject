package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryMapper {

    public List<Category> getAllCategory(String plate);

    public List<Category> getBrandByCategoryId(String categoryId);

    public List<Category> getFamilyByBrandId(String brandId);

    public List<Category> getPartNoByFamilyId(String familyId);
}
