//package entities.sales_db;
//
//import entities.BaseEntity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.Set;
//
//@Entity
//@Table(name = "customers")
//public class Customer extends BaseEntity{
//    private String name;
//    private String email;
//    private String creditCardNumber;
//
//    private Set<Sale> sales;
//
//    public Customer() {
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
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Column(name = "credit_card_number")
//    public String getCreditCardNumber() {
//        return creditCardNumber;
//    }
//
//    public void setCreditCardNumber(String creditCardNumber) {
//        this.creditCardNumber = creditCardNumber;
//    }
//}
