package Review.QueuesAndHashing;

import java.util.LinkedList;

public class Bucket {

    LinkedList<KeyValue<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<KeyValue<Integer, Integer>>();
    }

    public Integer get(Integer key) {

        for (KeyValue<Integer, Integer> pair : bucket) {

            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;  // couldn't find the key
    }

    public void update(int key, int value) {
// if elements exists, update it
        boolean found = false;
        for (KeyValue<Integer, Integer> pair : bucket) {

            if (pair.key.equals(key)) {
                pair.value = value;
                found = true;
            }
        }
        // if element doesn't exist, add it
        if (!found) {
            this.bucket.add(new KeyValue<>(key, value));
        }
    }

    public void remove(int key) {

        for (KeyValue<Integer, Integer> pair : bucket) {
            if (pair.key.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}
