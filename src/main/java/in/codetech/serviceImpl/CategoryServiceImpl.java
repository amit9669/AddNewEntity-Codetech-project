package in.codetech.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.model.exam.Category;
import in.codetech.repository.CategoryRepository;
import in.codetech.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoeyId) {
		return this.categoryRepository.findById(categoeyId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		this.categoryRepository.delete(category);
		
	}

}
