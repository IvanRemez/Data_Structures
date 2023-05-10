package Review.Stacks;

public class PowerOfTwo {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(64));   // true
        System.out.println(isPowerOfTwo(0));   // false

    }

    public static boolean isPowerOfTwo(int n) {
    // base condition
        if (n == 1) return true;
        // ^^ after recursion is done, n needs to equal 1 to be a power of 2

        if (n % 2 != 0 || n <= 0) {
            return false;
        }
        return isPowerOfTwo(n/2);
    }
}
