require_relative "../kamayan"

# For this serving, you will be implementing your own version of the Array
# class. You can find a stub of the class in array_list.rb, while the tests here
# will help ensure you have implemented the core features.
#
# You may only use the FixedArray class for storing the contents of the
# ArrayList. Do not be afraid to add new methods as you see fit, but keep any
# new methods private.
#
# Further instructions can be found inside the ArrayList class.
#
# Diagram of an array list as it grows:
#
#   @size = 3
#
#   +---+---+---+---+---+---+---+---+---+---+
#   | a | b | c |   |   |   |   |   |   |   |
#   +---+---+---+---+---+---+---+---+---+---+
#
#
#   @size = 9
#
#   +---+---+---+---+---+---+---+---+---+---+
#   | a | b | c | d | e | f | g | h | i |   |
#   +---+---+---+---+---+---+---+---+---+---+
#
#
#   @size = 12
#
#   +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
#   | a | b | c | d | e | f | g | h | i | j | k | l |   |   |   |   |   |   |   |   |
#   +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
#
class Serving02ArrayLists < Attestify::Test
  def test_shovel_exists
    assert_method_exists ArrayList, :<<, 1
  end

  def test_shovel_increases_the_size
    array_list = ArrayList.new
    array_list << 42
    assert_equal 1, array_list.size
    array_list << 43
    assert_equal 2, array_list.size
  end

  def test_shovel_adds_to_the_end
    array_list = ArrayList.new
    array_list << 42
    array_list << 43
    assert_equal 42, array_list[0]
    assert_equal 43, array_list[1]
  end

  def test_shovel_returns_self_so_that_it_is_chainable
    array_list = ArrayList.new
    array_list << 42 << 43
    assert_equal 42, array_list[0]
    assert_equal 43, array_list[1]
  end

  def test_reverse_shovel_exists
    assert_method_exists ArrayList, :>>, 1
  end

  def test_reverse_shovel_increases_the_size
    array_list = ArrayList.new
    array_list >> 42
    assert_equal 1, array_list.size
    array_list >> 43
    assert_equal 2, array_list.size
  end

  def test_reverse_shovel_adds_to_the_beginning
    array_list = ArrayList.new
    array_list >> 42
    array_list >> 43
    assert_equal 43, array_list[0]
    assert_equal 42, array_list[1]
  end

  def test_reverse_shovel_returns_self_so_that_it_is_chainable
    array_list = ArrayList.new
    array_list >> 42 >> 43
    assert_equal 43, array_list[0]
    assert_equal 42, array_list[1]
  end

  def test_shovel_and_reverse_shovel_are_chainable_together
    array_list = ArrayList.new
    array_list << 42 << 43 >> 2 >> 1
    assert_equal 1, array_list[0]
    assert_equal 2, array_list[1]
    assert_equal 42, array_list[2]
    assert_equal 43, array_list[3]
  end

  def test_chained_shovel_and_reverse_shovel_increases_the_size
    array_list = ArrayList.new
    array_list << 42 << 43 >> 2 >> 1
    assert_equal 4, array_list.size
  end

  def test_shovel_can_be_called_a_lot
    array_list = ArrayList.new
    100.times { array_list << 42 }
    assert_equal 100, array_list.size
    assert (0..99).all? { |i| array_list[i] == 42 }
  end

  def test_reverse_shovel_can_be_called_a_lot
    array_list = ArrayList.new
    100.times { array_list >> 42 }
    assert_equal 100, array_list.size
    assert (0..99).all? { |i| array_list[i] == 42 }
  end

  def test_index_get_cannot_go_outside_the_bounds_of_the_array
    array_list = ArrayList.new
    assert_raises(IndexError) { array_list[-1] }
    assert_raises(IndexError) { array_list[-42] }
    assert_raises(IndexError) { array_list[0] }
    assert_raises(IndexError) { array_list[1] }
    array_list << 1
    array_list[0] # No error now that the index is valid
    assert_raises(IndexError) { array_list[1] }
  end

  def test_index_get_can_retrieve_any_element
    array_list = ArrayList.new << 1 << 2 << 42 << 43
    assert_equal 1, array_list[0]
    assert_equal 2, array_list[1]
    assert_equal 42, array_list[2]
    assert_equal 43, array_list[3]
  end

  def test_index_set_exists
    assert_method_exists ArrayList, :[]=, 2
  end

  def test_index_set_cannot_use_negative_number
    array_list = ArrayList.new
    assert_raises(IndexError) { array_list[-1] = 1 }
    assert_raises(IndexError) { array_list[-42] = 1 }
    assert_equal 0, array_list.size
  end

  def test_index_set_can_use_existing_indexes
    array_list = ArrayList.new << 0 << 1 << 2 << 3
    array_list[0] = 1
    array_list[1] = 2
    array_list[2] = 3
    array_list[3] = 4
    assert (0..3).all? { |i| i + 1 == array_list[i] }
  end

  def test_index_set_can_add_elements_to_the_end_of_the_list
    array_list = ArrayList.new
    array_list[0] = 1
    array_list[1] = 2
    array_list[2] = 3
    array_list[3] = 4
    assert (0..3).all? { |i| i + 1 == array_list[i] }
  end

  def test_index_set_can_use_distant_indexes
    array_list = ArrayList.new
    array_list[42] = 1
    array_list[142] = 2
    array_list[1042] = 3
    assert (0..41).all? { |i| array_list[i].nil? }
    assert (43..141).all? { |i| array_list[i].nil? }
    assert (143..1041).all? { |i| array_list[i].nil? }
    assert_equal 1, array_list[42]
    assert_equal 2, array_list[142]
    assert_equal 3, array_list[1042]
  end

  def test_index_set_with_the_next_available_index_updates_the_size
    array_list = ArrayList.new
    array_list[0] = 1
    assert_equal 1, array_list.size
    array_list[1] = 2
    assert_equal 2, array_list.size
    array_list[2] = 3
    assert_equal 3, array_list.size
    array_list[3] = 4
    assert_equal 4, array_list.size
  end

  def test_index_set_with_existing_indexes_doesnt_update_the_size
    array_list = ArrayList.new << 0 << 1 << 2 << 3
    array_list[0] = 1
    assert_equal 4, array_list.size
    array_list[1] = 2
    assert_equal 4, array_list.size
    array_list[2] = 3
    assert_equal 4, array_list.size
    array_list[3] = 4
    assert_equal 4, array_list.size
  end

  def test_index_set_with_distant_indexes_updates_the_size
    array_list = ArrayList.new
    array_list[42] = 1
    assert_equal 43, array_list.size
    array_list[142] = 2
    assert_equal 143, array_list.size
    array_list[1042] = 3
    assert_equal 1043, array_list.size
  end

  def test_delete_exists
    assert_method_exists ArrayList, :delete, 1
  end

  def test_delete_cannot_delete_outside_the_bounds_of_the_array_list
    array_list = ArrayList.new << 1 << 2 << 3
    assert_raises(IndexError) { array_list.delete(-1) }
    assert_raises(IndexError) { array_list.delete(-42) }
    assert_raises(IndexError) { array_list.delete(3) }
    assert_raises(IndexError) { array_list.delete(42) }
  end

  def test_delete_removes_the_element
    array_list = ArrayList.new << 1 << 2 << 3
    array_list.delete(1)
    assert_equal 1, array_list[0]
    assert_equal 3, array_list[1]
  end

  def test_delete_updates_the_size
    array_list = ArrayList.new << 1 << 2 << 3
    array_list.delete(1)
    assert_equal 2, array_list.size
    array_list.delete(0)
    assert_equal 1, array_list.size
    array_list.delete(0)
    assert_equal 0, array_list.size
  end

  def test_delete_returns_the_element_at_the_index
    array_list = ArrayList.new << 1 << 2 << 3
    assert_equal 1, array_list.delete(0)
    assert_equal 3, array_list.delete(1)
    assert_equal 2, array_list.delete(0)
  end

  def test_delete_can_be_called_a_lot
    array_list = ArrayList.new
    100.times { array_list << 42 }
    100.times { array_list.delete(0) }
    assert_equal 0, array_list.size
  end

  def test_delete_can_delete_from_a_full_array
    array_list = ArrayList.new
    internal_array = array_list.instance_variable_get(:@array)
    array_list.instance_variable_set(:@size, internal_array.size)

    0.upto(internal_array.size - 1) do |i|
      internal_array[i] = 42
    end

    assert_equal 42, array_list.delete(5)
    assert_equal 9, array_list.size
  end

  def test_delete_doesnt_leave_deleted_elements_in_the_array
    array_list = ArrayList.new
    internal_array = array_list.instance_variable_get(:@array)
    array_list.instance_variable_set(:@size, internal_array.size)

    0.upto(internal_array.size - 1) do |i|
      internal_array[i] = 42
    end

    assert_equal 42, array_list.delete(5)
    assert_equal 9, array_list.size
    assert_nil array_list.instance_variable_get(:@array)[9]
  end
end
