package lt.romas.esms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.romas.esms.data.entity.Product;
import lt.romas.esms.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/findByGroupId/{groupId}", method = RequestMethod.GET)
	private List<Product> findByGroupId(@PathVariable("groupId") Integer groupId) {
		return productService.findByGroupId(groupId);
	}
}
