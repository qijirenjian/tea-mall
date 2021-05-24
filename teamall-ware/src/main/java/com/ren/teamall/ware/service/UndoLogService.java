package com.ren.teamall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.common.utils.PageUtils;
import com.ren.teamall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author ren
 * @email qijirenjian@163.com
 * @date 2021-05-24 12:56:59
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

