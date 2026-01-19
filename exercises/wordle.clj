;; Pure Helper Functions

(defn in-word? [word letter]
  ((set word) letter))

(defn score-letter [target-char guess-char full-target]
  (cond
    (= target-char guess-char) :green
    (in-word? full-target guess-char) :yellow
    :else :miss))

(defn score-guess [target guess]
  (map (fn [t g] (score-letter t g target))
       target guess))

;; The Game Loop

(defn game-loop [target attempts]
  ;; Show attempts left (6 - count)
  (println "Enter your guess (" (- 6 (count attempts)) " attempts left):")
  
  (let [guess (read-line)]
    (cond
      ;; Case 1: Win
      (= guess target)
      (println "YOU WON! The word was:" target)

      ;; Case 2: Lose (Reached 6th try and missed)
      (= (count attempts) 5) 
      (println "GAME OVER! The word was:" target)

      ;; Case 3: Continue
      :else
      (do 
        (println "Score:" (score-guess target guess))
        ;; Use 'recur' for Tail Call Optimization (TCO)
        (recur target (conj attempts guess))))))

;; Entry Point
(println "--- Clordle: Clojure Wordle ---")
(game-loop "react" [])

;; TODO: Input validation
;; TODO: Word list
;; TODO: Keep track of guesses, mark green/yellow