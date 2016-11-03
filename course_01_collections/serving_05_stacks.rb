require_relative "../kamayan"

# Diagram of a stack as you run operations on it:
#
#   Empty    push(a)  push(b)  push(c)
#   Stack
#                              +---+
#                              | c |
#                     +---+    +---+
#                     | b |    | b |
#            +---+    +---+    +---+
#            | a |    | a |    | a |
#   +===+    +---+    +---+    +---+
#
#
#   peek()   pop()    peek()   pop()    pop()
#   => c     => c     => b     => b     => a
#
#   +---+
#   | c |
#   +---+    +---+    +---+
#   | b |    | b |    | b |
#   +---+    +---+    +---+    +---+
#   | a |    | a |    | a |    | a |
#   +---+    +---+    +---+    +---+    +===+
#
class Serving05Stacks < Attestify::Test
end
