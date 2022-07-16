import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class RunTest {
    Run run;

    @BeforeEach
    void creatObject() {
        run = new Run("Tanibergen");
    }

    @Test
    void testMethodName() {
        try {
            Method method = Run.class.getDeclaredMethod("name", null);
            method.setAccessible(true);
            assertEquals("Tanirbergen", method.invoke(run).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    // С помощью анотаций тест выполняется 8-ой джаве
    @EnabledOnJre(JRE.JAVA_17)
    void testMethodNameSecond() {
        try {
            Method method = Run.class.getDeclaredMethod("name", String.class);
            method.setAccessible(true);
            assertEquals("Tanirbergen", method.invoke(run, "Tanirbergen").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // С попомщью анотаций мы запускаем тест определенный системе
    @EnabledOnOs(OS.LINUX)
    // С помощью анотаций выполняем тест несколько раз
    @ParameterizedTest
    // С помощью анотаций мы можем писать несколько аргументов
    @CsvSource({"1,5", "2,6", "32,36"})
    void testMethodNum(int a, int b) {
        assertEquals(run.number(a), b);
    }

    // С помощью анотаций выполняем тест несколько раз
    @ParameterizedTest
    // С помощью анотаций проверяем несколько значение
    @ValueSource(strings = {"Tanirbergen", "Imantai", "Aman"})
    // С помощью анотаций проверяем на Null
    @NullSource
    // С помощью анотаций проверяем на пустой аргумент
    @EmptySource
    void testMethodSet(String name) {
        run.setName(name);
    }
}