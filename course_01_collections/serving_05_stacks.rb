require_relative "../kamayan"

# Diagram of a stack:
#
#  New elements are added here
#    |
#    +-->
#         +---+
#         | z | <--- Elements are removed from here
#         +---+
#         | y |
#         +---+
#         | x |
#         +---+
#
#
# Diagram of a stack as you run operations on it:
#
#   Empty    push(a)  push(b)  push(c)
#   Stack
#                              +---+
#                              | c |
#                     +---+    +---+
#                     | b |    | b |
#            +---+    +---+    +---+
#            | a |    | a |    | a |
#   +===+    +---+    +---+    +---+
#
#
#   peek()   pop()    peek()   pop()    pop()
#   => c     => c     => b     => b     => a
#
#   +---+
#   | c |
#   +---+    +---+    +---+
#   | b |    | b |    | b |
#   +---+    +---+    +---+    +---+
#   | a |    | a |    | a |    | a |
#   +---+    +---+    +---+    +---+    +===+
#
class Serving05Stacks < Attestify::Test
  def test_internal_collection_implements_each
    # The each method will be used for other tests, so if you decided not to use
    # the DoublyLinkedList, you will need to implement `each` for your chosen
    # collection.
    assert_method_exists Stack.new.instance_variable_get(:@list).class, :each, 0
  end

  def test_push_exists
    assert_method_exists Stack, :push, 1
  end

  def test_push_adds_elements
    stack = Stack.new
    stack.push(42)
    assert_equal 1, stack.size

    stack.push(43)
    stack.push(1)
    stack.push(2)
    assert_equal 4, stack.size
  end

  def test_push_adds_to_the_top_of_the_stack
    stack = Stack.new
    stack.push(42)
    actual_elements = []
    stack.instance_variable_get(:@list).each { |element| actual_elements << element }
    assert_equal [42], actual_elements

    stack.push(43)
    stack.push(1)
    stack.push(2)
    actual_elements = []
    stack.instance_variable_get(:@list).each { |element| actual_elements << element }
    assert_equal [42, 43, 1, 2], actual_elements
  end

  def test_push_returns_self_so_it_can_be_chained
    stack = Stack.new
    assert_equal stack, stack.push(42)
    assert_equal stack, stack.push(43)
  end

  def test_push_with_no_max_size_shouldnt_overflow
    stack = Stack.new
    1000.times { stack.push(42) }
    assert_equal 1000, stack.size
  end

  def test_push_beyond_max_size_throws_stack_overflow_error
    stack = Stack.new(5)
    stack.push(42).push(43).push(1).push(2).push(3)
    assert_raises(StackOverflowError) { stack.push(4) }
    assert_raises(StackOverflowError) { stack.push(5) }
  end

  def test_push_beyond_max_size_doesnt_add_to_size_or_elements
    stack = Stack.new(5)
    stack.push(42).push(43).push(1).push(2).push(3)
    assert_raises(StackOverflowError) { stack.push(4) }
    assert_raises(StackOverflowError) { stack.push(5) }
    assert_equal 5, stack.size
    actual_elements = []
    stack.instance_variable_get(:@list).each { |element| actual_elements << element }
    assert_equal [42, 43, 1, 2, 3], actual_elements
  end

  def test_pop_exists
    assert_method_exists Stack, :pop, 0
  end

  def test_pop_raises_an_error_if_the_stack_is_empty
    stack = Stack.new
    assert_raises(IndexError) { stack.pop }
  end

  def test_pop_returns_the_last_element_of_the_stack
    stack = Stack.new.push(42)
    assert_equal 42, stack.pop
    stack.push(43)
    assert_equal 43, stack.pop
  end

  def test_pop_alters_the_size_of_the_stack
    stack = Stack.new.push(42).push(43)
    assert_equal 2, stack.size
    stack.pop
    assert_equal 1, stack.size
    stack.pop
    assert_equal 0, stack.size
  end

  def test_pop_raises_an_error_if_the_stack_is_empty_after_being_emptied
    stack = Stack.new.push(42)
    stack.pop
    assert_raises(IndexError) { stack.pop }
  end

  def test_pop_returns_the_last_element_added
    stack = Stack.new.push(42).push(43).push(1).push(2)
    assert_equal 2, stack.pop
    assert_equal 1, stack.pop
    assert_equal 43, stack.pop
    assert_equal 42, stack.pop
  end

  def test_empty_exists
    assert_method_exists Stack, :empty?, 0
  end

  def test_empty_returns_true_for_new_stacks
    stack = Stack.new
    assert stack.empty?
    stack.push(42)
    stack.pop
    assert stack.empty?
  end

  def test_empty_returns_true_for_stacks_that_have_been_emptied
    stack = Stack.new.push(42)
    stack.pop
    assert stack.empty?
  end

  def test_empty_returns_false_for_non_empty_stacks
    stack = Stack.new.push(42)
    refute stack.empty?
    stack.push(43)
    refute stack.empty?
  end

  def test_empty_returns_false_for_stacks_that_have_been_emptied_and_grown_again
    stack = Stack.new.push(42).push(43)
    stack.pop
    stack.pop
    stack.push(1)
    refute stack.empty?
  end

  def test_peek_exists
    assert_method_exists Stack, :peek, 0
  end

  def test_peek_raises_an_error_if_the_stack_is_empty
    stack = Stack.new
    assert_raises(IndexError) { stack.peek }
    stack.push(42)
    stack.pop
    assert_raises(IndexError) { stack.peek }
  end

  def test_peek_returns_the_top_value_of_the_stack
    stack = Stack.new.push(42)
    assert_equal 42, stack.peek
    stack.push(43)
    assert_equal 43, stack.peek
  end

  def test_peek_can_be_called_multiple_times_without_affecting_the_size
    stack = Stack.new.push(42)
    assert_equal 42, stack.peek
    assert_equal 42, stack.peek
    assert_equal 42, stack.peek
    assert_equal 1, stack.size
    stack.push(43)
    assert_equal 43, stack.peek
    assert_equal 43, stack.peek
    assert_equal 43, stack.peek
    assert_equal 2, stack.size
  end
end
