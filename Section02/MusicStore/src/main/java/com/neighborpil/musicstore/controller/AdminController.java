package com.neighborpil.musicstore.controller;

import com.neighborpil.musicstore.dao.ProductDao;
import com.neighborpil.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/admin")
    public String addProduct() throws Exception {

        return "admin";
    }

    @GetMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDao.getAllProduct();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @GetMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("New");
        product.setProductStatus("Active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @PostMapping("/admin/productInventory/addProduct")
    public String addProductPost(@ModelAttribute("product") @Valid Product product, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "addProduct";
        }

        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();

        /*
        // 리얼서버에서 webapps 폴더 외에 저장하는 법
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "images");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        String path = dir.getAbsolutePath() + File.separator + product.getProductId() + ".png";

        // 실제 파일 저장할 때에 파일 확장자 설정법
//      java.util.Date date= new java.util.Date();
//      String path = dir.getAbsolutePath() + File.separator
//                + (new Timestamp(date.getTime())).toString().replace(":", "").toString()
//                .replace(".", ".").toString()
//                .replace(" ","").toString()
//                .replace("-","").toString()+".png";
        */

        // 개발서버에 저장하는 법
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable String productId, HttpServletRequest request, Model model) throws Exception{

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        productDao.deleteProduct(productId);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {
        Product product = productDao.getProductById(id);

        model.addAttribute(product);

        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, Model model, HttpServletRequest request, BindingResult result) {

        if (result.hasErrors()) {
            return "editProduct";
        }

        MultipartFile productImage = product.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Product image saving failed." + e);
            }
        }

        productDao.editProduct(product);

        return "redirect:/admin/productInventory";
    }

}
