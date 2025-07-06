package com.kap.flowershop.back.entity;

import com.kap.flowershop.front.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "customerorder")
public class CustomerOrder implements Serializable {
	private static final long serialVersionUID = -6571020025726257848L;

	@Id
	@Column(name = "customerorderid")
	private String customerOrderId = UUID.randomUUID().toString();

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "opendate")
	private Date openDate;

	@Column(name = "closedate")
	private Date closeDate;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Users user;

	@OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<OrderItem> orderItems;

	@Override
	public String toString() {
		return "CustomerOrder(customerOrderId=" + this.customerOrderId + ", "
				+ "status=" + this.status + ", "
				+ "total=" + this.total + ", "
				+ "openDate=" + this.openDate + ", "
				+ "closeDate=" + this.closeDate + ", "
				+ "user=" + this.user.getUserId() + ")";
	}
}
