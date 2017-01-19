require_relative "../kamayan"

# Diagram of a queue:
#
#     New elements are added here
#                |
#                v
#  +---+---+---+
#  | x | y | z |
#  +---+---+---+
#    ^
#    |
#  Elements are removed from here
#
#
# Diagram of a queue as you run operations on it:
#
#                 +
#   Empty queue:  |
#                 +
#
#                 +---+
#   enqueue(a):   | a |
#                 +---+
#
#                 +---+---+
#   enqueue(b):   | a | b |
#                 +---+---+
#
#                 +---+---+---+
#   enqueue(c):   | a | b | c |
#                 +---+---+---+
#
#   peek()
#   => a
#
#                 +---+---+
#   dequeue():    | b | c |
#   => a          +---+---+
#
#   peek()
#   => b
#
#                 +---+
#   dequeue():    | c |
#   => b          +---+
#
#   peek()
#   => c
#
#                 +
#   dequeue():    |
#   => c          +
#
class Serving06Queues < Attestify::Test
  def test_internal_collection_implements_each
    # The each method will be used for other tests, so if you decided not to use
    # the DoublyLinkedList, you will need to implement `each` for your chosen
    # collection.
    assert_method_exists Queue.new.instance_variable_get(:@list).class, :each, 0
  end

  def test_enqueue_exists
    assert_method_exists Queue, :enqueue, 1
  end

  def test_enqueue_adds_elements
    queue = Queue.new
    queue.enqueue(42)
    assert_equal 1, queue.size

    queue.enqueue(43)
    queue.enqueue(1)
    queue.enqueue(2)
    assert_equal 4, queue.size
  end

  def test_enqueue_adds_to_the_end_of_the_queue
    queue = Queue.new
    queue.enqueue(42)
    actual_elements = []
    queue.instance_variable_get(:@list).each { |element| actual_elements << element }
    assert_equal [42], actual_elements

    queue.enqueue(43)
    queue.enqueue(1)
    queue.enqueue(2)
    actual_elements = []
    queue.instance_variable_get(:@list).each { |element| actual_elements << element }
    assert_equal [42, 43, 1, 2], actual_elements
  end

  def test_enqueue_returns_self_so_it_can_be_chained
    queue = Queue.new
    assert_equal queue, queue.enqueue(42)
    assert_equal queue, queue.enqueue(43)
  end

  def test_enqueue_can_be_called_a_lot
    queue = Queue.new
    1000.times { queue.enqueue(42) }
    assert_equal 1000, queue.size
  end

  def test_dequeue_exists
    assert_method_exists Queue, :dequeue, 0
  end

  def test_dequeue_raises_an_error_if_the_queue_is_empty
    queue = Queue.new
    assert_raises(IndexError) { queue.dequeue }
  end

  def test_dequeue_returns_the_first_element_of_the_queue
    queue = Queue.new.enqueue(42)
    assert_equal 42, queue.dequeue
    queue.enqueue(43)
    assert_equal 43, queue.dequeue
  end

  def test_dequeue_alters_the_size_of_the_queue
    queue = Queue.new.enqueue(42).enqueue(43)
    assert_equal 2, queue.size
    queue.dequeue
    assert_equal 1, queue.size
    queue.dequeue
    assert_equal 0, queue.size
  end

  def test_dequeue_raises_an_error_if_the_queue_is_empty_after_being_emptied
    queue = Queue.new.enqueue(42)
    queue.dequeue
    assert_raises(IndexError) { queue.dequeue }
  end

  def test_dequeue_returns_the_first_element_added
    queue = Queue.new.enqueue(42).enqueue(43).enqueue(1).enqueue(2)
    assert_equal 42, queue.dequeue
    assert_equal 43, queue.dequeue
    assert_equal 1, queue.dequeue
    assert_equal 2, queue.dequeue
  end

  def test_empty_exists
    assert_method_exists Queue, :empty?, 0
  end

  def test_empty_returns_true_for_new_queues
    queue = Queue.new
    assert queue.empty?
    queue.enqueue(42)
    queue.dequeue
    assert queue.empty?
  end

  def test_empty_returns_true_for_queues_that_have_been_emptied
    queue = Queue.new.enqueue(42)
    queue.dequeue
    assert queue.empty?
  end

  def test_empty_returns_false_for_non_empty_queues
    queue = Queue.new.enqueue(42)
    refute queue.empty?
    queue.enqueue(43)
    refute queue.empty?
  end

  def test_empty_returns_false_for_queues_that_have_been_emptied_and_grown_again
    queue = Queue.new.enqueue(42).enqueue(43)
    queue.dequeue
    queue.dequeue
    queue.enqueue(1)
    refute queue.empty?
  end

  def test_peek_exists
    assert_method_exists Queue, :peek, 0
  end

  def test_peek_raises_an_error_if_the_queue_is_empty
    queue = Queue.new
    assert_raises(IndexError) { queue.peek }
    queue.enqueue(42)
    queue.dequeue
    assert_raises(IndexError) { queue.peek }
  end

  def test_peek_returns_the_first_value_of_the_queue
    queue = Queue.new.enqueue(42)
    assert_equal 42, queue.peek
    queue.enqueue(43)
    assert_equal 42, queue.peek
  end

  def test_peek_can_by_called_multiple_times_without_affecting_the_size
    queue = Queue.new.enqueue(42)
    assert_equal 42, queue.peek
    assert_equal 42, queue.peek
    assert_equal 42, queue.peek
    assert_equal 1, queue.size
    queue.enqueue(43)
    assert_equal 42, queue.peek
    assert_equal 42, queue.peek
    assert_equal 42, queue.peek
    assert_equal 2, queue.size
  end
end
