# NOTE: This collection is called Kamayan::Queue because a Queue already exists:
# http://ruby-doc.org/core/Queue.html
class Kamayan::Queue
  def initialize
    # You may use any of the collections you've built so far, though you will
    # need to implement `each` for that collection if you use something other
    # than DoublyLinkedList.
    @list = DoublyLinkedList.new
  end

  def size
    @list.size
  end

  # Define a method "enqueue" which takes a single argument. This method should
  # add the argument to the end of the queue, which should increase the size by
  # 1. The return value must be self.

  # Define a method "dequeue" which takes no arguments. This method should
  # remove and return the first value in the queue. An IndexError should be
  # raised if the Queue is empty.

  # Define a method "empty?" which takes no arguments. This method should return
  # whether or not the size is 0.

  # Define a method "peek" which takes no arguments. This method should return
  # the first value in the queue, without removing any elements in the queue.
end
