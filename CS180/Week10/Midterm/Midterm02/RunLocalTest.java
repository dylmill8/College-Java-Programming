import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public class RunLocalTest {

    public static void main(String[] args) {
        System.out.println("Warning: This test class only check the spelling of class methods and fields.");
        System.out.println("All testing is your responsibility. These tests do not guarantee correctness.");

        Result result = JUnitCore.runClasses(TestCase.class);

        if (result.wasSuccessful()) {
            System.out.println("No method or field spelling errors detected. Verify using the handout.");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    /**
     * A set of midterm exam spelling verification test cases. No implementation checks are present.
     *
     * <p>Purdue University -- CS18000 -- Fall 2022</p>
     *
     * @author Purdue CS
     * @version August 21, 2022
     */
    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        @Test(timeout = 1000)
        public void verifyMovieProfilerClassMethods() {
            Class<?> clazz;
            String[] expectedMethodNames = {
                    "main",
                    "readFile",
                    "writeFile",
            };

            try {
                clazz = Class.forName("MovieProfiler");

                Method[] methods = clazz.getDeclaredMethods();

                ArrayList<String> implementedMethodNames = new ArrayList<String>();

                for (Method method : methods) {
                    int modifiers = method.getModifiers();

                    if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                        implementedMethodNames.add(method.getName());
                    }
                }

                for (int i = 0; i < expectedMethodNames.length; i++) {
                    if (!implementedMethodNames.contains(expectedMethodNames[i])) {
                        Assert.fail("Missing Public Static Method: " + expectedMethodNames[i]);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

        @Test(timeout = 1000)
        public void verifyStudioProjectClassMethods() {
            Class<?> clazz;
            String[] expectedMethodNames = {
                    "getProjectName",
                    "getEmployeeCount",
                    "hasPriority",
                    "calculateCostEstimate",
                    "findSimilarProjects"
            };

            try {
                clazz = Class.forName("StudioProject");

                Method[] methods = clazz.getDeclaredMethods();

                ArrayList<String> implementedMethodNames = new ArrayList<String>();

                for (Method method : methods) {
                    int modifiers = method.getModifiers();

                    if (Modifier.isPublic(modifiers)) {
                        implementedMethodNames.add(method.getName());
                    }
                }

                for (int i = 0; i < expectedMethodNames.length; i++) {
                    if (!implementedMethodNames.contains(expectedMethodNames[i])) {
                        Assert.fail("Missing Public Method: " + expectedMethodNames[i]);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

        @Test(timeout = 1000)
        public void verifyMovieClassFields() {
            Class<?> clazz;
            String[] expectedFieldNames = {
                    "projectName",
                    "employeeCount",
                    "priority"
            };

            try {
                clazz = Class.forName("Movie");

                Field[] fields = clazz.getDeclaredFields();

                ArrayList<String> implementedFieldNames = new ArrayList<String>();

                for (Field field : fields) {
                    int modifiers = field.getModifiers();

                    if (Modifier.isPrivate(modifiers)) {
                        implementedFieldNames.add(field.getName());
                    }
                }

                for (int i = 0; i < expectedFieldNames.length; i++) {
                    if (!implementedFieldNames.contains(expectedFieldNames[i])) {
                        Assert.fail("Missing Private Field: " + expectedFieldNames[i]);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        @Test(timeout = 1000)
        public void verifyMovieClassMethods() {
            Class<?> clazz;
            String[] expectedMethodNames = {
                    "getProjectName",
                    "getEmployeeCount",
                    "hasPriority",
                    "calculateCostEstimate",
                    "findSimilarProjects"
            };

            try {
                clazz = Class.forName("Movie");

                Method[] methods = clazz.getDeclaredMethods();

                ArrayList<String> implementedMethodNames = new ArrayList<String>();

                for (Method method : methods) {
                    int modifiers = method.getModifiers();

                    if (Modifier.isPublic(modifiers)) {
                        implementedMethodNames.add(method.getName());
                    }
                }

                for (int i = 0; i < expectedMethodNames.length; i++) {
                    if (!implementedMethodNames.contains(expectedMethodNames[i])) {
                        Assert.fail("Missing Public Method: " + expectedMethodNames[i]);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

        @Test(timeout = 1000)
        public void verifyDirectToVideoClassFields() {
            Class<?> clazz;
            String[] expectedFieldNames = {
                    "releaseFormatCount",
                    "sales",
            };

            try {
                clazz = Class.forName("DirectToVideo");

                Field[] fields = clazz.getDeclaredFields();

                ArrayList<String> implementedFieldNames = new ArrayList<String>();

                for (Field field : fields) {
                    int modifiers = field.getModifiers();

                    if (Modifier.isPrivate(modifiers)) {
                        implementedFieldNames.add(field.getName());
                    }
                }

                for (int i = 0; i < expectedFieldNames.length; i++) {
                    if (!implementedFieldNames.contains(expectedFieldNames[i])) {
                        Assert.fail("Missing Private Field: " + expectedFieldNames[i]);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        @Test(timeout = 1000)
        public void verifyDirectToVideoClassMethods() {
            Class<?> clazz;
            String[] expectedMethodNames = {
                    "getReleaseFormatCount",
                    "getSales",
                    "calculateAverageFormatSales",
                    "calculateReturnOnInvestment",
            };

            try {
                clazz = Class.forName("DirectToVideo");

                Method[] methods = clazz.getDeclaredMethods();

                ArrayList<String> implementedMethodNames = new ArrayList<String>();

                for (Method method : methods) {
                    int modifiers = method.getModifiers();

                    if (Modifier.isPublic(modifiers)) {
                        implementedMethodNames.add(method.getName());
                    }
                }

                for (int i = 0; i < expectedMethodNames.length; i++) {
                    if (!implementedMethodNames.contains(expectedMethodNames[i])) {
                        Assert.fail("Missing Public Method: " + expectedMethodNames[i]);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

    }

}