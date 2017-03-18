package org.demo.starter;

import org.demo.starter.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/bookInfo")
    public String getBookInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("book name:").append(bookService.getName()).append(",isbn:").append(bookService.getIsbn())
                .append(",author:").append(bookService.getAuthor());
        return sb.toString();
    }
}
