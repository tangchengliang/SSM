package com.tcl.spring.service.impl;


import com.tcl.spring.dao.BookDao;
import com.tcl.spring.pojo.Book;
import com.tcl.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    // 基于注解的事物管理
    @Transactional()
    public void buyBook(Integer userId, Integer bookId) {
        // 1.查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);
        // 2.更新图书库存
        bookDao.updateStock(bookId);
        // 3.更新用户余额
        bookDao.updateBalance(userId, price);
    }
}
