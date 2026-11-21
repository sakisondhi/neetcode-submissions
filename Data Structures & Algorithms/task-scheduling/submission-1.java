class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] remainingCount = new int[26];

        for (char task : tasks) {
            remainingCount[task - 'A']++;
        }

        // Entry: {taskId, remainingCount, nextAvailableTime}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        for (int i = 0; i < 26; i++) {
            if (remainingCount[i] > 0) {
                maxHeap.offer(new int[]{i, remainingCount[i], 0});
            }
        }

        Queue<int[]> cooldown = new ArrayDeque<>();
        int res = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            // Skip idle intervals if no task is available.
            if (maxHeap.isEmpty()) {
                res = Math.max(res, cooldown.peek()[2]);
            }

            // Restore every task whose cooldown has finished.
            while (!cooldown.isEmpty() &&
                   cooldown.peek()[2] <= res) {
                maxHeap.offer(cooldown.poll());
            }

            // Execute the available task with highest count.
            int[] task = maxHeap.poll();
            task[1]--;

            if (task[1] > 0) {
                task[2] = res + n + 1;
                cooldown.offer(task);
            }

            res++;
        }

        return res;
    }
}