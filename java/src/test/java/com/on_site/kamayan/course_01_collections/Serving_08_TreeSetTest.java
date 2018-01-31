package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.TreeSet;

import org.junit.Ignore;
import org.junit.Test;

public class Serving_08_TreeSetTest extends TestCase {
    @Ignore("Remove this line to run this test")
    @Test
    public void addReturnsSelf() {
        TreeSet<Integer> set = new TreeSet<>();
        assertEquals(set, set.add(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addIncreasesTheSize() {
        TreeSet<Integer> set = new TreeSet<>();
        assertEquals(0, set.size());
        set.add(42);
        assertEquals(1, set.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntIncreaseTheSizeIfTheValueIsAlreadyThere() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertEquals(1, set.size());
        set.add(42);
        assertEquals(1, set.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addTheFirstElementGoesToTheRoot() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertEquals(42, Kamayan.getField(set, Integer.class, "root", "value"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntInsertADuplicateNode() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(42);
        assertNull(Kamayan.getField(set, Object.class, "root", "left"));
        assertNull(Kamayan.getField(set, Object.class, "root", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addASmallerObjectAddsToTheLeft() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        assertEquals(13, Kamayan.getField(set, Integer.class, "root", "left", "value"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addALargerObjectAddsToTheRight() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(84);
        assertEquals(84, Kamayan.getField(set, Integer.class, "root", "right", "value"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntInsertADuplicateNodeThatIsToTheLeftOfTheRoot() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        set.add(13);
        assertNull(Kamayan.getField(set, Object.class, "root", "left", "left"));
        assertNull(Kamayan.getField(set, Object.class, "root", "left", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addDoesntInsertADuplicateNodeThatIsToTheRightOfTheRoot() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(84);
        set.add(84);
        assertNull(Kamayan.getField(set, Object.class, "root", "right", "left"));
        assertNull(Kamayan.getField(set, Object.class, "root", "right", "right"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsWithAnEmptyTreeReturnsFalse() {
        TreeSet<Integer> set = new TreeSet<>();
        assertFalse(set.contains(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsTrueWhereTheRootEqualsTheValue() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertTrue(set.contains(42));
        set.add(13);
        assertTrue(set.contains(42));
        set.add(84);
        assertTrue(set.contains(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsFalseWhereTheValueIsNotInTheTree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        assertFalse(set.contains(7));
        set.add(13);
        assertFalse(set.contains(7));
        set.add(84);
        assertFalse(set.contains(7));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsWhereTheValueIsOnTheLeftBranch() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        set.add(84);
        assertTrue(set.contains(13));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsWhereTheValueIsOnTheRightBranch() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(42);
        set.add(13);
        set.add(84);
        assertTrue(set.contains(84));
    }

    // Remove returns itself
    // Remove does nothing when the tree is empty
    // Remove decreases the size if the value is there
    // Remove doesn't decrease the size if the value is not there
    // Remove with one element removes the root
    // Remove for the left element removes that node
    // Remove for the right element removes that node
    // Remove the root when there exists left and right nodes doesn't remove those nodes
    // Remove a child that has children only removes the desired node

    // Each returns itself
    // Each does nothing when the tree is empty
    // Each yields the root when there is just one node
    // Each yields all the elements when there are several nodes
    // Each yields from smallest to largest in a balanced tree
}
