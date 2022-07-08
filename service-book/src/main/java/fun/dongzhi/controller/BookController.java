package fun.dongzhi.controller;

import fun.dongzhi.entity.Book;
import fun.dongzhi.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {

    @Resource
    BookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") Integer bid, HttpServletRequest request) {
        System.out.println(request.getHeader("Test"));
        return service.getBookById(bid);
    }

}
