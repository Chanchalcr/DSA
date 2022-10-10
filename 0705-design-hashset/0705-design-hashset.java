class MyHashSet {
    boolean[] temp = new boolean[1000001];

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        temp[key] = true;
    }
    
    public void remove(int key) {
        temp[key] = false;
    }
    
    public boolean contains(int key) {
        return temp[key];
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */