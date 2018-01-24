package com.sc.domain;

import java.io.Serializable;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_users")
public class UserDomain extends BaseDomain implements Serializable{
   
	private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    private String userLoginName;

    /**
     * 密码
     */
    private String userLoginPwd;

    /**
     * 身份证号
     */
    private String userIdCard;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 昵称
     */
    private String userNickname;

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd == null ? null : userLoginPwd.trim();
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard == null ? null : userIdCard.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

   
}