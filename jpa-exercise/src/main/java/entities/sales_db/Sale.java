//package entities.sales_db;
//
//import entities.BaseEntity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "sales")
//public class Sale extends BaseEntity {
//    private Product product;
//    private Customer customer;
//    private StoreLocation storeLocation;
//    private Date date;
//
//    public Sale() {
//    }
//
//    @ManyToOne
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    @ManyToOne
//    public StoreLocation getStoreLocation() {
//        return storeLocation;
//    }
//
//    public void setStoreLocation(StoreLocation storeLocation) {
//        this.storeLocation = storeLocation;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    @ManyToOne
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//}
