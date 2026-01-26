# Clojure Lectures Summary

This document summarizes the key concepts and learnings from the Clojure lecture commits in this repository.

## Lecture 02 - Basic Types
- **Numbers**: Integers (`10`), Floats (`3.14`), BigInt (`10N`), BigDecimal (`100.5M`).
- **Strings & Characters**: Strings use double quotes (`"Hello"`), characters use backslash (`\A`).
- **Booleans & nil**: `true`, `false`, and `nil`.
- **Keywords**: prefixed with `:`, used as identifiers or map keys (`:hello-world`).
- **Symbols**: Used to refer to things (`'hello-world`).

## Lecture 03 - Collections & Syntax
- **Sequential Collections**: 
    - **Vectors `[]`**: Indexable, efficient append (at end).
    - **Lists `'()`**: Linked lists, efficient add to front.
- **Associative Collections**:
    - **Maps `{}`**: Key-value pairs.
    - **Sets `#{}`**: Unique elements, no guaranteed order.
- **REPL**: Read-Eval-Print-Loop cycle.
- **Syntax**: Prefix notation for function calls `(func arg1 arg2)`.
- **Quote `'`**: Prevents evaluation of a form.
- **Arity**: The number of arguments a function takes.
- **Basic `if`**: `(if condition then-clause else-clause)`.

## Lecture 05 - Functional Programming
- **Anonymous Functions**: Defined using `(fn [args] body)`.
- **Closures**: Functions that "close over" variables in their surrounding scope.
- **Homoiconicity**: The property that "code is data" (Clojure code is made of Clojure data structures).
- **`let` binding**: Local variable bindings, which are actually syntactic sugar for anonymous function applications.
- **Higher-Order Functions**:
    - **`partial`**: Returns a new function with some arguments pre-filled.
    - **`apply`**: Calls a function with a collection of arguments.

## Lecture 06 - Definitions & Destructuring
- **Naming**: 
    - `(def name value)` for global constants.
    - `(defn name [args] body)` for global functions.
- **Scoping**: Nested `let` bindings and how they shadow outer scopes.
- **Destructuring**:
    - **Sequential**: `(let [[a b & rest :as all] [1 2 3 4]] ...)`
    - **Map**: `(let [{:keys [foo bar] :as all} my-map] ...)`
- **Persistence (Persistent Data Structures)**:
    - Clojure uses "Okasaki" data structures (finger trees, hitchhiker's trees) for efficiency.
    - **Immutability**: Values never change. Instead, "novelty" is added while the rest of the structure is reused.
    - **Shared Data**: A linked list can have multiple entry points sharing the same tail. This avoids copying overhead.
    - **Garbage Collection**: Nodes are collected only when they are no longer accessible from any entry point (reference).

## Lecture 07 - Core Functions & Conditionals
- **Equality**: `=` (deep equality), `not=`.
- **Sequence Ops**: `first`, `rest`, `conj`, `concat`, `nth`, `assoc`, `dissoc`, `merge`.
- **Conditionals**:
    - `when`, `when-not`: `if` without `else`, returns `nil` if condition is false.
    - `cond`: Multiple condition branches (sequential if-else).
    - `case`: Constant-time dispatch on a value (like switch/case).
    - `do`: Used to wrap multiple expressions for side-effects (only the last value is returned).
- **Side Effects**: Common in logging or IO. `when` implicitly wraps its body in a `do` block.
- **Truthiness**: In Clojure, only `false` and `nil` are considered "falsey"; everything else is "truthy".

## Lecture 08 - Sequences & Iteration

* **Sequence Abstraction**: A logical interface representing a sequential flow, distinct from the underlying data structure.
    * **Definition**: It is not the data itself, but the "knowledge" or function of how to retrieve the **next** element.
    * **Analogy**: Comparable to Iterators or Streams in Java/C++. 
    * **Sources**: Can be derived from finite data (vectors, lists), I/O (files, network sockets), or algorithms (random numbers, infinite ranges).

* **`seq`**: Function to create a sequence from a collection.
    * **Implicit Conversion**: Functions expecting sequences (like `map`) automatically call `seq` on their arguments.
    * **`nil`**: Represents the empty sequence. `(seq [])` returns `nil`.
    * **Maps**: Converted to a sequence of `[key value]` vectors. Order is not guaranteed.

* **Predicates**: Functions that evaluate a condition and return a boolean.
    * **Syntax**: By convention, names end with `?` (e.g., `even?`, `nil?`, `empty?`).

* **Transformations**: Functions that accept a sequence and return a new **lazy** sequence.
    * **`map`**: Applies a function to every element. `(map inc [1 2])` $\rightarrow$ `(2 3)`.
    * **`filter`**: Retains elements where the predicate returns `true`.
    * **`concat`**: Joins multiple sequences into one.

* **Materialization**: "Consuming" a sequence to produce a result or concrete data structure.
    * **`into`**: Pours a sequence into a collection (e.g., `(into [] (range 5))`).
    * **`vec`**: Converts a sequence directly to a vector.
    * **`reduce`**: Aggregates a sequence into a single value using an accumulator function.
        * **Signature**: `(reduce f init-val collection)`. 
        * **Default**: If `init-val` is omitted, the first element becomes the initial accumulator.

* **Lazy Evaluation**:
    * **Definition**: Sequence operations build a processing chain; computation only occurs when elements are requested (e.g., by printing or `into`). 
    * **Infinite Sequences**: Sequences with no bound, such as `(range)` (0 to $\infty$).
    * **`take`**: Extracts `n` elements. Essential for safely terminating infinite sequences before materialization.

## Lecture 09 - Recursion & Optimization
- **Recursion**: The primary means of iteration in Clojure (due to immutability).
- **Stack Usage**: Naive recursion consumes stack frames, leading to `StackOverflowError` for deep recursion.
- **Tail Call Optimization (TCO)**:
    - **Concept**: Reuse the same stack frame if the recursive call is in the **tail position** (last action).
    - **Explicit**: Clojure requires explicit TCO using the `recur` special form.
- **`recur`**:
    - Jumps back to the nearest recursion point (`loop` or function start).
    - Must be in the tail position; compiler enforces this.
    - Arguments passed to `recur` become the new values for the loop bindings/function arguments.
- **`loop`**: Creates a local recursion point with initial bindings, similar to `let` but targets for `recur`.

## Lecture 10 - Macros & Metaprogramming
- **Metaprogramming**: Clojure is **homoiconic** (code is data), allowing programs to write programs.
- **Macros (`defmacro`)**: Functions executed at **compile time**. They receive unevaluated forms and return code to be compiled.
- **Use Cases**: Creating new control structures (`when`, `cond`), defining DSLs, or binding forms (`defn`).
- **Templating**:
    - **Syntax Quote (``` ` ```)**: Templates code and auto-qualifies symbols (namespaces).
    - **Unquote (`~`)**: Evaluates/substitutes a value inside.
    - **Unquote-splice (`~@`)**: Splices a sequence into the list.
- **Debugging**: `macroexpand` and `macroexpand-1` reveal the code generated by a macro.