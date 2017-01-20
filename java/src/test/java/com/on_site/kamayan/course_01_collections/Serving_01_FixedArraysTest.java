package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.TestCase;

import org.junit.Test;

/**
 * The Object[] class in Java represents a fixed block of memory that will let
 * you store any object within the block. The size of these objects cannot be
 * changed once they are created.
 *
 * These tests are to help familiarize you with Object[]. You will be using it
 * in further servings to implement other familiar data sets.
 */
public class Serving_01_FixedArraysTest extends TestCase {
    @Test
    public void aFixedArrayHasASizeSpecifiedWhenItIsCreated() {
        assertEquals(__, new Object[0].length);
        assertEquals(__, new Object[1].length);
        assertEquals(__, new Object[42].length);
    }

    @Test
    public void valuesCanBeSetAndRetrieved() {
        Object[] array = new Object[3];

        array[0] = 1;
        array[1] = 2;
        array[2] = 42;

        assertEquals(__, array[0]);
        assertEquals(__, array[1]);
        assertEquals(__, array[2]);
    }

    @Test
    public void initialValuesAreNull() {
        Object[] array = new Object[3];
        assertEquals(__, array[0]);
        assertEquals(__, array[1]);
        assertEquals(__, array[2]);
    }

    @Test
    public void gettingAndSettingAtAnIndexMustBeWithinTheBoundsOfTheInitialSize() {
        Object[] array = new Object[5];
        assertThrows(___, () -> { Object x = array[-1]; });
        assertThrows(___, () -> { Object x = array[5]; });
        assertThrows(___, () -> array[-1] = 1);
        assertThrows(___, () -> array[5] = 42);
    }
}
