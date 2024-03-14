package utils;

public class util {
    public boolean isPrime(int prime) {
        if (prime < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(prime); i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }
}
