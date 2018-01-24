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

    // Add a smaller object adds to the left
    // Add a larger object adds to the right
    // Add doesn't insert a duplicate node that is to the left of the root
    // Add doesn't insert a duplicate node that is to the right of the root

    // Contains with an empty tree returns false
    // Contains where the root equals the value
    // Contains where the value is not in the tree
    // Contains where the value is on the left branch
    // Contains where the value is on the right branch

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
