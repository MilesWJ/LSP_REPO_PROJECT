package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
        set.add(10);
        set.add(20);
        assertEquals(2, set.length());
        set.add(20);
        assertEquals(2, set.length());
    }

    @Test
    public void testEqualsSameElementsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(1);
        set2.add(2);
        assertTrue(set1.equals(set2));
        assertTrue(set2.equals(set1));
    }

    @Test
    public void testEqualsDifferentSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        assertTrue(set.contains(5));
        assertTrue(set.contains(10));
        assertFalse(set.contains(7));
    }

    @Test
    public void testLargestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(10);
        set.add(1);
        assertEquals(10, set.largest());
    }

    @Test
    public void testLargestOnEmptyThrows() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.largest());
    }

    @Test
    public void testSmallestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(10);
        set.add(1);
        assertEquals(1, set.smallest());
    }

    @Test
    public void testSmallestOnEmptyThrows() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.smallest());
    }

    @Test
    public void testAddNoDuplicates() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(4);
        set.add(4);
        assertEquals(1, set.length());
        assertTrue(set.contains(4));
    }

    @Test
    public void testRemoveExistingAndNonExisting() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);
        assertFalse(set.contains(2));
        assertEquals(2, set.length());
        set.remove(10);
        assertEquals(2, set.length());
    }

    @Test
    public void testUnionWithOverlap() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(3, set1.length());
    }

    @Test
    public void testIntersectSomeCommon() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(4);
        set1.intersect(set2);
        assertEquals(1, set1.length());
        assertTrue(set1.contains(2));
    }

    @Test
    public void testDiffRemovesOverlaps() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(4);
        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(2));
    }

    @Test
    public void testComplementBasic() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set1.complement(set2);
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
    }

    @Test
    public void testIsEmptyOnNewSet() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testToStringFormat() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
        set.add(10);
        set.add(20);
        assertEquals("[10, 20]", set.toString());
    }
}
