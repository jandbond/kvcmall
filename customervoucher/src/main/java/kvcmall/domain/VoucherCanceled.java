package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VoucherCanceled extends AbstractEvent {

    private Long id;

    public VoucherCanceled(CustomerVoucher aggregate) {
        super(aggregate);
    }

    public VoucherCanceled() {
        super();
    }
}
//>>> DDD / Domain Event