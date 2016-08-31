package com.gemini.common.domain.user;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

/**
 * @author 章源辰
 * @time: 16/8/30 22:04
 * @describion:
 */
public class UserInfo {
    /**
     * 用户Id
     */
    private int userId;
    /**
     * 用户登陆名
     */
    private String username;
    /**
     * 用户邮箱地址
     */
    @NotNull
    private String email;
    /**
     * 密码，为空时不参与序列化
     */
    @NotNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    /**
     * 用户姓名
     */
    @NotNull
    private String realName;
    /**
     * 性别
     */
    @NotNull
    private String sex;
    /**
     * 手机号码
     */
    @NotNull
    private String phoneNum;
    /**
     * 是否已认证
     */
    private Boolean verificationStatus;
    /**
     * 认证时间
     */
    private long verificationTime;
    /**
     * 邮箱是否验证
     */
    private Boolean emailValidity;
    /**
     * 用户图像地址
     */
    private String photoUrl;
    /**
     * 注册时间
     */
    private Long registerTime;
    /**
     * 最后一次登陆时间
     */
    private Long lastLoginTime;
    /**
     *手机的认证状态
     */
    private int phoneValidStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Boolean getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public long getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(long verificationTime) {
        this.verificationTime = verificationTime;
    }

    public Boolean getEmailValidity() {
        return emailValidity;
    }

    public void setEmailValidity(Boolean emailValidity) {
        this.emailValidity = emailValidity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getPhoneValidStatus() {
        return phoneValidStatus;
    }

    public void setPhoneValidStatus(int phoneValidStatus) {
        this.phoneValidStatus = phoneValidStatus;
    }
}
