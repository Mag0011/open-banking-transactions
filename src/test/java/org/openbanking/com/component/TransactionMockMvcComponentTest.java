package org.openbanking.com.component;

import org.junit.jupiter.api.Test;
import org.openbanking.com.controller.TransactionController;
import org.openbanking.com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.openbanking.com.TestUtils.mockTransactionDtoBuilder;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TransactionController.class)
public class TransactionMockMvcComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;

    @Test
    public void testSuccessfulTransaction() throws Exception {
        when(transactionService.findAllByAccountNumber(anyLong()))
                .thenReturn(List.of(
                        mockTransactionDtoBuilder().build(),
                        mockTransactionDtoBuilder().build()
                ));
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/transactions/123456789"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testFailingTransaction() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/transactions/"))
                .andExpect(status().isNotFound());
    }

}
