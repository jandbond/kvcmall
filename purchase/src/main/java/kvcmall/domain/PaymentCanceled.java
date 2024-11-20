package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String voucherId;
    private Long amount;
    private Date date;
    private String status;

    public PaymentCanceled(Purchase aggregate) {
        super(aggregate);
    }

    public PaymentCanceled() {
        super();
    }
}
//>>> DDD / Domain Event