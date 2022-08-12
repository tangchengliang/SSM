package com.tcl.spring.service.impl;

import com.tcl.spring.service.BookService;
import com.tcl.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    @Transactional(propagation = Propagation.REQUIRES_NEW) //不适用结账时的事物，使用买书的事物，那么买第一本会成功，第二本失败
    public void checkout(Integer userId, Integer[] bookIds) {
        for(Integer bookId:bookIds){
            bookService.buyBook(userId, bookId);
        }
    }
}
