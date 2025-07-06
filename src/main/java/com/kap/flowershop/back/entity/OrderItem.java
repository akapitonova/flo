package com.kap.flowershop.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 5414968505955957016L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "order_item_seq")
    @SequenceGenerator(name="order_item_seq", sequenceName="order_item_sequence")
    @Column(name = "orderitemid")
    private Long orderItemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "productname")
    private String productName;

    @Column(name = "productid")
    private String productid;

    @ManyToOne
    @JoinColumn(name = "customerOrderId")
    private CustomerOrder customerOrder;

    @Override
    public String toString() {
        return "OrderItem(orderItemId=" + this.orderItemId + ", "
                + "quantity=" + this.quantity + ", "
                + "price=" + this.price + ", "
                + "productName=" + this.productName + ", "
                + "productid=" + this.productid + ", "
                + "customerOrderId=" + this.customerOrder.getCustomerOrderId() + ")";
    }
}
