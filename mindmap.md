```mermaid
%%{init: {
  "theme": "base",
  "themeVariables": {
    "background": "#FFFFFF",
    "fontFamily": "ui-sans-serif, system-ui, -apple-system, Segoe UI, Roboto, Helvetica, Arial",
    "fontSize": "14px",

    "primaryColor": "#F8FAFC",
    "primaryTextColor": "#0F172A",
    "primaryBorderColor": "#CBD5E1",

    "secondaryColor": "#EEF2FF",
    "secondaryTextColor": "#0F172A",
    "secondaryBorderColor": "#C7D2FE",

    "tertiaryColor": "#ECFDF5",
    "tertiaryTextColor": "#0F172A",
    "tertiaryBorderColor": "#A7F3D0",

    "lineColor": "#94A3B8",
    "textColor": "#0F172A",
    "edgeLabelBackground": "#FFFFFF"
  },
  "mindmap": { "padding": 16, "maxNodeWidth": 280 }
} }%%
mindmap
  root((Clojure))
    Immutability
        (Clojure uses an immutable data model, essentially we return new data structures with changes applied instead of mutating data)
        assoc
            (Associates a key with a value in an associative structure,usually a map, and returns a new structure)
        conj
            (Adds an element, conjoins, to a collection and returns a new collection)
                (Vectors: adds at the end)
                (List: adds to front)
                (Set: adds if not already present)
                (Map: adds map entries)
        conj vs assoc on maps
            (assoc sets a specific key, use when you know the key)
            (conj adds map entries, when adding entries generically)
        (Clojure is dynamically typed but conj on maps requires the value to be a valid map entry)
        (Clojure does not fully copy collections on conj/assoc, it uses persistent data structures with structurall sharing, this means most of the old strucure is reused, only small parts are new and updates are cheap. Old state still exists as value, if not references andymore it becomes eligible for GC)
    Recursion
        (The idea in Clojure is that the state of the loop should be explicit and values should remain being immutable)
        (Plain recursion can blow the stack and cause a StackOverflowError)
        Tail Call Optimization
            recur
                (recur is a control structure that jumps back to the nearest lloop of function entry with new arguments, bindings, it cannot jump into another function)
                (recur helps to prevent any accidental non-tail recursion)
            (Clojure does not automatically perform Tail Call Optimization)
            (A call is in tail position when it is the final action of the function. Because nothing happens after the recursive call, the compiler can: reuse the current stack frame, avoid strack growth, run in constant stack space)
    Destructuring
```