//package entities.sales_db;
//
//import entities.BaseEntity;
//
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//import java.util.Set;
//
//@Entity
//@Table(name = "products")
//public class Product extends BaseEntity {
//    private String name;
//    private Double quantity;
//    private BigDecimal price;
//    private Set<Sale> sales;
//
//    public Product() {
//    }
//
//    @OneToMany(mappedBy = "customer",targetEntity = Sale.class)
//    public Set<Sale> getSales() {
//        return sales;
//    }
//
//    public void setSales(Set<Sale> sales) {
//        this.sales = sales;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Double quantity) {
//        this.quantity = quantity;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//}
