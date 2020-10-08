package com.rzdp.treeflexauthorizationserver.service;

import com.rzdp.treeflexauthorizationserver.entity.Customer;
import com.rzdp.treeflexauthorizationserver.model.AuthUserDetail;
import com.rzdp.treeflexauthorizationserver.properties.ExceptionProperties;
import com.rzdp.treeflexauthorizationserver.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final ExceptionProperties exceptionProperties;

    @Autowired
    public UserDetailsServiceImpl(CustomerRepository customerRepository,
                                  ExceptionProperties exceptionProperties) {
        this.customerRepository = customerRepository;
        this.exceptionProperties = exceptionProperties;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findByUsername(username);
        if (!optionalCustomer.isPresent()) {
            throw new UsernameNotFoundException(exceptionProperties.getUsernameNotFound().getV1());
        }
        Customer customer = optionalCustomer.get();
        AuthUserDetail userDetail = new AuthUserDetail(customer);
        new AccountStatusUserDetailsChecker().check(userDetail);
        return userDetail;
    }
}
