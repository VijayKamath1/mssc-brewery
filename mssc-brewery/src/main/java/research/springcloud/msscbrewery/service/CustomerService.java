package research.springcloud.msscbrewery.service;

import research.springcloud.msscbrewery.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById ( UUID customerId );

    void updateCustomer ( UUID customerId, CustomerDTO customerDto );

    void deleteCustomer ( UUID customerId );

    CustomerDTO saveNewCustomer ( CustomerDTO customerDto );
}
