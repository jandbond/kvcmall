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
    CustomerVoucherRepository customerVoucherRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentApproved'"
    )
    public void wheneverPaymentApproved_IssueVoucher(
        @Payload PaymentApproved paymentApproved
    ) {
        PaymentApproved event = paymentApproved;
        System.out.println(
            "\n\n##### listener IssueVoucher : " + paymentApproved + "\n\n"
        );

        // Sample Logic //
        CustomerVoucher.issueVoucher(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCancled'"
    )
    public void wheneverPaymentCancled_CancelVoucher(
        @Payload PaymentCancled paymentCancled
    ) {
        PaymentCancled event = paymentCancled;
        System.out.println(
            "\n\n##### listener CancelVoucher : " + paymentCancled + "\n\n"
        );

        // Sample Logic //
        CustomerVoucher.cancelVoucher(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
