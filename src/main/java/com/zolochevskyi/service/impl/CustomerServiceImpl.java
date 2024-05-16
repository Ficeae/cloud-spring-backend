package com.zolochevskyi.service.impl;

import com.zolochevskyi.domain.Customer;
import com.zolochevskyi.exception.CustomerNotFoundExc;
import com.zolochevskyi.repository.CustomerRepo;
import com.zolochevskyi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Transactional
    @Override
    public void update(Integer id, Customer uCusomer) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundExc(id));
        customer.setName(uCusomer.getName());
        customer.setSurname(uCusomer.getSurname());
        customer.setAdress(uCusomer.getAdress());
        customer.setPhone(uCusomer.getPhone());
        customerRepo.save(customer);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundExc(id));
        customerRepo.delete(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundExc(id));
    }

    @Transactional
    @Override
    public Customer create(Customer entity) {
        return customerRepo.save(entity);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}