package com.yicj.contentcenter;

import com.yicj.contentcenter.dao.user.UserMapper;
import com.yicj.contentcenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ClassName: TestController
 * Description: TODO(描述)
 * Date: 2020/6/6 21:35
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper ;

    @GetMapping("/test")
    public User testInsert(){
        User user = new User() ;
        user.setAvatarUrl("xxx");
        user.setBonus(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        this.userMapper.insertSelective(user) ;
        return user ;
    }
}
