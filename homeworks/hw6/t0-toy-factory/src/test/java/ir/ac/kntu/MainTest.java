package ir.ac.kntu;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConstructorTest.class,
        FieldsModifierTest.class,
        FieldTest.class,
        MethodsModifierTest.class,
        MethodsTest.class,
        SolutionTest.class
})
public class MainTest {
}