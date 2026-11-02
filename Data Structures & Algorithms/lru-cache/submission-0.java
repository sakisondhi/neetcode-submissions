

class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node(null, null, 0, 0);
        tail = new Node(null, null, 0, 0);

        head.after = tail;
        tail.before = head;
    }

    class Node {
        Integer value;
        Integer key;
        Node before;
        Node after;

        Node(Node before, Node after, Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.before = before;
            this.after = after;
        }
    }

    public int get(int key) {
        Node n = map.getOrDefault(key, null);

        if (n != null) {
            remove(n);
            addToHead(n);
            return n.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node n = map.getOrDefault(key, null);

        if (n != null) {
            // Update existing node
            n.value = value;
            remove(n);
            addToHead(n);
        } else {
            // Insert new node
            n = new Node(null, null, key, value);
            map.put(key, n);
            addToHead(n);

            // Remove least recently used node
            if (map.size() > capacity) {
                Node lru = tail.before;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    private void remove(Node n) {
        n.before.after = n.after;
        n.after.before = n.before;
    }

    private void addToHead(Node n) {
        n.after = head.after;
        n.before = head;

        head.after.before = n;
        head.after = n;
    }
}