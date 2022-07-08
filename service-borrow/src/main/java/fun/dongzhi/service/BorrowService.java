package fun.dongzhi.service;

import fun.dongzhi.entity.UserBorrowDetail;

public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(Integer uid);
}
