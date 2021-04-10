package com.pagos.linea.demo.entitys;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class CustomerBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double subtotal;
	private double totalIva;
	private double totalpay;
	private double domicilio;
	private Integer state;
	
	private Date created=new Date();
	
	@ManyToMany
	@JoinTable( name="ProductDetail", joinColumns = @JoinColumn(name="custormerBill_id"),
										inverseJoinColumns = @JoinColumn(name ="product_id")
			)
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotalIva() {
		return totalIva;
	}

	public void setTotalIva(double totalIva) {
		this.totalIva = totalIva;
	}

	public double getTotalpay() {
		return totalpay;
	}

	public void setTotalpay(double totalpay) {
		this.totalpay = totalpay;
	}

	public double getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(double domicilio) {
		this.domicilio = domicilio;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setProducts(List<Product> products) {
		// TODO Auto-generated method stub
		
	}


	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}



	


}
