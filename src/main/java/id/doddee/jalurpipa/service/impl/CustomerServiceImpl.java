package id.doddee.jalurpipa.service.impl;

import id.doddee.jalurpipa.domain.Area;
import id.doddee.jalurpipa.domain.Customer;
import id.doddee.jalurpipa.repository.CustomerRepository;
import id.doddee.jalurpipa.service.CustomerService;
import id.doddee.jalurpipa.service.dto.CustomerDTO;
import id.doddee.jalurpipa.service.mapper.CustomerMapper;
import id.doddee.jalurpipa.utils.CustomerExcelImporter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Customer}.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public boolean save(byte[] file, Long areaId, String areaName) {
        try {
            List<Customer> customers = new CustomerExcelImporter(file)
                .importToList()
                .stream()
                .peek(
                    customer -> {
                        Area area = new Area();
                        area.setId(areaId);
                        area.setName(areaName);
                        customer.setArea(area);
                    }
                )
                .collect(Collectors.toList());
            customerRepository.saveAll(customers);
            return true;
        } catch (IOException e) {
            log.error("Error save customers by excel file -> ", e);
            return false;
        }
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        log.debug("Request to save Customer : {}", customerDTO);
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Customers");
        return customerRepository.findAll(pageable).map(customerMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerDTO> findOne(Long id) {
        log.debug("Request to get Customer : {}", id);
        return customerRepository.findById(id).map(customerMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
    }
}
