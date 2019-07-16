package core;

import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.executeJavaScript;

@Slf4j
public class Wait {
    public static void forMillis (long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.warn("Can't wait millis =" + millis);
        }
    }

    public static void forAjax () {
        int i;
        for (i = 0; i < 100; i++) {
            boolean ajaxIsComplete = executeJavaScript("return jQuery.active == 0");
            if (ajaxIsComplete) break;
            Wait.forMillis(100);
        }
    }

    public static void forSeconds (int seconds) {
        forMillis(seconds * 1000);
    }
}
