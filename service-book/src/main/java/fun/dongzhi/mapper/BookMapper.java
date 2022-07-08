package fun.dongzhi.mapper;

import fun.dongzhi.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
    @Select("select * from DB_BOOK where bid = #{bid}")
    Book getBookById(Integer bid);
}
