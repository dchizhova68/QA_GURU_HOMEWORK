package dchizhova68.lesson11;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.opencsv.CSVReader;

import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class ReadingZipArh {
    private ClassLoader classLoader = ReadingZipArh.class.getClassLoader();

    @ParameterizedTest(name = "Проверяем наличие файла {0} и его содержимое")
    @CsvSource(value = {
            "csvFile.csv, Selenide",
            "excelFile.xlsx, value4",
            "pdfFile.pdf, QA GURU"
    })
    void zipArhParsingTest(String fileName, String value) throws Exception {
        try (ZipInputStream is = new ZipInputStream(
                classLoader.getResourceAsStream("testArh.zip")
        )) {
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (entry.getName().equals(fileName)) {
                    if (fileName.contains(".csv")) {
                        CSVReader reader = new CSVReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                        assertThat(reader.readNext()[0]).contains(value);
                        return;
                    } else if (fileName.contains(".xlsx")) {
                        XLS xls = new XLS(is);
                        assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue())
                                .isEqualTo(value);
                        return;
                    } else if (fileName.contains(".pdf")) {
                        PDF pdf = new PDF(is);
                        assertThat(pdf.text).contains(value);
                        return;
                    }
                    return;
                }
            }
                fail("Файла " + fileName + " нет в архиве!");
        }
    }
}
