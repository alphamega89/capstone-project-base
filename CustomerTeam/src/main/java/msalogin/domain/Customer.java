package msalogin.domain;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import msalogin.CustomerTeamApplication;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;

// @Getter
// @Setter
@Entity
@Table(name = "CustomerList_Base")
@Data
public class Customer {

    @Id
    private Long id;
    @Column
    private Long CustomerId;
    @Column
    private String Status;
    @Column
    private String Address;
    @Column
    private String Telno;
    @Column
    private String Name;
    @Column
    private String JuminNo;

    @PostPersist
    public void onPostPersist() {
        CustomerRegistered customerRegistered = new CustomerRegistered();
        BeanUtils.copyProperties(this, customerRegistered);
        customerRegistered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

//         fooddelivery.external.Payment payment = new fooddelivery.external.Payment();
//         // mappings goes here
//         FrontApplication.applicationContext
//             .getBean(fooddelivery.external.PaymentService.class)
//             .pay(payment);
    }

    @PostRemove
    public void onPostRemove() {
        CustomerCancelled customerCanceled = new CustomerCancelled();
        BeanUtils.copyProperties(this, customerCanceled);
        customerCanceled.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    @PreRemove
    public void onPreRemove() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodId() {ㄹㅈㄷㄹ
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


