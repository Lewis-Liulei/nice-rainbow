package rt.lewis.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rt.lewis.business.user.UserService;
import rt.lewis.common.entity.user.User;
import rt.lewis.dao.mapper.UserMapper;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User>
        implements UserService {
    private Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate template;

    @Override
    public User getUserById(String id) {
        logger.info("进入getUserById方法");
        return userMapper.getUserById(id);
    }



    @Override
    public List<User> getAllUser() {
        return super.list();
    }
    @Override
    public List<User> getListByPage(){
        //Page<User> page = new Page<>();
        //page.setSize(2);
       IPage<User> userIPage= userMapper.selectPage(
                new Page<User>()
                        .setSize(4)
                        .setDesc("id"),
                new QueryWrapper<User>());
        List<User> list=userIPage.getRecords();
        return list;
    }

    @Override
    public String setRedisKey(String key) {
        //String key="spring.boot.redis.test";
        String value="I am redis!";
        if(!template.hasKey(key)){
            template.opsForValue().set(key,value);
        }
        return key;
    }

    @Override
    public String getRedisKey(String key) {
        //String key="spring.boot.redis.test";
        //String value="I am redis!";
        if(template.hasKey(key)){
            return template.opsForValue().get(key);
        }
        return null;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
