package testes;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;;

@RunWith(Suite.class)
@SuiteClasses({SystemInterTest.class,DatabaseTest.class,ProjectTest.class})

public class MySuite {

}
