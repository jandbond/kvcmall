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
    CustomerLimitRepository customerLimitRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PurchaseRequested'"
    )
    public void wheneverPurchaseRequested_DecreaseCustomerLimit(
        @Payload PurchaseRequested purchaseRequested
    ) {
        PurchaseRequested event = purchaseRequested;
        System.out.println(
            "\n\n##### listener DecreaseCustomerLimit : " +
            purchaseRequested +
            "\n\n"
        );

        // Sample Logic //
        CustomerLimit.decreaseCustomerLimit(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CancellationRequested'"
    )
    public void wheneverCancellationRequested_IncreaseCustomerLimit(
        @Payload CancellationRequested cancellationRequested
    ) {
        CancellationRequested event = cancellationRequested;
        System.out.println(
            "\n\n##### listener IncreaseCustomerLimit : " +
            cancellationRequested +
            "\n\n"
        );

        // Sample Logic //
        CustomerLimit.increaseCustomerLimit(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
