package HashTables;

import java.util.LinkedList;

public class HashTable {
    //Class(Node for holding the Entry Information both the Key and Its value..)
    private class Entry{
        private int key;
        private String value;
        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries =  new LinkedList[5];
    public void put(int key, String value){
        //Calculating The Index Of Entry using hash function
        var index = hash(key);
        //Handling Collision by using bucket in linked list mode
        if(entries[index] == null){
            entries[index] = new LinkedList<>();
        }
        //Checking The entries at a given Index (<---- Handling Collision)
        var bucket = entries[index];
        //Checking If in the bucket we have the same key and updating its value
        for(var entry: bucket){
            if(entry.key == key){
                entry.value = value;
                return;
            }
        }
        var entry = new Entry(key, value);
        bucket.addLast(entry);
    }

    public String get(int key){
        var entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if(entry == null)
            throw  new IllegalStateException("Entry not found");
        getBucket(key).remove(entry);

    }

    private LinkedList<Entry> getBucket(int key){
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key){
        var index = hash(key);
        var bucket = entries[index];
        if(bucket == null)
            entries[index] = new LinkedList<>();
        return bucket;
    }

    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if(bucket != null)
            for(var entry : bucket)
                if(entry.key == key)
                    return entry;
        return null;
    }

    // The hash function is Deterministic ....  to mean
    /*
    if the key is 2 the hash function will always return 2%5 == 2 always.
    if the key is 3 the hash function will always return 3%5 == 3
    varying according to a given hash function and this will always return the same answer
    for the same values which will be passed to the function.
    * */
    private int hash(int key){
        return (Math.abs(key) % entries.length);
    }
}
