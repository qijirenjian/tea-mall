package com.ren.teamall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.common.utils.PageUtils;
import com.ren.teamall.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-24 12:52:45
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

