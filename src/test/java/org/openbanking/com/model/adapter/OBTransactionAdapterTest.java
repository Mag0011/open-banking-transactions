package org.openbanking.com.model.adapter;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openbanking.com.model.Transaction;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.openbanking.com.TestUtils.mockOBReadDataTransaction6;
import static org.openbanking.com.TestUtils.mockOBTransaction6;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OBTransactionAdapterTest {

    OBTransactionAdapter obTransactionAdapter;

    @Test
    public void whenOBReadDataTransaction6IsComplete_Then_ReturnTransactionSuccessfully() {
        com.open_banking.model.OBReadDataTransaction6 mockObReadDataTransaction6 =
                mockOBReadDataTransaction6(List.of(
                        mockOBTransaction6("0001", "Credit", "USD", "1500", "Citi", OffsetDateTime.now())
                ));
        List<Transaction> actualResult = obTransactionAdapter.mapper(mockObReadDataTransaction6);
        assertFalse(actualResult.isEmpty());
    }

}
