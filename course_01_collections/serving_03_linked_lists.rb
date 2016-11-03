require_relative "../kamayan"

# This serving is similar to the last, except instead of implementing an Array
# class in terms of FixedArray, you will be implementing it in terms of a series
# of links that form what is called a Linked List. You can find a stub of the
# class in linked_list.rb, while the tests here will help ensure you have
# implemented the core features.
#
# You may only use the nested Node class for storing the contents of the
# LinkedList. Do not be afraid to add new methods as you see fit, but keep any
# new methods private.
#
# Further instructions can be found inside the LinkedList class.
#
# Once you have finished implementing the LinkedList, contemplate the
# differences between the ArrayList and the LinkedList, and when you might use
# one versus the other... the pros and cons of the two.
#
# Diagram of a linked list:
#
#   @size = 3
#
#   @head
#     |
#     v
#   +---+              +---+      +---+
#   | a | -- child --> | b | ---> | c | ---> nil
#   +---+              +---+      +---+
#
class Serving03LinkedLists < Attestify::Test
  def test_reverse_shovel_exists
    assert_method_exists LinkedList, :>>, 1
  end

  def test_reverse_shovel_adds_to_the_beginning
    linked_list = LinkedList.new
    linked_list >> 42
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    linked_list >> 43
    assert_equal 43, linked_list.instance_variable_get(:@head).value
    assert_equal 42, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_reverse_shovel_increases_the_size
    linked_list = LinkedList.new
    linked_list >> 42
    assert_equal 1, linked_list.size
    linked_list >> 43
    assert_equal 2, linked_list.size
  end

  def test_reverse_shovel_returns_self_so_that_it_is_chainable
    linked_list = LinkedList.new
    linked_list >> 42 >> 43
    assert_equal 43, linked_list.instance_variable_get(:@head).value
    assert_equal 42, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_reverse_shovel_can_be_called_a_lot
    linked_list = LinkedList.new
    100.times { linked_list >> 42 }
    assert_equal 100, linked_list.size

    node = linked_list.instance_variable_get(:@head)
    100.times do
      assert_equal 42, node.value
      node = node.child
    end
  end

  def test_shovel_exists
    assert_method_exists LinkedList, :<<, 1
  end

  def test_shovel_adds_to_the_end
    linked_list = LinkedList.new
    linked_list << 42
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    linked_list << 43
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    assert_equal 43, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_shovel_increases_the_size
    linked_list = LinkedList.new
    linked_list << 42
    assert_equal 1, linked_list.size
    linked_list << 43
    assert_equal 2, linked_list.size
  end

  def test_shovel_returns_self_so_that_it_is_chainable
    linked_list = LinkedList.new
    linked_list << 42 << 43
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    assert_equal 43, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_shovel_can_be_called_a_lot
    linked_list = LinkedList.new
    100.times { linked_list << 42 }
    assert_equal 100, linked_list.size

    node = linked_list.instance_variable_get(:@head)
    100.times do
      assert_equal 42, node.value
      node = node.child
    end
  end

  def test_shovel_and_reverse_shovel_are_chainable_together
    linked_list = LinkedList.new
    linked_list << 42 << 43 >> 2 >> 1
    assert_equal 1, linked_list.instance_variable_get(:@head).value
    assert_equal 2, linked_list.instance_variable_get(:@head).child.value
    assert_equal 42, linked_list.instance_variable_get(:@head).child.child.value
    assert_equal 43, linked_list.instance_variable_get(:@head).child.child.child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child.child.child
  end

  def test_chained_shovel_and_reverse_shovel_increases_the_size
    linked_list = LinkedList.new
    linked_list << 42 << 43 >> 2 >> 1
    assert_equal 4, linked_list.size
  end

  def test_index_get_exists
    assert_method_exists LinkedList, :[], 1
  end

  def test_index_get_cannot_go_outside_the_bounds_of_the_list
    linked_list = LinkedList.new
    assert_raises(IndexError) { linked_list[-1] }
    assert_raises(IndexError) { linked_list[-42] }
    assert_raises(IndexError) { linked_list[0] }
    assert_raises(IndexError) { linked_list[1] }
    linked_list << 1
    linked_list[0] # No error now that the index is valid
    assert_raises(IndexError) { linked_list[1] }
  end

  def test_index_get_can_retrieve_any_element
    linked_list = LinkedList.new << 1 << 2 << 42 << 43
    assert_equal 1, linked_list[0]
    assert_equal 2, linked_list[1]
    assert_equal 42, linked_list[2]
    assert_equal 43, linked_list[3]
  end

  def test_index_set_exists
    assert_method_exists LinkedList, :[]=, 2
  end

  def test_index_set_cannot_use_negative_number
    linked_list = LinkedList.new
    assert_raises(IndexError) { linked_list[-1] = 1 }
    assert_raises(IndexError) { linked_list[-42] = 1 }
    assert_equal 0, linked_list.size
  end

  def test_index_set_can_use_existing_indexes
    linked_list = LinkedList.new << 0 << 1 << 2 << 3
    linked_list[0] = 1
    linked_list[1] = 2
    linked_list[2] = 3
    linked_list[3] = 4
    assert (0..3).all? { |i| i + 1 == linked_list[i] }
  end

  def test_index_set_with_existing_indexes_doesnt_update_the_size
    linked_list = LinkedList.new << 0 << 1 << 2 << 3
    linked_list[0] = 1
    assert_equal 4, linked_list.size
    linked_list[1] = 2
    assert_equal 4, linked_list.size
    linked_list[2] = 3
    assert_equal 4, linked_list.size
    linked_list[3] = 4
    assert_equal 4, linked_list.size
  end

  def test_index_set_can_add_elements_to_the_end_of_the_list
    linked_list = LinkedList.new
    linked_list[0] = 1
    linked_list[1] = 2
    linked_list[2] = 3
    linked_list[3] = 4
    assert (0..3).all? { |i| i + 1 == linked_list[i] }
  end

  def test_index_set_updates_the_size_when_adding_to_the_end_of_the_list
    linked_list = LinkedList.new
    linked_list[0] = 1
    assert_equal 1, linked_list.size
    linked_list[1] = 2
    assert_equal 2, linked_list.size
    linked_list[2] = 3
    assert_equal 3, linked_list.size
    linked_list[3] = 4
    assert_equal 4, linked_list.size
  end

  def test_index_set_can_use_distant_indexes
    linked_list = LinkedList.new
    linked_list[42] = 1
    linked_list[142] = 2
    linked_list[1042] = 3
    assert (0..41).all? { |i| linked_list[i].nil? }
    assert (43..141).all? { |i| linked_list[i].nil? }
    assert (143..1041).all? { |i| linked_list[i].nil? }
    assert_equal 1, linked_list[42]
    assert_equal 2, linked_list[142]
    assert_equal 3, linked_list[1042]
  end

  def test_index_set_with_distant_indexes_updates_the_size
    linked_list = LinkedList.new
    linked_list[42] = 1
    assert_equal 43, linked_list.size
    linked_list[142] = 2
    assert_equal 143, linked_list.size
    linked_list[1042] = 3
    assert_equal 1043, linked_list.size
  end

  def test_delete_exists
    assert_method_exists LinkedList, :delete, 1
  end

  def test_delete_cannot_delete_outside_the_bounds_of_the_linked_list
    linked_list = LinkedList.new << 1 << 2 << 3
    assert_raises(IndexError) { linked_list.delete(-1) }
    assert_raises(IndexError) { linked_list.delete(-42) }
    assert_raises(IndexError) { linked_list.delete(3) }
    assert_raises(IndexError) { linked_list.delete(42) }
  end

  def test_delete_removes_the_element
    linked_list = LinkedList.new << 1 << 2 << 3
    linked_list.delete(1)
    assert_equal 1, linked_list[0]
    assert_equal 3, linked_list[1]
  end

  def test_delete_returns_the_element_at_the_index
    linked_list = LinkedList.new << 1 << 2 << 3
    assert_equal 1, linked_list.delete(0)
    assert_equal 3, linked_list.delete(1)
    assert_equal 2, linked_list.delete(0)
  end

  def test_delete_updates_the_size
    linked_list = LinkedList.new << 1 << 2 << 3
    linked_list.delete(1)
    assert_equal 2, linked_list.size
    linked_list.delete(0)
    assert_equal 1, linked_list.size
    linked_list.delete(0)
    assert_equal 0, linked_list.size
  end

  def test_delete_can_be_called_a_lot
    linked_list = LinkedList.new
    100.times { linked_list << 42 }
    100.times { linked_list.delete(0) }
    assert_equal 0, linked_list.size
  end
end
