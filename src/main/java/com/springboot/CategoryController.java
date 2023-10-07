package com.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepository cr;

	@PostMapping("/add")
	public <S extends Category> S save(@RequestBody S entity) {
		return cr.save(entity);
	}

	@GetMapping("/get/page/sort")
	public List<Category> findAll(Sort sort) {
		return cr.findAll(sort);
	}

	@GetMapping("/get/page")
	public Page<Category> findAll(Pageable pageable) {
		return cr.findAll(pageable);
	}

	@GetMapping("/get")
	public List<Category> findAll() {
		return cr.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<Category> findById(@PathVariable("id") Integer category_id) {
		return cr.findById(category_id);
	}

	@PutMapping("/get/{id}")
	public Category findById(@PathVariable("id") Integer category_id, @RequestBody Category c) {
		return cr.save(c);
	}

	@DeleteMapping("/get/{id}")
	public void deleteById(@PathVariable("id") Integer category_id) {
		cr.deleteById(category_id);
	}

}
