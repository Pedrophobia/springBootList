package com.lab.mvc.springbootlist.controller;

import com.lab.mvc.springbootlist.model.Product;
import com.lab.mvc.springbootlist.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("listProducts", service.listAll());
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result,
                              RedirectAttributes attr) {
        if (result.hasErrors()) {
            if (product.getId() == null) {
                return "new_product";
            }
            return "edit_product";
        }
        service.save(product);
        attr.addFlashAttribute("success", "Registro salvo com sucesso!");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes attr) {
        Product product = service.findById(id);
        if (product == null) {
            attr.addFlashAttribute("fail", "Produto não encontrado.");
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "edit_product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.delete(id);
        attr.addFlashAttribute("success", "Registro excluído com sucesso!");
        return "redirect:/products";
    }
}
