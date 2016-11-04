class DoublyLinkedList
  attr_reader :size

  def initialize
    @head = nil
    @tail = nil
    @size = 0
  end

  # Use this nested class for storing the values of the DoublyLinkedList. Each
  # DoublyLinkedList::Node contains the value at its index, and a link to the
  # DoublyLinkedList::Node at the next index (called the "child" here), and at
  # the previous index (called "previous"). If the child is nil, that denotes
  # the last element of the DoublyLinkedList, while a nil previous denotes the
  # first.
  class Node
    attr_accessor :value, :previous, :child

    def initialize(value, previous = nil, child = nil)
      @value = value
      @previous = previous
      @child = child
    end
  end

  # Define a method ">>" which takes a single argument. This method should
  # prepend the argument to the beginning of this DoublyLinkedList and increase
  # the size by 1. The return value must be self.

  # Define a method "<<" which takes a single argument. This method should
  # append the argument to the end of this DoublyLinkedList and increase the
  # size by 1. The return value must be self.

  # Define a "first" method which takes no arguments. This method should return
  # the value of that item. An IndexError should be raised if the list is empty.

  # Define a "last" method which takes no arguments. This method should return
  # the value of that item. An IndexError should be raised if the list is empty.

  # Define a "delete_first" method which takes no arguments. This method should
  # delete the first item in the list and return the value of that item. The
  # size must be reduced by 1. An IndexError should be raised if the list is
  # empty.

  # Define a "delete_last" method which takes no arguments. This method should
  # delete the last item in the list and return the value of that item. The size
  # must be reduced by 1. An IndexError should be raised if the list is empty.

  # Define an "each" method which takes no arguments but accepts a block. The
  # block is yielded to with each element in the list, in order. The return
  # value must be self.

  # Define an "each_reversed" method which takes no arguments but accepts a
  # block. The block is yielded to with each element in the list, in reverse
  # order. The return value must be self.

  private

  def check_bounds(index)
    check_lower_bound(index)
    check_upper_bound(index)
  end

  def check_lower_bound(index)
    raise IndexError, "Invalid index: #{index}" if index < 0
  end

  def check_upper_bound(index)
    raise IndexError, "Invalid index: #{index}" if index >= size
  end
end
