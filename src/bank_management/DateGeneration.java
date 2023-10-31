package bank_management;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGeneration {

    public String validDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate newdate = currentDate.plusYears(5);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/yy");
        return newdate.format(dateFormatter);
    }
}
