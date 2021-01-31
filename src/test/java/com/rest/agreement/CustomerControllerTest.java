package com.rest.agreement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.agreement.controller.CustomerController;
import com.rest.agreement.entity.CustomerEntity;
import com.rest.agreement.repository.AgreementRepo;
import com.rest.agreement.repository.CustomerRepo;
import com.rest.agreement.repository.ServiceRepo;
import com.rest.agreement.service.CustomerSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerRepo customerRepo;

    @MockBean
    private ServiceRepo serviceRepo;

    @MockBean
    private AgreementRepo agreementRepo;

    @MockBean
    private CustomerSer customerSer;

    @Test
    public void testListCustomers() throws Exception {
        List<CustomerEntity> customerEntityList = new ArrayList<>();

        customerEntityList.add(new CustomerEntity(1,"T015", "toan"));
        customerEntityList.add(new CustomerEntity(2,"T016", "test1"));
        customerEntityList.add(new CustomerEntity(3,"T017", "test2"));
        customerEntityList.add(new CustomerEntity(4,"T018", "test3"));
        customerEntityList.add(new CustomerEntity(5,"T019", "test4"));

        Mockito.when(customerRepo.findAll()).thenReturn(customerEntityList);

        String url = "/customer/list";

        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    public void testAddCustomer() throws Exception {
        CustomerEntity newEntity = new CustomerEntity(1,"T015", "toan");

        CustomerEntity savedEntity = new CustomerEntity(1,"T015", "toan");
        Mockito.when(customerRepo.save(newEntity)).thenReturn(savedEntity);

        String url = "/customer/save";
        mockMvc.perform(post(url)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newEntity))
        ).andExpect(status().isOk());
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        CustomerEntity newEntity = new CustomerEntity(1,"T015", "toan");

        CustomerEntity savedEntity = new CustomerEntity(1,"T015", "toan");
        Mockito.when(customerRepo.save(newEntity)).thenReturn(savedEntity);

        String urlUpdate = "/customer/update";

        mockMvc.perform(put(urlUpdate)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newEntity))
        ).andExpect(status().isOk());
    }

}
