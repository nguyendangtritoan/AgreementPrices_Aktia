package com.rest.agreement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.agreement.controller.AgreementController;
import com.rest.agreement.controller.CustomerController;
import com.rest.agreement.entity.AgreementEntity;
import com.rest.agreement.entity.CustomerEntity;
import com.rest.agreement.repository.AgreementRepo;
import com.rest.agreement.repository.CustomerRepo;
import com.rest.agreement.service.AgreementSer;
import com.rest.agreement.service.CustomerSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AgreementController.class)
public class AgreementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AgreementRepo agreementRepo;

    @MockBean
    private AgreementSer agreementSer;

    @Test
    public void testListAgreements() throws Exception {
        List<AgreementEntity> agreementEntityList = new ArrayList<>();

        CustomerEntity customerEntity1 = new CustomerEntity(1,"T01", "Test1");
        CustomerEntity customerEntity2 = new CustomerEntity(2,"T02", "Test2");
        CustomerEntity customerEntity3 = new CustomerEntity(3,"T03", "Test3");
        CustomerEntity customerEntity4 = new CustomerEntity(4,"T04", "Test4");
        CustomerEntity customerEntity5 = new CustomerEntity(5,"T05", "Test5");
        CustomerEntity customerEntity6 = new CustomerEntity(6,"T06", "Test6");

        Date startDate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-08-06 15:58:10");
        Date startDate2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2013-07-07 16:58:20");
        Date startDate3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-08-09 17:58:30");
        Date startDate4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-09-10 18:58:40");
        Date startDate5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-10-11 19:58:50");
        Date startDate6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-12 10:58:60");

        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-12 12:50:60");

        agreementEntityList.add(new AgreementEntity(1, customerEntity1,1,startDate1,endDate));
        agreementEntityList.add(new AgreementEntity(2, customerEntity2,2,startDate2,endDate));
        agreementEntityList.add(new AgreementEntity(3, customerEntity3,3,startDate3,endDate));
        agreementEntityList.add(new AgreementEntity(4, customerEntity4,4,startDate4,endDate));
        agreementEntityList.add(new AgreementEntity(5, customerEntity5,5,startDate5,null));
        agreementEntityList.add(new AgreementEntity(6, customerEntity6,6,startDate6,null));

        Mockito.when(agreementRepo.findAll()).thenReturn(agreementEntityList);

        String url = "/agreement/list";

        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    public void testAddAgreement() throws Exception {

        CustomerEntity customerEntity = new CustomerEntity(6,"T06", "Test6");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-12 12:50:60");
        Date startDate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-08-06 15:58:10");

        AgreementEntity newEntity = new AgreementEntity(1, customerEntity,1,startDate1,endDate);

        AgreementEntity savedEntity = new AgreementEntity(1, customerEntity,1,startDate1,endDate);
        Mockito.when(agreementRepo.save(newEntity)).thenReturn(savedEntity);

        String url = "/agreement/save";
        mockMvc.perform(post(url)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newEntity))
        ).andExpect(status().isOk());
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(6,"T06", "Test6");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-12 12:50:60");
        Date startDate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-08-06 15:58:10");

        AgreementEntity agreementEntity = new AgreementEntity(1, customerEntity,1,startDate1,endDate);

        Mockito.when(agreementRepo.save(agreementEntity)).thenReturn(agreementEntity);

        String urlUpdate = "/agreement/update";

        mockMvc.perform(put(urlUpdate)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(agreementEntity))
        ).andExpect(status().isOk());
    }

}
