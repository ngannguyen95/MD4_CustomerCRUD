package ra.academy.service;

import ra.academy.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    // them moi va sua
    void save(Customer customer);
    Customer findById(int id);
    void deleteById(int id);
}
