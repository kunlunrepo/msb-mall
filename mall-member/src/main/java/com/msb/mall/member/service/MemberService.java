package com.msb.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.mall.common.utils.PageUtils;
import com.msb.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author kunlunrepo
 * @email 
 * @date 2024-03-14 11:41:51
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

