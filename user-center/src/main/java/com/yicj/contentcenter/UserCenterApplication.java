package com.yicj.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName: UserCenterApplication
 * Description: TODO(描述)
 * Date: 2020/6/6 20:52
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
// 扫描mybatis哪些包里面的接口
@MapperScan("com.yicj.usercenter.dao")
@SpringBootApplication
public class UserCenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserCenterApplication.class, args) ;
    }
}
