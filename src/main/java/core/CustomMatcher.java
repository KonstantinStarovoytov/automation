package core;

import com.codeborne.selenide.Configuration;

import static java.lang.String.format;
import static net.javacrumbs.hamcrest.logger.HamcrestLoggerMatcher.log;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.System.nanoTime;

@Slf4j
public class CustomMatcher {
    public static  <T> void assertThat(String reason, T actual, Matcher<? super T> matcher) {
        long timeoutMillis = Configuration.timeout;
        long pollingInterval = Configuration.pollingInterval;
        long startTime = nanoTime();

        while (nanoTime() - startTime < timeoutMillis * 1000000) {
            try {
                MatcherAssert.assertThat(reason, actual, log(matcher));
                return;
            } catch (Throwable e) {
                log.info("Retrying assertion for reason [{}]", reason);

                Wait.forMillis(pollingInterval);
            }
        }
        reason = format("Was waiting until condition is met during %d millis...%nCondition: %s", timeoutMillis, reason);
        MatcherAssert.assertThat(reason, actual, matcher);
    }
}