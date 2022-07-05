package fun.dongzhi.test.service.impl;

import fun.dongzhi.test.entity.Book;
import fun.dongzhi.test.entity.Borrow;
import fun.dongzhi.test.entity.User;
import fun.dongzhi.test.entity.UserBorrowDetail;
import fun.dongzhi.test.mapper.BorrowMapper;
import fun.dongzhi.test.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    private BorrowMapper mapper;
    @Resource
    private RestTemplate template;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        User user = template.getForObject("http://userservice/user/"+uid, User.class);
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://bookservice/book/"+b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
