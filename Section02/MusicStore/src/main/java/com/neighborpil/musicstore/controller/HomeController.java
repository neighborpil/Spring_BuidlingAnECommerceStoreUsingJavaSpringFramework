package com.neighborpil.musicstore.controller;

import com.neighborpil.musicstore.dao.ProductDao;
import com.neighborpil.musicstore.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
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

@Slf4j
@Controller
public class HomeController {

    private Path path;

    @Autowired
    private ProductDao productDao;
    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model) {

        List<Product> products = productDao.getAllProduct();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws Exception{

        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }


//    @RequestMapping("/dbTest")
//    public String dbTest(HttpServletResponse response) throws Exception {
//        Session session = null;
//
//        Test entity = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            Transaction transaction = session.beginTransaction();
//            entity = (Test) session.get(Test.class, 1);
//            log.debug(entity.getName());
//            transaction.commit();
//        } catch (HibernateException exception) {
//            exception.printStackTrace();
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        } finally {
//            if (session != null) {
//                if (session.isOpen()) {
//                    session.close();
//                }
//            }
//        }
//
//        if (entity != null) {
//            PrintWriter out = response.getWriter();
//            out.println("<script>alert('" + entity + "');</script> ");
//            out.flush();
//        }
//        return null;
//    }
}
