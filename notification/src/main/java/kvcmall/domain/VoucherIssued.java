package kvcmall.domain;

import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class VoucherIssued extends AbstractEvent {

    private Long id;
}
