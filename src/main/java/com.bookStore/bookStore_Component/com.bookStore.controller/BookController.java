package com.bookStore.bookStore_Component.com.bookStore.controller;


import com.bookStore.bookStore_Component.entity.MyBookList;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.bookStore.bookStore_Component.service.BookService;
import com.bookStore.bookStore_Component.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.bookStore.bookStore_Component.service.MyBookListService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> list = service.getAllBook();
        ModelAndView m = new ModelAndView();
        m.setViewName("availableBooks");
        m.addObject("book",list);
        return  new ModelAndView("availableBooks","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        service.save(book);
        return "redirect:/available_books";
    }



    @GetMapping("/your_books")
    public String yourBooks(Model model){
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "yourBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book = service.getBookById(id);
        MyBookList mb = new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getGenre(), book.getPrice());
        myBookListService.saveMyBooks(mb);
        return "redirect:/your_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book = service.getBookById(id);
        model.addAttribute("book",book);
        return "bookEdit";
    }


    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }


}
