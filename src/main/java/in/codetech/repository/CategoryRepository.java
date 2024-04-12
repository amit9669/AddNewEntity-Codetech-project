package in.codetech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.codetech.model.exam.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
