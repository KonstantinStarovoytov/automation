package anatations.custom_testng;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DisableTransformer implements IAnnotationTransformer {

    /**
     * This method is a not successful attempt to create annotation that allow you to
     * mark test method with Users whom you don't want to run test method.
     * This attempt has no success because information about user for whom we want to
     * switch off test method we can get only from XMLSuite which load after
     * test framework compilation and we can get XML info only from ITestContext which is
     * not accessible from this CustomListener. Good decision for that problem await's you!
     *
     * @param annotation
     * @param testClass
     * @param testConstructor
     * @param testMethod
     */
    @Override
    public void transform (ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod == null) {
            return;
        }
        if (hasDisabledUsers(testMethod)) {
            annotation.setEnabled(false);
        }
    }

    /**
     * For method higher. ^^^
     *
     * @param testMethod
     * @return
     */
    private boolean hasDisabledUsers (Method testMethod) {
        DisableForUsers disabledUsers = testMethod.getAnnotation(DisableForUsers.class);

        return disabledUsers != null;
    }
}
