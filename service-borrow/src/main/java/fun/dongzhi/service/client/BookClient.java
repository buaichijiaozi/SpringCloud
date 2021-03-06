package fun.dongzhi.service.client;

import fun.dongzhi.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient("bookservice")
@FeignClient(value = "bookservice", fallback = BookFallbackClient.class)
public interface BookClient {
    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") Integer bid);
}
