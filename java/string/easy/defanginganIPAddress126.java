package string.easy;

public class defanginganIPAddress126 {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        defanginganIPAddress126 solution = new defanginganIPAddress126();

        String address1 = "1.1.1.1";
        String address2 = "255.100.50.0";

        System.out.println("Input : " + address1);
        System.out.println("Output: " + solution.defangIPaddr(address1));

        System.out.println();

        System.out.println("Input : " + address2);
        System.out.println("Output: " + solution.defangIPaddr(address2));
    }
}