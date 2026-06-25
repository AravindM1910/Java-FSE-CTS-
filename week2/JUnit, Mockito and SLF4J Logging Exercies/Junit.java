package Week1.Module4.LoggingUsingSLF4J;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String user = "Sanjai";
        int age = 20;

        logger.info("User {} is {} years old",user, age);
    }
}