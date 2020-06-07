package com.yicj.contentcenter.controller.content;

import com.yicj.contentcenter.domain.dto.content.ShareDTO;
import com.yicj.contentcenter.service.content.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ShareController
 * Description: TODO(描述)
 * Date: 2020/6/7 11:19
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@RestController
@RequestMapping("/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService ;

    @GetMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id){
       return this.shareService.findById(id) ;
    }
}
