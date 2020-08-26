package id.doddee.jalurpipa.repository;

import id.doddee.jalurpipa.domain.Customer;
import java.util.List;

public interface CustomerRepositoryCustom {
    boolean bulkUpsert(List<Customer> customers);
}
