package dchizhova68.lesson11;

import com.google.gson.Gson;
import dchizhova68.lesson11.model.Transactions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStreamReader;
import org.assertj.core.api.Assertions;

public class ParsingJsonFile {
    private ClassLoader classLoader = ParsingJsonFile.class.getClassLoader();
    private static final Gson gson = new Gson();
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void jsonFileParsingTest() throws Exception {
        try (InputStreamReader reader = new InputStreamReader(
                classLoader.getResourceAsStream("transaction.json")
        )) {
            Transactions actual = objectMapper.readValue(reader, Transactions.class);
            Assertions.assertThat(actual.getUserId()).isEqualTo("4457");

            Assertions.assertThat(actual.getTransactions()[0].getCount()).isEqualTo(20);
            Assertions.assertThat(actual.getTransactions()[1].getTransactionType()).isEqualTo("Автоматическая");;
        }
    }
}
