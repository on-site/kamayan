require "bundler/setup"
Bundler.require(:default)
require_relative "lib/attestify_assertions"
require_relative "lib/attestify_patches"
require_relative "lib/blanks"
Attestify.autorun

require_relative "array_list"
require_relative "doubly_linked_list"
require_relative "fixed_array"
require_relative "linked_list"
require_relative "queue"
require_relative "stack"
