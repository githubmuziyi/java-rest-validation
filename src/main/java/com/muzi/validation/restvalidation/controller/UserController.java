package com.muzi.validation.restvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muzi.validation.restvalidation.domain.request.UserInfo;
import com.muzi.validation.restvalidation.domain.response.RestResponse;
import com.muzi.validation.restvalidation.utils.ValidationUtil;

/**
 * 用户rest服务
 *
 * @author muzi
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse saveUser(@RequestBody UserInfo userInfo) {
        ValidationUtil.validate(userInfo);
        return RestResponse.success();
    }

}
