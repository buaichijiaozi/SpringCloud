package fun.dongzhi.service.client;

import fun.dongzhi.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements BookClient {
    @Override
    public Book findBookById(Integer bid) {
        Book book = new Book();
        System.out.println("I'm the alternative");
        return book;
    }
}
