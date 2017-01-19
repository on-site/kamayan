# Custom assertions to make the errors easier to understand
module Attestify::Assertions
  def assert_method_exists(clazz, name, arity)
    if clazz.method_defined?(name)
      actual_arity = clazz.instance_method(name).arity
      record_assert(actual_arity == arity) { "#{clazz} should implement '#{name}' with #{arity} argument(s), but it had #{actual_arity} instead" }
    else
      record_assert(false) { "#{clazz} should implement '#{name}', but it was missing" }
    end
  end
end
