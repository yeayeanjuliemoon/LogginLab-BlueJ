import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());
    
    public LogginLab lab;
    
    @org.junit.Before
    public void setUp() throws Exception {
        lab = new LogginLab();
        lab.setThreshold(20);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= finalLimit; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not reached! It is "+i);
                assertTrue(lab.thresholdExceeds(i));
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(i));
            }
        }
    }
    
    @Test
    public void thresholdReachedFalse() {
        boolean expected = false;
        boolean actual = lab.thresholdReached(5);

        logger.log(Level.INFO, "Threshold not reached! It is 5");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void thresholdReachedTrue() {
        boolean expected = true;
        boolean actual = lab.thresholdReached(25);

        logger.log(Level.INFO, ("Threshold finally reached!"));
        Assert.assertEquals(expected, actual);
    }
    
}