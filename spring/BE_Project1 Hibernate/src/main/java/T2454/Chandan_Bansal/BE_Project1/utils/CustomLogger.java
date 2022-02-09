package T2454.Chandan_Bansal.BE_Project1.utils;

import T2454.Chandan_Bansal.BE_Project1.BeProject1Application;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class CustomLogger {
    public static final Logger logger = Logger.getLogger(String.valueOf(BeProject1Application.class));
    static {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d [%p|%c|%C{1}] %m%n"));
        consoleAppender.activateOptions();
        Logger.getRootLogger().addAppender(consoleAppender);
    }

}
