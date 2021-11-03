class MyHashSet {
    
    private final ArrayList<Integer> list = new ArrayList<>();

    public MyHashSet() {
    }
    
    public void add(int key) {
        if (list.size() == 0) {
            list.add(key);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.contains(key)) {
                    break;
                } else {
                    list.add(key);
                }
            }
        }
    }
    
    public void remove(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(key)) list.remove(i);
        }
    }
    
    public boolean contains(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(key)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
=============================================================================
private final boolean arr[];
public MyHashSet() {
	arr = new boolean[1000001];
}

public void add(int key) {
	arr[key] = true;
}

public void remove(int key) {
	arr[key] = false;
}

public boolean contains(int key) {
	return arr[key];
}
