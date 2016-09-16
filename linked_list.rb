class LinkedList
  attr_reader :size

  def initialize
    @head = nil
    @size = 0
  end

  def [](index)
    check_bounds(index)
    raise FillMeInError
    # This method should retrieve the value at the given index.
  end

  def []=(index, value)
    check_lower_bound(index)
    raise FillMeInError
    # This method should set the value at the given index such that
    # linked_list[index] will return the value.
    #
    # If the value is bigger than the current size of the array, the links
    # should be adjusted to fit the new index, and all indexes between the
    # former last element and the new index should be initialized with nil.
    #
    # The size after this method is called depends on the index provided. An
    # existing index would not affect the size, but a value greater than the
    # last index will add the difference to the size.
  end

  def delete(index)
    check_bounds(index)
    raise FillMeInError
    # This method should delete the value at the provided index and return
    # it. The size should be 1 less than it was before this method was called.
  end

  def <<(value)
    raise FillMeInError
    # This method should append a value to the end of this LinkedList and
    # increase the size by 1. The return value must be self.
    self
  end

  def >>(value)
    raise FillMeInError
    # This method should prepend a value to the beginning of this LinkedList and
    # increase the size by 1. The return value must be self.
    self
  end

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

  class Node
    attr_accessor :value, :next_node

    def initialize(value, next_node = nil)
      @value = value
      @next_node = next_node
    end
  end
end
