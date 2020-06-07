package com.yicj.usercenter.service.user;

import com.yicj.usercenter.dao.user.UserMapper;
import com.yicj.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Description: TODO(描述)
 * Date: 2020/6/7 10:15
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Service
//@RequiredArgsConstructor(onConstructor = @__(Autowired.class))
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMapper userMapper ;

    public User findById(Integer id){

        return this.userMapper.selectByPrimaryKey(id) ;
    }

}
