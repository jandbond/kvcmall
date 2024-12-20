package kvcmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import kvcmall.config.kafka.KafkaProcessor;
import kvcmall.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    VoucherRepository voucherRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PurchaseRequested'"
    )
    public void wheneverPurchaseRequested_DecreaseVoucherLimit(
        @Payload PurchaseRequested purchaseRequested
    ) {
        PurchaseRequested event = purchaseRequested;
        System.out.println(
            "\n\n##### listener DecreaseVoucherLimit : " +
            purchaseRequested +
            "\n\n"
        );

        // Sample Logic //
        Voucher.decreaseVoucherLimit(event);


    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CancellationRequested'"
    )
    public void wheneverCancellationRequested_IncreaseVoucherLimit(
        @Payload CancellationRequested cancellationRequested
    ) {
        CancellationRequested event = cancellationRequested;
        System.out.println(
            "\n\n##### listener IncreaseVoucherLimit : " +
            cancellationRequested +
            "\n\n"
        );

        // Sample Logic //
        Voucher.increaseVoucherLimit(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
