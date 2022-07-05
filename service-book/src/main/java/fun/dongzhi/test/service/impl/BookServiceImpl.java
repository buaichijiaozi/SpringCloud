package fun.dongzhi.test.service.impl;

import fun.dongzhi.test.entity.Book;
import fun.dongzhi.test.mapper.BookMapper;
import fun.dongzhi.test.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(Integer bid) {
        return mapper.getBookById(bid);
    }
}
