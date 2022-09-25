package ryu.assign.database.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import ryu.assign.database.model.User;

@Mapper
public interface MybatisUserMapper {
	
	@Select("select * from user where id = #{id}")
	public Optional<User> findUser(long id);
	
	@Insert("insert into user (username, password, email, role, createDate) values (#{username}, #{password}, #{email}, #{role}, #{createDate})")
	public void insertUser(User user);
	
	@Update("update user set"
			+ " username = #{username},"
			+ " password = #{password},"
			+ " email = #{email}"
			+ "  where id = #{id}")
	public void updateUser(User user);
	
	@Delete("delete from user where id = #{id}")
	public void deleteUser(long id);
	
	public Optional<User> findUserByXml(long id);
	
	public void insertUserByXml(User user);
	
	public void updateUserByXml(User user);
	
	public void deleteUserByXml(long id);
}
