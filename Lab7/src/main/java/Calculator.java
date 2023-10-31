import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.pattern.NotANumber;

public class Calculator {
    protected static  final Logger logger = LogManager.getLogger();
    public static Double Sum(double a, double b){
        try {
            logger.info(a + " + " + b + " = " + (a + b));
            return a + b;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public static Double Minus(double a, double b){
        try {
            logger.info(a + " - " + b + " = " + (a - b));
            return a - b;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public static Double Multiply(double a, double b){
        try {
            logger.info(a + " * " + b + " = " + (a * b));
            return a * b;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public static Double Divide(double a, double b){
        try {
            logger.info(a + " / " + b + " = " + (a / b));
            return a / b;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public static Double Sqrt(double a){
        try {
            if (Double.isNaN(Math.sqrt(a))){
                logger.error("ERROR: Negative value in sqrt.");
                return null;
            }
            else{
                logger.info("SQRT " + a + " = " + Math.sqrt(a));
                return Math.sqrt(a);
            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
