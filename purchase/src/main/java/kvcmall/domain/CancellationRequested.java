package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CancellationRequested extends AbstractEvent {

    private Long id;

    public CancellationRequested(Purchase aggregate) {
        super(aggregate);
    }

    public CancellationRequested() {
        super();
    }
}
//>>> DDD / Domain Event
