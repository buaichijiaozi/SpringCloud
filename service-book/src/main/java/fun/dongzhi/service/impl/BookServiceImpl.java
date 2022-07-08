package fun.dongzhi.service.impl;

import fun.dongzhi.service.BookService;
import fun.dongzhi.entity.Book;
import fun.dongzhi.mapper.BookMapper;
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
