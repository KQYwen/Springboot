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
public class HgOrders extends BaseEntity<HgOrders> {

    private static final long serialVersionUID=1L;

    /**
     * 所属火锅店ID
     */
    private String storeId;

    /**
     * 所属订单ID
     */
    private String orderId;

    /**
     * 菜品ID
     */
    private String foodId;

    /**
     * 消费数两
     */
    private Integer foodCount;

    /**
     * 菜品价格
     */
    private BigDecimal foodPrice;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
