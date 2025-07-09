package com.estech.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.estech.course.entities.Order;
import com.estech.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*
 * A anotação @Embeddable em Java faz parte do framework JPA (Java Persistence API) , que é amplamente utilizado 
 * para mapear objetos Java (entidades) em tabelas de banco de dados relacional. Essa anotação é usada para definir
 * uma classe cujos atributos podem ser incorporados a outra entidade persistente, sem que a classe em si seja tratada 
 * como uma entidade independente.
 * 
 * O que é @Embeddable?
A anotação @Embeddable marca uma classe como "embutível" ou "incorporável". Isso significa que os campos dessa classe 
podem ser usados como parte de outra entidade.
Uma classe marcada com @Embeddable não possui identidade própria no banco de dados. Ela é sempre usada como parte de 
outra entidade.
No banco de dados, os campos da classe @Embeddable são armazenados diretamente na tabela da entidade que a incorpora.
 * */

@Embeddable
public class OrdemItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemItemPK other = (OrdemItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
}
