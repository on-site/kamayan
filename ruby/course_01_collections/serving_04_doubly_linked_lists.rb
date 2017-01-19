require_relative "../kamayan"

# This serving will build on what you made in the last serving. A doubly linked
# list is the same as a linked list, except each node points to both the
# previous and the next node in the list. This collection is ideal for when you
# only want to interact with the first or last item of a collection.
#
# Feel free to copy any code you wrote for the LinkedList into the
# DoublyLinkedList, though you might need to add to the behavior. You will find
# the stub class in doubly_linked_list.rb along with further instructions.
#
# Diagram of a doubly linked list:
#
#            @size = 3
#
#            @head                         @tail
#              |                             |
#              v                             v
#            +---+ -- child --> +---+ ---> +---+ ---> nil
#            | a |              | b |      | c |
#   nil <--- +---+ <-- prev --- +---+ <--- +---+
#
class Serving04DoublyLinkedLists < Attestify::Test
  def test_reverse_shovel_exists
    assert_method_exists DoublyLinkedList, :>>, 1
  end

  def test_reverse_shovel_adds_to_the_beginning
    linked_list = DoublyLinkedList.new
    linked_list >> 42
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    linked_list >> 43
    assert_equal 43, linked_list.instance_variable_get(:@head).value
    assert_equal 42, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_reverse_shovel_updates_previous_links
    linked_list = DoublyLinkedList.new
    linked_list >> 42
    linked_list >> 43
    assert_equal 42, linked_list.instance_variable_get(:@tail).value
    assert_equal 43, linked_list.instance_variable_get(:@tail).previous.value
    assert_nil linked_list.instance_variable_get(:@tail).previous.previous
  end

  def test_reverse_shovel_increases_the_size
    linked_list = DoublyLinkedList.new
    linked_list >> 42
    assert_equal 1, linked_list.size
    linked_list >> 43
    assert_equal 2, linked_list.size
  end

  def test_reverse_shovel_returns_self_so_that_it_is_chainable
    linked_list = DoublyLinkedList.new
    linked_list >> 42 >> 43
    assert_equal 43, linked_list.instance_variable_get(:@head).value
    assert_equal 42, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_reverse_shovel_can_be_called_a_lot
    linked_list = DoublyLinkedList.new
    100.times { linked_list >> 42 }
    assert_equal 100, linked_list.size

    node = linked_list.instance_variable_get(:@head)
    100.times do
      assert_equal 42, node.value
      node = node.child
    end
  end

  def test_shovel_exists
    assert_method_exists DoublyLinkedList, :<<, 1
  end

  def test_shovel_adds_to_the_end
    linked_list = DoublyLinkedList.new
    linked_list << 42
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    linked_list << 43
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    assert_equal 43, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_shovel_updates_previous_links
    linked_list = DoublyLinkedList.new
    linked_list << 42
    linked_list << 43
    assert_equal 43, linked_list.instance_variable_get(:@tail).value
    assert_equal 42, linked_list.instance_variable_get(:@tail).previous.value
    assert_nil linked_list.instance_variable_get(:@tail).previous.previous
  end

  def test_shovel_increases_the_size
    linked_list = DoublyLinkedList.new
    linked_list << 42
    assert_equal 1, linked_list.size
    linked_list << 43
    assert_equal 2, linked_list.size
  end

  def test_shovel_returns_self_so_that_it_is_chainable
    linked_list = DoublyLinkedList.new
    linked_list << 42 << 43
    assert_equal 42, linked_list.instance_variable_get(:@head).value
    assert_equal 43, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child
  end

  def test_shovel_can_be_called_a_lot
    linked_list = DoublyLinkedList.new
    100.times { linked_list << 42 }
    assert_equal 100, linked_list.size

    node = linked_list.instance_variable_get(:@head)
    100.times do
      assert_equal 42, node.value
      node = node.child
    end
  end

  def test_shovel_and_reverse_shovel_are_chainable_together
    linked_list = DoublyLinkedList.new
    linked_list << 42 << 43 >> 2 >> 1
    assert_equal 1, linked_list.instance_variable_get(:@head).value
    assert_equal 2, linked_list.instance_variable_get(:@head).child.value
    assert_equal 42, linked_list.instance_variable_get(:@head).child.child.value
    assert_equal 43, linked_list.instance_variable_get(:@head).child.child.child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child.child.child
  end

  def test_chained_shovel_and_reverse_shovel_increases_the_size
    linked_list = DoublyLinkedList.new
    linked_list << 42 << 43 >> 2 >> 1
    assert_equal 4, linked_list.size
  end

  def test_first_exists
    assert_method_exists DoublyLinkedList, :first, 0
  end

  def test_first_cannot_be_called_on_empty_list
    linked_list = DoublyLinkedList.new
    assert_raises(IndexError) { linked_list.first }
  end

  def test_first_returns_the_first_element
    linked_list = DoublyLinkedList.new << 1
    assert_equal 1, linked_list.first
    linked_list >> 2
    assert_equal 2, linked_list.first
    linked_list >> 42
    assert_equal 42, linked_list.first
    linked_list >> 43
    assert_equal 43, linked_list.first
  end

  def test_last_exists
    assert_method_exists DoublyLinkedList, :last, 0
  end

  def test_last_cannot_be_called_on_empty_list
    linked_list = DoublyLinkedList.new
    assert_raises(IndexError) { linked_list.last }
  end

  def test_last_returns_the_last_element
    linked_list = DoublyLinkedList.new << 1
    assert_equal 1, linked_list.last
    linked_list << 2
    assert_equal 2, linked_list.last
    linked_list << 42
    assert_equal 42, linked_list.last
    linked_list << 43
    assert_equal 43, linked_list.last
  end

  def test_delete_first_exists
    assert_method_exists DoublyLinkedList, :delete_first, 0
  end

  def test_delete_first_cannot_delete_from_an_empty_list
    linked_list = DoublyLinkedList.new
    assert_raises(IndexError) { linked_list.delete_first }
  end

  def test_delete_first_removes_the_first_element
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_first
    assert_equal 2, linked_list.first
    linked_list.delete_first
    assert_equal 3, linked_list.first
  end

  def test_delete_first_returns_the_deleted_element
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    assert_equal 1, linked_list.delete_first
    assert_equal 2, linked_list.delete_first
    assert_equal 3, linked_list.delete_first
  end

  def test_delete_first_updates_the_size
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_first
    assert_equal 2, linked_list.size
    linked_list.delete_first
    assert_equal 1, linked_list.size
    linked_list.delete_first
    assert_equal 0, linked_list.size
  end

  def test_delete_first_can_be_called_a_lot
    linked_list = DoublyLinkedList.new
    100.times { linked_list << 42 }
    100.times { linked_list.delete_first }
    assert_equal 0, linked_list.size
  end

  def test_delete_first_updates_child_links
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_first
    assert_equal 2, linked_list.instance_variable_get(:@head).value
    assert_equal 3, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child

    linked_list.delete_first
    assert_equal 3, linked_list.instance_variable_get(:@head).value
    assert_nil linked_list.instance_variable_get(:@head).child

    linked_list.delete_first
    assert_nil linked_list.instance_variable_get(:@head)
  end

  def test_delete_first_updates_previous_links
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_first
    assert_equal 3, linked_list.instance_variable_get(:@tail).value
    assert_equal 2, linked_list.instance_variable_get(:@tail).previous.value
    assert_nil linked_list.instance_variable_get(:@tail).previous.previous

    linked_list.delete_first
    assert_equal 3, linked_list.instance_variable_get(:@tail).value
    assert_nil linked_list.instance_variable_get(:@tail).previous

    linked_list.delete_first
    assert_nil linked_list.instance_variable_get(:@tail)
  end

  def test_delete_last_exists
    assert_method_exists DoublyLinkedList, :delete_last, 0
  end

  def test_delete_last_cannot_delete_from_an_empty_list
    linked_list = DoublyLinkedList.new
    assert_raises(IndexError) { linked_list.delete_last }
  end

  def test_delete_last_removes_the_last_element
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_last
    assert_equal 2, linked_list.last
    linked_list.delete_last
    assert_equal 1, linked_list.last
  end

  def test_delete_last_returns_the_deleted_element
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    assert_equal 3, linked_list.delete_last
    assert_equal 2, linked_list.delete_last
    assert_equal 1, linked_list.delete_last
  end

  def test_delete_last_updates_the_size
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_last
    assert_equal 2, linked_list.size
    linked_list.delete_last
    assert_equal 1, linked_list.size
    linked_list.delete_last
    assert_equal 0, linked_list.size
  end

  def test_delete_last_can_be_called_a_lot
    linked_list = DoublyLinkedList.new
    100.times { linked_list << 42 }
    100.times { linked_list.delete_last }
    assert_equal 0, linked_list.size
  end

  def test_delete_last_updates_child_links
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_last
    assert_equal 1, linked_list.instance_variable_get(:@head).value
    assert_equal 2, linked_list.instance_variable_get(:@head).child.value
    assert_nil linked_list.instance_variable_get(:@head).child.child

    linked_list.delete_last
    assert_equal 1, linked_list.instance_variable_get(:@head).value
    assert_nil linked_list.instance_variable_get(:@head).child

    linked_list.delete_last
    assert_nil linked_list.instance_variable_get(:@head)
  end

  def test_delete_last_updates_previous_links
    linked_list = DoublyLinkedList.new << 1 << 2 << 3
    linked_list.delete_last
    assert_equal 2, linked_list.instance_variable_get(:@tail).value
    assert_equal 1, linked_list.instance_variable_get(:@tail).previous.value
    assert_nil linked_list.instance_variable_get(:@tail).previous.previous

    linked_list.delete_last
    assert_equal 1, linked_list.instance_variable_get(:@tail).value
    assert_nil linked_list.instance_variable_get(:@tail).previous

    linked_list.delete_last
    assert_nil linked_list.instance_variable_get(:@tail)
  end

  def test_each_exists
    assert_method_exists DoublyLinkedList, :each, 0
  end

  def test_each_yields_to_nothing_when_the_list_is_empty
    DoublyLinkedList.new.each do |element|
      flunk "Expected no yield!"
    end
  end

  def test_each_yields_to_the_elements_in_order
    linked_list = DoublyLinkedList.new << 1 << 2 << 42 << 43
    actual_elements = []
    linked_list.each { |element| actual_elements << element }
    assert_equal [1, 2, 42, 43], actual_elements
  end

  def test_each_returns_self_so_it_can_be_chained
    linked_list = DoublyLinkedList.new
    assert_equal(linked_list, linked_list.each { |_| })

    linked_list << 1 << 2 << 42 << 43
    assert_equal(linked_list, linked_list.each { |_| })
  end

  def test_each_reversed_exists
    assert_method_exists DoublyLinkedList, :each_reversed, 0
  end

  def test_each_reversed_yields_to_nothing_when_the_list_is_empty
    DoublyLinkedList.new.each_reversed do |element|
      flunk "Expected no yield!"
    end
  end

  def test_each_reversed_yields_to_the_elements_in_reverse_order
    linked_list = DoublyLinkedList.new << 1 << 2 << 42 << 43
    actual_elements = []
    linked_list.each_reversed { |element| actual_elements << element }
    assert_equal [43, 42, 2, 1], actual_elements
  end

  def test_each_reversed_returns_self_so_it_can_be_chained
    linked_list = DoublyLinkedList.new
    assert_equal(linked_list, linked_list.each_reversed { |_| })

    linked_list << 1 << 2 << 42 << 43
    assert_equal(linked_list, linked_list.each_reversed { |_| })
  end
end
