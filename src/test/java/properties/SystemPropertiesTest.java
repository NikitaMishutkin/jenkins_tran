package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    void systemTest1(){
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }
    @Test
    void systemTest2(){
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser");
        System.out.println(browser); //safari
    }
    @Test
    void systemTest3(){
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); //def opera
    }

    @Test
    void systemTest4(){
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); //safari
    }
    @Test
    void systemTest5(){
        System.setProperty("anyValue", "any text");
        String browser = System.getProperty("anyValue", "some text");
        System.out.println(browser); //any text
    }

    @Test
    @Tag("test6")
    void systemTest6(){
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "101");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        System.out.println(version);
        System.out.println(browserSize);
        System.out.println(browser); //safari
    }
    /*
        from idea
             101
             1920x1080
             chrome
        gradle clean test6
             101
             1920x1080
             chrome
        gradle clean test6 -Dbrowser=opera (можно -Dversion и тд)
             101
             1920x1080
             opera

     */





}
