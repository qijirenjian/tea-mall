package com.ren.teamall.member.dao;

import com.ren.teamall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-24 12:43:41
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
