class FixedArray
  def initialize(size)
    @array = Array.new(size)
  end

  def [](index)
    check_bounds(index)
    @array[index]
  end

  def []=(index, value)
    check_bounds(index)
    @array[index] = value
  end

  def size
    @array.size
  end

  private

  def check_bounds(index)
    raise IndexError, "Invalid index: #{index}" if index < 0 || index >= size
  end
end
