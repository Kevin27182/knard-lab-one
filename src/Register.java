public class Register {

    public Purse makeChange(double amt) {
        return new Purse();
    }

    public static void main(String[] args) {
        Register example_register = new Register();
        System.out.println(example_register.makeChange(0.0));
    }
}
