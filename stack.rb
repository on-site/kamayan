class StackOverflowError < StandardError
end

class Stack
  def initialize(max_size = nil)
    @max_size = max_size
    # You may use any of the collections you've built so far, though you will
    # need to implement `each` for that collection if you use something other
    # than DoublyLinkedList.
    @list = DoublyLinkedList.new
  end

  def size
    @list.size
  end

  # Define a method "push" which takes a single argument. This method should add
  # the argument to the end of the stack, which should increase the size by
  # 1. The return value must be self. If the max_size was specified when
  # constructing the Stack (that is, it is not null), then a StackOverflowError
  # should be raised before adding the value if the stack is already at the
  # capacity.

  # Define a method "pop" which takes no arguments. This method should remove
  # and return the last value in the stack. An IndexError should be raised if
  # the Stack is empty.

  # Define a method "empty?" which takes no arguments. This method should return
  # whether or not the size is 0.

  # Define a method "peek" which takes no arguments. This method should return
  # the last value in the stack, without removing any elements in the stack.
end
