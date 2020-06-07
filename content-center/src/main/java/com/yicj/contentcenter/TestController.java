package com.yicj.contentcenter;

import com.yicj.contentcenter.dao.content.ShareMapper;
import com.yicj.contentcenter.domain.entity.content.Share;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

/**
 * ClassName: TestController
 * Description: TODO(描述)
 * Date: 2020/6/6 22:02
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final ShareMapper shareMapper ;

    @GetMapping("/test")
    public List<Share> testInsert(){
        // 1. 做插入
        Share share = new Share() ;
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("xxx");
        share.setCover("xxx");
        share.setAuthor("yicj");
        share.setBuyCount(1);
        shareMapper.insertSelective(share) ;
        // 2. 做查询，查询当前数据库所有share
        List<Share> shares = this.shareMapper.selectAll();
        return shares ;
    }
}
