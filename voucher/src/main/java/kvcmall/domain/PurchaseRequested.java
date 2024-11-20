package kvcmall.domain;

import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PurchaseRequested extends AbstractEvent {

    private Long id;

    private String customerId;

    private String voucherId;

    private Long amount;

    private String status;

    public Long getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Long getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
