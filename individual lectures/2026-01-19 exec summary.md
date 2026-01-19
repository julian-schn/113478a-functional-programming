# Summary
The lecture focused on **Recursion** as the fundamental mechanism for iteration in functional programming without mutation. The instructor explained the limitations of naive recursion (Stack Overflow) and introduced **Tail Call Optimization (TCO)** as the solution. The session demonstrated how to use `recur` and `loop` in Clojure to achieve efficient, stack-safe iteration that is performance-equivalent to imperative loops. Administrative updates regarding exam scheduling were also provided.

# Key Concepts
*   **Recursion vs. Iteration**
    *   Since data is immutable, traditional `for` loops with mutating counters don't exist in the same way.
    *   Recursion replaces iteration: a function calls itself with *new* values (bindings) instead of changing existing ones.
*   **The Stack Problem**
    *   Each function call pushes a new frame onto the stack.
    *   Naive recursion on large sequences leads to **StackOverflowError** because the stack size is limited.
*   **Tail Call Optimization (TCO)**
    *   **Definition:** If the *very last* thing a function does is call itself, the runtime can discard the current stack frame and reuse it for the next call.
    *   **Result:** Recursion becomes constant space (O(1) stack memory), effectively turning it into a loop at the low level.
*   **`recur`**
    *   Clojure's special form for explicit TCO.
    *   **Constraint:** Must be in the **tail position**. If you try to do something after the `recur` (like `(+ 1 (recur ...))`), the compiler will throw an error.
    *   **Target:** Jumps to the nearest recursion point (either the function top-level or a `loop`).
*   **`loop`**
    *   A macro that establishes a recursion point with initial bindings (similar to `let`).
    *   Allows defining recursive logic without polluting the function signature with accumulator arguments.

# Important Details
*   **Administrative**
    *   **Exam Period:** Roughly mid-February to mid-March (17th).
    *   **Format:** Appointment slots will be available soon.
    *   **Constraint:** Exams must be finished before the next semester starts.
*   **Code Example: `my-count`**
    *   *Naive:* `(+ 1 (my-count (rest s)))` -> Not tail recursive (addition happens *after* return). Crashes on 10k+ elements.
    *   *Accumulator Style:* Pass a running `count` variable.
    *   *Tail Recursive:* `(recur (rest s) (inc count))` -> Tail position. Runs indefinitely without crashing.
*   **Recursive Data vs. Algorithms**
    *   Recursive algorithms (like processing a list head/tail) often mirror the recursive nature of the data structures (Cons cells).

# Todos / Action Items
*   **Instructor:** Send out the booking link for oral exams.
*   **Students:** Book an appointment window (Feb 16 - Mar 17).
*   **General:** Practice converting naive recursive solutions into TCO-safe `loop`/`recur` forms.
