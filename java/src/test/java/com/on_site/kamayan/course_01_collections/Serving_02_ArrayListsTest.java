package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.ArrayList;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

/**
 * For this serving, you will be implementing your own version of the ArrayList
 * class. You can find a stub of the class in
 * src/main/java/com/on_site/kamayan/collections/ArrayList.java, while the tests
 * here will help ensure you have implemented the core features.
 *
 * You may only use Object[] for storing the contents of the ArrayList. Do not
 * be afraid to add new methods as you see fit, but keep any new methods
 * private.
 *
 * Starting with this serving, all tests are ignored. You must delete
 * the @Ignore annotation above each test as you are ready to run it.
 *
 * Further instructions can be found inside the ArrayList class.
 *
 * Diagram of an array list as it grows:
 *
 *   size = 3
 *
 *   +---+---+---+---+---+---+---+---+---+---+
 *   | a | b | c |   |   |   |   |   |   |   |
 *   +---+---+---+---+---+---+---+---+---+---+
 *
 *
 *   size = 9
 *
 *   +---+---+---+---+---+---+---+---+---+---+
 *   | a | b | c | d | e | f | g | h | i |   |
 *   +---+---+---+---+---+---+---+---+---+---+
 *
 *
 *   size = 12
 *
 *   +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 *   | a | b | c | d | e | f | g | h | i | j | k | l |   |   |   |   |   |   |   |   |
 *   +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 */
public class Serving_02_ArrayListsTest extends TestCase {
    @Ignore("Remove this line to run this test")
    @Test
    public void addIncreasesTheSize() {
        ArrayList list = new ArrayList();
        list.add(42);
        assertEquals(1, list.size());
        list.add(43);
        assertEquals(2, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addAddsToTheEnd() {
        ArrayList list = new ArrayList();
        list.add(42);
        list.add(43);
        assertEquals(42, list.get(0));
        assertEquals(43, list.get(1));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addReturnsThisSoThatItIsChainable() {
        ArrayList list = new ArrayList();
        list.add(42).add(43);
        assertEquals(42, list.get(0));
        assertEquals(43, list.get(1));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependIncreasesTheSize() {
        ArrayList list = new ArrayList();
        list.prepend(42);
        assertEquals(1, list.size());
        list.prepend(43);
        assertEquals(2, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependAddsToTheBeginning() {
        ArrayList list = new ArrayList();
        list.prepend(42);
        list.prepend(43);
        assertEquals(43, list.get(0));
        assertEquals(42, list.get(1));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependReturnsThisSoThatItIsChainable() {
        ArrayList list = new ArrayList();
        list.prepend(42).prepend(43);
        assertEquals(43, list.get(0));
        assertEquals(42, list.get(1));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addAndPrependAreChainableTogether() {
        ArrayList list = new ArrayList();
        list.add(42).add(43).prepend(2).prepend(1);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(42, list.get(2));
        assertEquals(43, list.get(3));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void chainedAddAndPrependIncreasesTheSize() {
        ArrayList list = new ArrayList();
        list.add(42).add(43).prepend(2).prepend(1);
        assertEquals(4, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addCanBeCalledALot() {
        ArrayList list = new ArrayList();
        Kamayan.times(100, (i) -> list.add(42));
        assertEquals(100, list.size());
        Kamayan.times(100, (i) -> assertEquals(42, list.get(i)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependCanBeCalledALot() {
        ArrayList list = new ArrayList();
        Kamayan.times(100, (i) -> list.prepend(42));
        assertEquals(100, list.size());
        Kamayan.times(100, (i) -> assertEquals(42, list.get(i)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getCannotGoOutsideTheBoundsOfTheArray() {
        ArrayList list = new ArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-42));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        list.add(1);
        list.get(0); // No error now that the index is valid
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getCanRetrieveAnyElement() {
        ArrayList list = new ArrayList().add(1).add(2).add(42).add(43);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(42, list.get(2));
        assertEquals(43, list.get(3));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCannotUseNegativeNumber() {
        ArrayList list = new ArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-42, 1));
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCanUseExistingIndexes() {
        ArrayList list = new ArrayList().add(0).add(1).add(2).add(3);
        list.set(0, 1);
        list.set(1, 2);
        list.set(2, 3);
        list.set(3, 4);
        Kamayan.times(4, (i) -> assertEquals(i + 1, list.get(i)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCanAddElementsToTheEndOfTheList() {
        ArrayList list = new ArrayList();
        list.set(0, 1);
        list.set(1, 2);
        list.set(2, 3);
        list.set(3, 4);
        Kamayan.times(4, (i) -> assertEquals(i + 1, list.get(i)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCanUseDistantIndexes() {
        ArrayList list = new ArrayList();
        list.set(42, 1);
        list.set(142, 2);
        list.set(1042, 3);
        Kamayan.times(42, (i) -> assertNull(list.get(i)));
        Kamayan.range(43, 141, (i) -> assertNull(list.get(i)));
        Kamayan.range(143, 1041, (i) -> assertNull(list.get(i)));
        assertEquals(1, list.get(42));
        assertEquals(2, list.get(142));
        assertEquals(3, list.get(1042));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setWithTheNextAvailableIndexUpdatesTheSize() {
        ArrayList list = new ArrayList();
        list.set(0, 1);
        assertEquals(1, list.size());
        list.set(1, 2);
        assertEquals(2, list.size());
        list.set(2, 3);
        assertEquals(3, list.size());
        list.set(3, 4);
        assertEquals(4, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setWithExistingIndexesDoesntUpdateTheSize() {
        ArrayList list = new ArrayList().add(0).add(1).add(2).add(3);
        list.set(0, 1);
        assertEquals(4, list.size());
        list.set(1, 2);
        assertEquals(4, list.size());
        list.set(2, 3);
        assertEquals(4, list.size());
        list.set(3, 4);
        assertEquals(4, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setWithDistantIndexesUpdatesTheSize() {
        ArrayList list = new ArrayList();
        list.set(42, 1);
        assertEquals(43, list.size());
        list.set(142, 2);
        assertEquals(143, list.size());
        list.set(1042, 3);
        assertEquals(1043, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setReturnsNullIfThePreviousValueWasNull() {
        ArrayList list = new ArrayList().add(null);
        assertNull(list.set(0, 42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setReturnsNullIfTheIndexIsBeyondTheCurrentSize() {
        ArrayList list = new ArrayList();
        assertNull(list.set(0, 42));
        assertNull(list.set(42, 43));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setReturnsThePreviousValue() {
        ArrayList list = new ArrayList().add(1).add(2).add(3);
        assertEquals(1, list.set(0, 42));
        assertEquals(42, list.set(0, 43));
        assertEquals(2, list.set(1, 44));
        assertEquals(3, list.set(2, 45));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteCannotDeleteOutsideTheBoundsOfTheList() {
        ArrayList list = new ArrayList().add(1).add(2).add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-42));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteRemovesTheElement() {
        ArrayList list = new ArrayList().add(1).add(2).add(3);
        list.delete(1);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteUpdatesTheSize() {
        ArrayList list = new ArrayList().add(1).add(2).add(3);
        list.delete(1);
        assertEquals(2, list.size());
        list.delete(0);
        assertEquals(1, list.size());
        list.delete(0);
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteReturnsTheElementAtTheIndex() {
        ArrayList list = new ArrayList().add(1).add(2).add(3);
        assertEquals(1, list.delete(0));
        assertEquals(3, list.delete(1));
        assertEquals(2, list.delete(0));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteCanBeCalledALot() {
        ArrayList list = new ArrayList();
        Kamayan.times(100, (i) -> list.add(42));
        Kamayan.times(100, (i) -> list.delete(0));
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteCanDeleteFromAFullArray() {
        ArrayList list = new ArrayList();
        Object[] internalArray = Kamayan.getField(list, Object[].class, "array");
        Kamayan.setField(list, "size", internalArray.length);
        Arrays.fill(internalArray, 42);
        assertEquals(42, list.delete(5));
        assertEquals(9, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteDoesntLeaveDeletedElementsInTheArray() {
        ArrayList list = new ArrayList();
        Object[] internalArray = Kamayan.getField(list, Object[].class, "array");
        Kamayan.setField(list, "size", internalArray.length);
        Arrays.fill(internalArray, 42);
        assertEquals(42, list.delete(5));
        assertEquals(9, list.size());
        assertNull(Kamayan.getField(list, Object[].class, "array")[9]);
    }
}
