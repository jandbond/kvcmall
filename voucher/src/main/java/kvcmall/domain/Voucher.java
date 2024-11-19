package kvcmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kvcmall.VoucherApplication;
import lombok.Data;

@Entity
@Table(name = "Voucher_table")
@Data
//<<< DDD / Aggregate Root
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long totalIssuedAmount;

    private Long currentIssuedAmount;

    private String status;

    public static VoucherRepository repository() {
        VoucherRepository voucherRepository = VoucherApplication.applicationContext.getBean(
            VoucherRepository.class
        );
        return voucherRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseVoucherLimit(
        PurchaseRequested purchaseRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Voucher voucher = new Voucher();
        repository().save(voucher);

        */

        /** Example 2:  finding and process
        
        repository().findById(purchaseRequested.get???()).ifPresent(voucher->{
            
            voucher // do something
            repository().save(voucher);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseVoucherLimit(
        CancellationRequested cancellationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Voucher voucher = new Voucher();
        repository().save(voucher);

        */

        /** Example 2:  finding and process
        
        repository().findById(cancellationRequested.get???()).ifPresent(voucher->{
            
            voucher // do something
            repository().save(voucher);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
