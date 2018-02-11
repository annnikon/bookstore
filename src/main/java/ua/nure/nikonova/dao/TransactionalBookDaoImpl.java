package ua.nure.nikonova.dao;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.nure.nikonova.model.Book;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;



public class TransactionalBookDaoImpl implements BookDao{


    private SessionFactory sessionFactory;


     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

@Override
    public Integer add(Book book) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(book);
        tx.commit();
        session.close();
        return  book.getId();
    }

    @Override
    public void edit(Integer id,Book editedBook) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Book book = (Book) session.get(Book.class, id);
        book.setAuthor(editedBook.getAuthor());
        book.setName(editedBook.getName());
        book.setPrice(editedBook.getPrice());
        session.flush();
        tx.commit();
        session.close();

    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Book book = (Book) session.get(Book.class, id);
        session.delete(book);
        tx.commit();
        session.close();

    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Book> list() {
        Session session = this.sessionFactory.openSession();
        List<Book> books = session.createQuery("from Book").list();
        session.close();
        return books;
    }

@Override
    public Book getById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, id);
        session.close();
        return book;


    }
}