package com.muzi.validation.restvalidation.domain.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * 用户基本信息
 *
 * @author muzi
 */
public class UserInfo {

    @NotEmpty(message = "{application.userinfo.name.notempty}")
    @Size(min = 2, max = 8, message = "{application.userinfo.name.nottrue}")
    private String name;

    @NotNull(message = "{application.userinfo.age.notempty}")
    @Range(min = 0, max = 120, message = "{application.userinfo.age.nottrue}")
    private Integer age;

    @NotEmpty(message = "{application.userinfo.mobile.notempty}")
    @Pattern(regexp = "139[0-9]{8}", message = "{application.userinfo.mobile.nottrue}")
    private String mobile;

    @NotEmpty(message = "{application.userinfo.email.notempty}")
    @Email(message = "{application.userinfo.email.nottrue}")
    private String email;

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
