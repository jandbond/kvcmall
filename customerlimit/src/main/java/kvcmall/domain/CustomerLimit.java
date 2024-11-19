package kvcmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kvcmall.CustomerlimitApplication;
import lombok.Data;

@Entity
@Table(name = "CustomerLimit_table")
@Data
//<<< DDD / Aggregate Root
public class CustomerLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long maximumLimit;

    private Long currentLimit;

    public static CustomerLimitRepository repository() {
        CustomerLimitRepository customerLimitRepository = CustomerlimitApplication.applicationContext.getBean(
            CustomerLimitRepository.class
        );
        return customerLimitRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseCustomerLimit(
        PurchaseRequested purchaseRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        CustomerLimit customerLimit = new CustomerLimit();
        repository().save(customerLimit);

        */

        /** Example 2:  finding and process
        
        repository().findById(purchaseRequested.get???()).ifPresent(customerLimit->{
            
            customerLimit // do something
            repository().save(customerLimit);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseCustomerLimit(
        CancellationRequested cancellationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        CustomerLimit customerLimit = new CustomerLimit();
        repository().save(customerLimit);

        */

        /** Example 2:  finding and process
        
        repository().findById(cancellationRequested.get???()).ifPresent(customerLimit->{
            
            customerLimit // do something
            repository().save(customerLimit);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
