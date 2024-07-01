package org.openbanking.com.controller;

import org.junit.jupiter.api.Test;
import org.openbanking.com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;


    @Test
    public void testSuccessfulTransaction() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/transactions/{accountNumber}", "123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testFailingTransaction() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/transactions/"))
                .andExpect(status().isNotFound());
    }

}
