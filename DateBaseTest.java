package Main;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateBaseTest {

    private DateBase db = new DateBase("Тестовая база данных");

    @Test
    public void testSearchDateBaseMethod() {
        try {
            int expected = db.search(0, "Максим");
            int actual = 2;
            fail("Тест на поиск пользователя должен был вызвать исключение, так как база данных пуста");
        } catch (DateBaseException e) {
            Assume.assumeNoException(e);
        }
    }


}