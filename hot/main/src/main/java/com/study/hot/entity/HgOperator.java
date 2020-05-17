package com.study.hot.entity;

import com.study.hot.base.BaseEntity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author administrator
 * @since 2020-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class HgOperator extends BaseEntity<HgOperator> {

    private static final long serialVersionUID=1L;

    /**
     * 登录用户名
     */
    private String account;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 密码加盐
     */
    private String salt;

    /**
     * 真实性名
     */
    private String realName;

    /**
     * 火锅店名称
     */
    private String storeName;

    /**
     * 火锅店电话
     */
    private String storePhone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 火锅店地址
     */
    private String storeAddress;

    /**
     * 火锅店照片
     */
    private String storePic;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
