package kvcmall.infra;

import kvcmall.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerLimitHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CustomerLimit>> {

    @Override
    public EntityModel<CustomerLimit> process(
        EntityModel<CustomerLimit> model
    ) {
        return model;
    }
}
