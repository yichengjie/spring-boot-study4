package com.yicj.usercenter.controller.user;

import com.yicj.usercenter.domain.entity.user.User;
import com.yicj.usercenter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Description: TODO(描述)
 * Date: 2020/6/7 10:17
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@RestController
@RequestMapping("/users")
//RequiredArgsConstructor(onConstructor = @__(Autowired.class))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService ;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id) ;
    }
}
