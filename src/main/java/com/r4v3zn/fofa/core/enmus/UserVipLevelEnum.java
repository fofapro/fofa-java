package com.r4v3zn.fofa.core.enmus;

/**
 * Title: UserVipLevelEnum
 * Descrption: TODO
 * Date:2019-06-07 20:45
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public enum UserVipLevelEnum {

    /**
     * Senior member, Free member
     */
    SVIP(2,"高级会员"),VIP(1,"普通会员");

    private String levelName;

    private Integer code;

    UserVipLevelEnum(Integer code,String levelName){
        this.code = code;
        this.levelName = levelName;
    }

}