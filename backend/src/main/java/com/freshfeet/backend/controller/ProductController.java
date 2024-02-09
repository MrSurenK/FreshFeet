package com.freshfeet.backend.controller;

import com.freshfeet.backend.model.Product;
import com.freshfeet.backend.model.ProductItem;
import com.freshfeet.backend.repository.ProductItemRepository;
import com.freshfeet.backend.repository.ProductRepository;
import com.freshfeet.backend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path="test")
public class ProductController {
    @Autowired //comment
    private ProductRepository productRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private StorageService storageService;

    //@RequestParam MultipartFile file
    // Just a test controller. Refactor when implementing (File stored in folder and path in database)
    @PostMapping(path = "Product")
    public @ResponseBody String addNewProduct(@RequestBody Set<ProductItem> sku, @RequestBody String name) {
        Product n = new Product();
        n.setName(name);
//        n.setProductSKU(sku);
//        n.setProductImage(storageService.uploadProductImage(file));
        productRepository.save(n);

        return "Saved";
    }


//@PostMapping(path = "ProductItem")
//    public @ResponseBody String addNewProductItem(@RequestParam String sku, @RequestParam BigDecimal price) {
//        ProductItem n = new ProductItem();
//        n.setSku(sku);
//        n.setPrice(price);
//        Product m = new Product();
//        m.addProductSku(sku);
//
//
//        productItemRepository.save(n);
//
//        return "Saved Data";
//
//    }


//    @PostMapping("/productItems")
//    public ProductItem createProductItem(@RequestBody ProductItem productItem, @RequestParam Long productId) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
//
//        productItem.setProduct(product);
//        return productItemRepository.save(productItem);
//    }

}

