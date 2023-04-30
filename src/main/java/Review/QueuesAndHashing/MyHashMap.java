package Review.QueuesAndHashing;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

    public int modulusNum;
    public List<Bucket> hashMap;

    public MyHashMap() {
        this.modulusNum = 2341;
        this.hashMap = new ArrayList<Bucket>();
        for (int i = 0; i < 2341; i++) {

            this.hashMap.add(new Bucket());
        }
    }

    public void put(int key, int value) {

        int hashCode = key % this.modulusNum;
        this.hashMap.get(hashCode).update(key, value);
    }

    public int get(int key) {

        int hashCode = key % this.modulusNum;
        return this.hashMap.get(hashCode).get(key);
    }

    public void remove(int key) {

        int hashCode = key % this.modulusNum;
        this.hashMap.get(hashCode).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */