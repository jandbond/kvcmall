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
        repository().findById( Long.parseLong(purchaseRequested.getVoucherId()) ).ifPresent(voucher->{
            // 상품권 발행금액을 초과하지 않도록 비교후 차감.
            Long subTotalAmt = voucher.currentIssuedAmount + purchaseRequested.getAmount();
            // 발행된 금액이 총 금액을 넘지 않도록 점검 후 증감
            if (voucher.totalIssuedAmount >= subTotalAmt) {
                voucher.setCurrentIssuedAmount(voucher.currentIssuedAmount + purchaseRequested.getAmount());
                repository().save(voucher);
            } else {
                // 에러 처리
            }
 
         });

        
        
         purchaseRequested.getAmount();
        // repository().findById(purchaseRequested.getVoucherId()).ifPresent(voucher->{
            
        //     // voucher.setCurrentIssuedAmount(voucher.totalIssuedAmount - purchaseRequested.get);

            
        //     currentIssuedAmount = purchaseRequested.
        //     repository().save(voucher);


        //  });

        
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
