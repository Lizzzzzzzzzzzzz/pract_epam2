package Tester;

public class TesterDemo {
    public static void main(String[] args) throws Exception {
        final TestRunner runner = new TestRunner();
        runner.run(MyTest.class);
        EnumBuilder enumBuilder = new EnumBuilder();
        enumBuilder.createEnumObject(java.lang.Enum.class);
        System.out.println(enumBuilder.getClass());
    }
}
