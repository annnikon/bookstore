package ua.nure.nikonova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.nikonova.model.Book;
import ua.nure.nikonova.dao.BookDao;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookController {


   @Autowired
   BookDao dao;

   @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView home(ModelAndView m) {
       m.setViewName("main");
        m.addObject("books",  dao.list() );

       return m;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public ModelAndView goToAdd(ModelAndView m) {
       m.setViewName("edit");
       m.addObject("currentBook", new Book());
       return m;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ModelAndView add(@ModelAttribute Book currentBook) {
       if(currentBook.getId()!=null) {
           dao.edit(currentBook.getId(), currentBook);
       }
       else {

           dao.add(currentBook);
       }
        return new ModelAndView("redirect:/");

    }



    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    public ModelAndView goToEdit(HttpServletRequest request) {
       ModelAndView m = new ModelAndView("edit");
        Integer id = Integer.parseInt(request.getParameter("id"));
        m.addObject("currentBook",  dao.getById(id) );
        return m;
    }



    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public ModelAndView delete(HttpServletRequest request) {

        Integer id = Integer.parseInt(request.getParameter("id"));
       dao.delete(id);
        return new ModelAndView("redirect:/");
    }






}