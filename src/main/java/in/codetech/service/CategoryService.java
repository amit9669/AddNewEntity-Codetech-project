package in.codetech.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import in.codetech.model.exam.Category;

@Service
public interface CategoryService {

public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getCategory(Long categoeyId);
	
	public void deleteCategory(Long categoryId);


}
