package id.doddee.jalurpipa.service;

import id.doddee.jalurpipa.service.dto.CustomerDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link id.doddee.jalurpipa.domain.Customer}.
 */
public interface CustomerService {
    boolean save(byte[] file, Long areaId, String areaName);

    /**
     * Save a customer.
     *
     * @param customerDTO the entity to save.
     * @return the persisted entity.
     */
    CustomerDTO save(CustomerDTO customerDTO);

    /**
     * Get all the customers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CustomerDTO> findAll(Pageable pageable);

    /**
     * Get the "id" customer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDTO> findOne(Long id);

    /**
     * Delete the "id" customer.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
