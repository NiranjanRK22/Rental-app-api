package com.rentalapp.service;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.Category;


public interface ICategoryService {

    Category addCategory(Category category);
    void updateCategory(Category category);
    Category getCategoryById(int categoryId) throws PropertyNotFoundException;
    void deleteCategory(int categoryId);
}
