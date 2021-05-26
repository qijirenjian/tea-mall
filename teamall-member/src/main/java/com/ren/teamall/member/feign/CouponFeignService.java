package com.ren.teamall.member.feign;

import com.ren.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author renjian
 * @creaate 2021-05-24 22:20
 * function
 * description
 * -
 */

@FeignClient("teamall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
