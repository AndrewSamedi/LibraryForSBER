package com.bookStore.bookStore_Component.service;


import com.bookStore.bookStore_Component.bRepository.MyBookRepository;
import com.bookStore.bookStore_Component.entity.MyBookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList book){
        myBookRepository.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
    }

    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}
