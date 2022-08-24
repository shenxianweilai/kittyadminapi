package fun.miaomi.Kittyadmin.mapper;

import fun.miaomi.Kittyadmin.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("INSERT INTO user(name, password, email) VALUES(#{name}, #{password}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addUser(User user);

    @Select("SELECT * FROM user")
    List<User> queryUserList();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryUserById(Long id);

    @Update("UPDATE user SET name=#{name}, email=#{email} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{userId}")
    void deleteUser(Long userId);

}
