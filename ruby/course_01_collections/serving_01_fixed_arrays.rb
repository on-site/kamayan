require_relative "../kamayan"

# In Ruby, the Array class represents a collection of items. However, an Array
# in Ruby is not like the arrays in other languages. Typically, an array in
# another language represents a fixed block of memory for storing multiple
# copies of a certain type of object. The size of the array cannot change once
# it has been created.
#
# The Ruby Array is much more like the Java ArrayList. The size of an ArrayList
# is malleable just like a Ruby Array; items can be added and removed at any
# time.
#
# The FixedArray class represents the raw array you would find in languages like
# Java. It is implemented in fixed_array.rb. These tests are to help familiarize
# you with the concept. Take a look at how it is implemented once you have
# finished this serving of the Kamayan. You will be using it in further servings
# to implement other familiar data sets.
class Serving01FixedArrays < Attestify::Test
  def test_a_fixed_array_has_a_size_specified_when_it_is_created
    assert_equal __, FixedArray.new(0).size
    assert_equal __, FixedArray.new(1).size
    assert_equal __, FixedArray.new(42).size
  end

  def test_values_can_be_set_and_retrieved
    array = FixedArray.new(3)

    array[0] = 1
    array[1] = 2
    array[2] = 42

    assert_equal __, array[0]
    assert_equal __, array[1]
    assert_equal __, array[2]
  end

  def test_initial_values_are_nil
    array = FixedArray.new(3)
    assert_equal __, array[0]
    assert_equal __, array[1]
    assert_equal __, array[2]
  end

  def test_getting_and_setting_at_an_index_must_be_within_the_bounds_of_the_initial_size
    array = FixedArray.new(5)
    assert_raises(___) { array[-1] }
    assert_raises(___) { array[5] }
    assert_raises(___) { array[-1] = 1 }
    assert_raises(___) { array[5] = 42 }
  end
end
