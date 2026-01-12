# Summary
The lecture covered administrative details regarding the "exam" (which is a booked appointment/discussion) and the final project (an illustrative code example). The technical portion focused on **Sequences (Seq)** in Functional Programming (specifically Clojure). The instructor defined sequences not as data structures holding values, but as an algorithmic "knowledge" or interface defining how to access the **next** element. Key topics included creating sequences, lazy evaluation (allowing for infinite sequences), transforming sequences (map, filter), and consuming/materializing sequences (reduce, into).

# Key Concepts
* **Sequence Abstraction**
    * A sequence is not necessarily data stored in memory; it is an interface representing an ordered flow of elements.
    * The fundamental requirement is the knowledge of how to retrieve the **next** element.
    * This concept is similar to **Iterators** in C++/Java or **Streams** in Java.
* **Data vs. Sequence**
    * Data structures (Vectors, Lists, Trees) describe how data is organized in memory.
    * Sequences describe how to traverse that data.
    * A sequence can be derived from data (e.g., a List) or generated algorithmically (e.g., Random numbers, infinite ranges).
* **Lazy Evaluation**
    * Sequences can be **unbound** or **infinite** (e.g., an infinite range of integers).
    * Transformations (like filtering or mapping) are lazy; they build a processing pipeline but do not execute until the result is explicitly materialized or consumed.
* **Predicates**
    * Functions that return boolean values (true/false).
    * In Clojure, the idiomatic naming convention for predicates ends with a question mark (e.g., `even?`, `empty?`).

# Important Details
* **Course Administration (Exam/Project)**
    * **Format:** Not a written exam; it is an appointment-based discussion.
    * **Booking:** Slots will be available (approx. 4 per week). A link will be sent soon.
    * **Deadline:** Must be completed before the start of the next semester.
    * **Project:** A small "illustration" of functional concepts is required. It does not need to be a large application. Pair work is allowed.
    * **Language:** English is the standard, but the instructor accepts German if students are uncomfortable with English.

* **Sequence Operations (Clojure)**
    * **Creation:**
        * `seq`: Converts data structures (Vectors, Lists, Maps) into a sequence.
        * `range`: Generates a sequence of numbers. calling `(range)` without arguments creates an infinite sequence ($0, 1, 2, ... \infty$).
        * `nil`: Treated idiomatically as an empty sequence.
    * **Transformation (Pipelines):**
        * `map`: Applies a function $f$ to every element: $f(x)$.
        * `filter`: Keeps elements where predicate $P(x)$ returns true.
        * `concat`: Joins multiple sequences.
    * **Materialization (Consumption):**
        * `into`: Collects a sequence back into a data structure (e.g., Vector).
        * `reduce`: Folds a sequence using an accumulator and a function of two arguments: $f(acc, val)$. The result is a single value, not a sequence.
        * `take`: Extracts a specific number of elements (crucial for handling infinite sequences safely).

* **Technical Warnings**
    * **IDE Crash Risk:** Attempting to print or materialize an infinite sequence (e.g., typing `(range)` in the REPL) will cause the IDE to hang or crash as it runs out of memory.
    * **Style:** Students should avoid writing "Java code in Clojure syntax" (e.g., just wrapping object instantiation). Use idiomatic functional patterns.

# Todos / Action Items
* **Instructor:** Send out the link for booking exam appointments (likely this week or next week).
* **Students:** Book an exam slot once the link is available.
* **Students:** Prepare the "illustration" project (can be done in pairs).
* **Students:** Review GitHub or libraries to understand idiomatic Clojure code style.

# Questions / Open Points
* _No open questions mentioned._

# Additional Notes
* **Meta-comment on Language:** The instructor emphasized that English is the standard language of IT and research. Even if working in German companies, technical documentation and code often remain in English.
* **Warning:** Do not wait until the very last day of the semester to book the appointment to avoid scheduling issues.