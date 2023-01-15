package ryu.assign.database;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ryu.assign.database.mapper.MybatisUserMapper;
import ryu.assign.database.model.User2;
import ryu.assign.database.util.RandomString;

@SpringBootTest
class DatabaseTrainingApplicationTests {

	@Autowired
	MybatisUserMapper mybatisUserMapper;


    private List<User2> users = new ArrayList<>();

    @BeforeEach
    void genUser() {
        for (int i=0; i < 10000; i++) {
            users.add(new User2(
                    "gngsn" + i,
                    "gngsn" + i + "@email.com",
                    new RandomString().nextString())
            );
        }
    }

    @Test
    void contextLoads() {
        mybatisUserMapper.bulkInsertUserList(users);

    }
}
