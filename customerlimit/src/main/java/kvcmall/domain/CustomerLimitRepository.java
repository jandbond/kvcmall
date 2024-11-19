package kvcmall.domain;

import kvcmall.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "customerLimits",
    path = "customerLimits"
)
public interface CustomerLimitRepository
    extends PagingAndSortingRepository<CustomerLimit, Long> {}
