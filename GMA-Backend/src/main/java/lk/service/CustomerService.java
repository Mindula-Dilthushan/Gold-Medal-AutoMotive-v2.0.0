//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.service;

import lk.dto.CustomerDTO;
import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String id);
    CustomerDTO searchCustomer(String id);
    ArrayList<CustomerDTO>getAllCustomers();
    String getLastCustomerID();
    int getCustomerCount();
    String getCustomerDLIC();
}
