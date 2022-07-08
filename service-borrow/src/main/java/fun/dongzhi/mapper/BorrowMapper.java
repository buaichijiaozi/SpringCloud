package fun.dongzhi.mapper;

import fun.dongzhi.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from DB_BORROW where uid = #{uid}")
    List<Borrow> getBorrowsByUid(Integer uid);

    @Select("select * from DB_BORROW where bid = #{bid}")
    List<Borrow> getBorrowsByBid(Integer bid);

    @Select("select * from DB_BORROW where bid = #{bid} and uid = #{uid}")
    Borrow getBorrow(Integer uid, Integer bid);
}
