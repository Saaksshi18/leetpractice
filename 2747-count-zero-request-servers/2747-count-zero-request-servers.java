
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Sort logs according to time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = queries.length;

        // Store query time and original index
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Sort queries according to time
        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        int[] answer = new int[m];

        // Frequency of requests for each server
        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;

        // Number of servers with at least one request
        int activeServers = 0;

        for (int i = 0; i < m; i++) {

            int q = sortedQueries[i][0];
            int index = sortedQueries[i][1];

            // Add logs within the right boundary
            while (right < logs.length &&
                   logs[right][1] <= q) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    activeServers++;
                }

                freq[server]++;
                right++;
            }

            // Remove logs outside the left boundary
            while (left < logs.length &&
                   logs[left][1] < q - x) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            // Count servers with zero requests
            answer[index] = n - activeServers;
        }

        return answer;
    }
}
