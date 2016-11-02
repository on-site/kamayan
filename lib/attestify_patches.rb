SHOW_ALL_ERRORS = ARGV.delete("--all-failures")

# Customize the Attestify reporter such that it only outputs the first failure
class Attestify::Reporter
  private

  alias_method :__puts_failures, :puts_failures
  alias_method :__puts_failure_reruns, :puts_failure_reruns

  def puts_failures
    return __puts_failures if SHOW_ALL_ERRORS
    puts
    puts_failure(@failures.first, 1) if @failures.first
  end

  def puts_failure_reruns
    return __puts_failure_reruns if SHOW_ALL_ERRORS
    puts
    puts "Failed tests:"
    puts
    puts_failure_rerun(@failures.first) if @failures.first
    puts_additional_failures_notification
  end

  def puts_additional_failures_notification
    return unless @failures.size > 1
    puts
    puts "#{@failures.size - 1} additional tests failed or threw an exception!\n" \
         "Run again with '-- --all-failures' added to the end to see all failures."
  end
end

class Attestify::ColorReporter
  private

  def puts_additional_failures_notification
    return unless @failures.size > 1
    print color_code(:bold_red)
    super
    print color_code(:reset)
  end
end
