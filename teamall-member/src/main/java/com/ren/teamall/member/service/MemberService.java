package com.ren.teamall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.common.utils.PageUtils;
import com.ren.teamall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-24 12:43:41
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

