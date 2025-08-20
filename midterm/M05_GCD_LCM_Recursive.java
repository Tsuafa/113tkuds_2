
import java.util.*;

public class M05_GCD_LCM_Recursive {

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b, long gcd) {
        return (a / gcd) * b; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long g = gcd(a, b);
        long l = lcm(a, b, g);

        System.out.println("GCD: " + g);
        System.out.println("LCM: " + l);

        sc.close();
    }
}

    /*
     * Time Complexity: O(log(min(a,b)))
     * 說明：
     * 1) 遞迴歐幾里得算法每次將參數縮小至餘數，最多 log(min(a,b)) 次。
     * 2) 計算 LCM = a / gcd * b → O(1)。
     * 3) 所以整體複雜度 = O(log(min(a,b)))。
     */