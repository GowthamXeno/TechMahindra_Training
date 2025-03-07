public class Example {

    private final int finalVariable = 100;

    public final void FinalMethod() {
        System.out.println("This is a final method.");
    }

    public void displayVariable() {
        System.out.println("Final variable value: " + finalVariable);
    }
    public static void main(String[] args) {
        // finalVariable = 10;
        Example ex = new Example();
        System.out.println(ex.finalVariable);

    }
}
final class FinalClassExample{

}
// class Child extends FinalClassExample{

// }
