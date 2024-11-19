package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VoucherIssued extends AbstractEvent {

    private Long id;

    public VoucherIssued(CustomerVoucher aggregate) {
        super(aggregate);
    }

    public VoucherIssued() {
        super();
    }
}
//>>> DDD / Domain Event