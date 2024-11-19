package kvcmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kvcmall.PurchaseApplication;
import kvcmall.domain.CancellationRequested;
import kvcmall.domain.PurchaseRequested;
import lombok.Data;

@Entity
@Table(name = "Purchase_table")
@Data
//<<< DDD / Aggregate Root
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String voucherId;

    private Long amount;

    private String status;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        kvcmall.external.Payment payment = new kvcmall.external.Payment();
        // mappings goes here
        PurchaseApplication.applicationContext
            .getBean(kvcmall.external.PaymentService.class)
            .approvePayment(payment);

        PurchaseRequested purchaseRequested = new PurchaseRequested(this);
        purchaseRequested.publishAfterCommit();

        CancellationRequested cancellationRequested = new CancellationRequested(
            this
        );
        cancellationRequested.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static PurchaseRepository repository() {
        PurchaseRepository purchaseRepository = PurchaseApplication.applicationContext.getBean(
            PurchaseRepository.class
        );
        return purchaseRepository;
    }
}
//>>> DDD / Aggregate Root
