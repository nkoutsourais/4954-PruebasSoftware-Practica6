package draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
  draughts.controllers.AllTest.class, 
  draughts.models.AllTest.class, 
})
public class AllTest {

}