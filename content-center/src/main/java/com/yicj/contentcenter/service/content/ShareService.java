package com.yicj.contentcenter.service.content;

import com.yicj.contentcenter.dao.content.ShareMapper;
import com.yicj.contentcenter.domain.dto.content.ShareDTO;
import com.yicj.contentcenter.domain.dto.user.UserDTO;
import com.yicj.contentcenter.domain.entity.content.Share;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ShareService
 * Description: TODO(描述)
 * Date: 2020/6/7 10:52
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    private final ShareMapper shareMapper ;
    @Autowired
    private  RestTemplate restTemplate ;

    public ShareDTO findbyId(Integer id){
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id) ;
        // 发布人id
        Integer userId = share.getUserId();
        // 怎么调用用户微服务的/users/{id}
        UserDTO userDTO = restTemplate.getForObject("http://localhost:8080/users/{id}", UserDTO.class, userId);
        // 消息装配
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share,shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());

        return shareDTO ;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate() ;
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/users/{id}",
                String.class, 1);
        System.out.println(forEntity.getBody());
    }
}
