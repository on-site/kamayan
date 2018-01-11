package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.TreeSet;

import org.junit.Ignore;
import org.junit.Test;

public class Serving_08_TreeSetTest extends TestCase {
    // Add returns itself
    // Add increases the size
    // Add doesn't increase the size if the value is already there
    // Add doesn't insert a duplicate node
    // Add the first element goes to the root
    // Add a smaller object adds to the left
    // Add a larger object adds to the right

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
