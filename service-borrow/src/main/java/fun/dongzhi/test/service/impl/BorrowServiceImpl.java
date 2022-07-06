package fun.dongzhi.test.service.impl;

import fun.dongzhi.test.entity.Book;
import fun.dongzhi.test.entity.Borrow;
import fun.dongzhi.test.entity.User;
import fun.dongzhi.test.entity.UserBorrowDetail;
import fun.dongzhi.test.mapper.BorrowMapper;
import fun.dongzhi.test.service.BorrowService;
import fun.dongzhi.test.service.client.BookClient;
import fun.dongzhi.test.service.client.UserClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    private static final String OK = "OK";

    @Resource
    private BorrowMapper mapper;

    @Resource
    private UserClient userClient;

    @Resource
    private BookClient bookClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        System.out.println(OK);
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        User user = userClient.findUserById(uid);
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
