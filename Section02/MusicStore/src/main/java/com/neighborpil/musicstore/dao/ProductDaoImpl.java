package com.neighborpil.musicstore.dao;

import com.neighborpil.musicstore.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public Product getProductById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();
        return products;
    }

    @Override
    public void deleteProduct(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }
}
