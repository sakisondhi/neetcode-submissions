class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> count = new TreeMap<>();

        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        while (!count.isEmpty()) {
            int start = count.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int num = start + i;

                if (!count.containsKey(num)) {
                    return false;
                }

                count.put(num, count.get(num) - 1);

                if (count.get(num) == 0) {
                    count.remove(num);
                }
            }
        }

        return true;
    }
}