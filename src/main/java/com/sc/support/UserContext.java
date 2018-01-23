package com.sc.support;

public class UserContext {
	public static final ThreadLocal<AuthUser> USER_LOCAL = new ThreadLocal<AuthUser>();

	public static void setAuthUser(AuthUser authUser) {
		USER_LOCAL.set(authUser);
	}

	public static AuthUser getAuthUser() {
		return USER_LOCAL.get();
	}
	
	public static String getLoginName(){
		if(null==USER_LOCAL.get()){
			return "SYS";
		}else {
			return USER_LOCAL.get().getUserLoginName();
		}
	}

}
