package ua.nure.nikonova.dao;

import org.springframework.stereotype.Repository;
import ua.nure.nikonova.model.Book;

import java.util.List;


public interface BookDao {
    List<Book> list();
    Book getById(Integer id);
    Integer add(Book book);
void edit (Integer id, Book book);
void delete(Integer id);

}
