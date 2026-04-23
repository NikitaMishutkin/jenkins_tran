package tests.simple;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
@Tag("simple")
public class FailedTest {
    @Test
    void test1(){
        assertFalse(false);
    }

    @Test
    void test2(){
        assertFalse(false);
    }

    @Test
    void test3(){
        assertFalse(false);
    }

    @Test
    void test4(){
        assertFalse(false);
    }

    @Test
    void test5(){
        assertFalse(false);
    }

}
