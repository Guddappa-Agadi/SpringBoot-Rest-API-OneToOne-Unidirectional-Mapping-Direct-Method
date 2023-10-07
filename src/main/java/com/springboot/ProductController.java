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
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository cr;

	@PostMapping("/add")
	public <S extends Product> S save(@RequestBody S entity) {
		return cr.save(entity);
	}

	@GetMapping("/get/page/sort")
	public List<Product> findAll(Sort sort) {
		return cr.findAll(sort);
	}

	@GetMapping("/get/page")
	public Page<Product> findAll(Pageable pageable) {
		return cr.findAll(pageable);
	}

	@GetMapping("/get")
	public List<Product> findAll() {
		return cr.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<Product> findById(@PathVariable("id") Integer product_id) {
		return cr.findById(product_id);
	}

	@PutMapping("/get/{id}")
	public Product findById(@PathVariable("id") Integer product_id, @RequestBody Product c) {
		return cr.save(c);
	}

	@DeleteMapping("/get/{id}")
	public void deleteById(@PathVariable("id") Integer product_id) {
		cr.deleteById(product_id);
	}

}
