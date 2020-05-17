package com.study.hot.entity;

import com.study.hot.base.BaseEntity;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public class HgOrder extends BaseEntity<HgOrder> {

    private static final long serialVersionUID=1L;

    /**
     * 所属火锅店ID
     */
    private String storeId;

    /**
     * 所属消费者ID
     */
    private String customerId;

    /**
     * 订单消费金额
     */
    private BigDecimal orderPrice;

    /**
     * 菜品选购数量
     */
    private Integer foodCount;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
