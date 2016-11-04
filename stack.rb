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

  # push

  # pop

  # empty?

  # peek
end
