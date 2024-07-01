package com.heima.po.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author cjw
 */
@Data
public class UserPo implements Serializable {
    private static final long serialVersionUID = 8475541341001681958L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 0；默认 1：男 2：女 3：其他
     */
    private Integer userGender;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 最后修改时间
     */
    private Date lastModifyDate;
}
