package fun.dongzhi.test.service;

import fun.dongzhi.test.entity.UserBorrowDetail;

public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(Integer uid);
}
