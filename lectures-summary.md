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

## Lecture 08 - Sequences (Upcoming)
- Concepts mentioned: Sequence transformations (map, reduce, filter, concat), lazy sequences, and unbound size data structures.
