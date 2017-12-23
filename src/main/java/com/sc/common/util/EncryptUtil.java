package com.sc.common.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * 密码加密的工具类（PasswordEncoder）
 * 
 */
public class EncryptUtil {

   //从配置文件中获得 ，秘玥值 
   private static final String SITE_WIDE_SECRET = "sc-manange-secret-key";  
   
   private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET);  
  
   /**
    * 密码加密（每次都不一样），加密后是80位的字符
    * @param rawPassword
    * @return
    */
   public static String encrypt(String rawPassword) {  
       return encoder.encode(rawPassword);  
   }  
   
   /**
    * 判断密码是否正确
    * @param rawPassword： 明文密码
    * @param encodePassword： 加密后的密文
    * @return
    */
   public static boolean match(String rawPassword, String encodePassword) {  
       return encoder.matches(rawPassword, encodePassword);  
   }  

   public static void main(String[] args) {
	   System.out.println(encrypt("123asd"));
   }
   
}
