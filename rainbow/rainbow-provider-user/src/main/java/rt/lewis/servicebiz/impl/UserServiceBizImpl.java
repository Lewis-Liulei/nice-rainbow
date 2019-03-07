package rt.lewis.servicebiz.impl;

import com.alibaba.dubbo.config.annotation.Service;
import rt.lewis.api.biz.user.UserServiceBiz;

@Service
public class UserServiceBizImpl implements UserServiceBiz {

    @Override
    public String getString() {
        return "hello world";
    }

    @Override
    public String setString() {
        return "终于通了";
    }
}
