package midterm;

import java.util.*;

public class M02_YouBikeNextArrival {

   
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }


    private static String toHHMM(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] times = new String[n];
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = sc.next();
            minutes[i] = toMinutes(times[i]);
        }

        String query = sc.next();
        int q = toMinutes(query);

        
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (minutes[mid] > q) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(times[ans]);
        }

        sc.close();
    }
}