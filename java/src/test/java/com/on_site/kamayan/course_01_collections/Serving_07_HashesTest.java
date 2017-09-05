package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.DoublyLinkedList;
import com.on_site.kamayan.collections.Hash;
import com.on_site.kamayan.collections.MissingKeyException;

import org.junit.Ignore;
import org.junit.Test;

public class Serving_07_HashesTest extends TestCase {
    public static class Key {
        private final Object value;
        private final int hashCode;

        public Key(Object value, int hashCode) {
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public boolean equals(Object other) {
            return value.equals(((Key) other).value);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void putReturnsThisSoItCanBeChained() throws Exception {
        Hash hash = new Hash();
        assertEquals(hash, hash.put("abc", 42));
        assertEquals(hash, hash.put("xyz", 123));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void putIncreasesSize() throws Exception {
        Hash hash = new Hash();
        assertEquals(0, hash.size());
        hash.put("abc", 42);
        assertEquals(1, hash.size());
        hash.put("xyz", 123);
        assertEquals(2, hash.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void putWithNullKeyThrowsAnException() throws Exception {
        Hash hash = new Hash();
        assertThrows(NullPointerException.class, () -> hash.put(null, 42));
        assertEquals(0, hash.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void putWithDifferentKeyButSameHashCodeIncreasesSize() throws Exception {
        Hash hash = new Hash();
        hash.put(new Key("abc", 1), 42);
        assertEquals(1, hash.size());
        hash.put(new Key("xyz", 1), 123);
        assertEquals(2, hash.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getWithMissingKeyThrowsException() throws Exception {
        Hash hash = new Hash();
        assertThrows(MissingKeyException.class, () -> hash.get("abc"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getWithExistingKeyReturnsTheValueStored() throws Exception {
        Hash hash = new Hash().put("abc", 42).put("xyz", 123);
        assertEquals(42, hash.get("abc"));
        assertEquals(123, hash.get("xyz"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getAfterPutReturnsNewValue() throws Exception {
        Hash hash = new Hash().put("abc", 42);
        assertEquals(42, hash.get("abc"));
        hash.put("abc", 123);
        assertEquals(123, hash.get("abc"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void putWithSameKeyDoesntIncreaseSize() throws Exception {
        Hash hash = new Hash();
        String key = "abc";
        hash.put(key, 42);
        assertEquals(1, hash.size());
        hash.put(key, 123);
        assertEquals(1, hash.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void putWithDifferentKeyButEqualsIsTrueDoesntIncreaseSize() throws Exception {
        Hash hash = new Hash();
        hash.put(new Key("abc", 1), 42);
        assertEquals(1, hash.size());
        hash.put(new Key("abc", 1), 123);
        assertEquals(1, hash.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getForDifferentKeysButSameHashCodeReturnsCorrectValue() throws Exception {
        Key key1 = new Key("abc", 1);
        Key key2 = new Key("xyz", 1);
        Hash hash = new Hash().put(key1, 42).put(key2, 123);
        assertEquals(42, hash.get(key1));
        assertEquals(123, hash.get(key2));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getForDifferentKeysButEqualsIsTrueReturnsTheSameValue() throws Exception {
        Hash hash = new Hash().put(new Key("abc", 1), 42);
        assertEquals(42, hash.get(new Key("abc", 1)));
        assertEquals(42, hash.get(new Key("abc", 1)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void manyPutsCausesInternalArrayToBeResizedAndRehashedButEntriesStay() throws Exception {
        Hash hash = new Hash();
        DoublyLinkedList[] internalHash = Kamayan.getField(hash, DoublyLinkedList[].class, "hash");
        Kamayan.times(1000, (i) -> hash.put("key" + i, i));
        DoublyLinkedList[] newInternalHash = Kamayan.getField(hash, DoublyLinkedList[].class, "hash");
        assertTrue(newInternalHash.length > internalHash.length);
        Kamayan.times(1000, (i) -> assertEquals(i, hash.get("key" + i)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsFalseForEmptyHash() throws Exception {
        Hash hash = new Hash();
        assertFalse(hash.contains("abc"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsFalseForMissingKeys() throws Exception {
        Hash hash = new Hash().put("abc", 42);
        assertFalse(hash.contains("xyz"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsTrueForExistingKeys() throws Exception {
        Hash hash = new Hash().put("abc", 42).put("xyz", 123);
        assertTrue(hash.contains("abc"));
        assertTrue(hash.contains("xyz"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsCorrectlyForDifferentKeysWithSameHashButNotEqual() throws Exception {
        Key key1 = new Key("abc", 1);
        Key key2 = new Key("xyz", 1);
        Hash hash = new Hash().put(key1, 42);
        assertTrue(hash.contains(key1));
        assertFalse(hash.contains(key2));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void containsReturnsTrueForDifferentKeysWhenEqualsIsTrue() throws Exception {
        Hash hash = new Hash().put(new Key("abc", 1), 42);
        assertTrue(hash.contains(new Key("abc", 1)));
        assertTrue(hash.contains(new Key("abc", 1)));
    }
}
