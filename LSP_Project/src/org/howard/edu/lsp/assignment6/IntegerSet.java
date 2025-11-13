package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) o;
        if (this.length() != other.length()) return false;
        return this.set.containsAll(other.set) && other.set.containsAll(this.set);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() {
        if (set.isEmpty()) throw new IllegalStateException("empty");
        int max = set.get(0);
        for (int v : set) if (v > max) max = v;
        return max;
    }

    public int smallest() {
        if (set.isEmpty()) throw new IllegalStateException("empty");
        int min = set.get(0);
        for (int v : set) if (v < min) min = v;
        return min;
    }

    public void add(int item) {
        if (!set.contains(item)) set.add(item);
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public void union(IntegerSet other) {
        for (int v : other.set)
            if (!set.contains(v)) set.add(v);
    }

    public void intersect(IntegerSet other) {
        set.retainAll(other.set);
    }

    public void diff(IntegerSet other) {
        set.removeAll(other.set);
    }

    public void complement(IntegerSet other) {
        List<Integer> newSet = new ArrayList<Integer>(other.set);
        newSet.removeAll(set);
        set = newSet;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < set.size(); i++) {
            sb.append(set.get(i));
            if (i < set.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
