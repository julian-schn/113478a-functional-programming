(require '[clojure.string :as str])

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

(defn score->emoji [score]
  (case score
    :green  "🟩"
    :yellow "🟨"
    :miss   "⬛"))

;; Display

(defn clear-screen []
  (print "\033[H\033[2J")
  (flush))

(defn print-board [target attempts]
  (println "┌─────────────────────┐")
  (println "│   C L O R D L E     │")
  (println "└─────────────────────┘")
  (println)
  (doseq [guess attempts]
    (let [scores (score-guess target guess)
          emojis (str/join " " (map score->emoji scores))
          letters (str/join " " (map str/upper-case (map str guess)))]
      (println (str "  " emojis))
      (println (str "  " letters))
      (println)))
  ;; Empty slots for remaining attempts
  (doseq [_ (range (- 6 (count attempts)))]
    (println "  ⬜ ⬜ ⬜ ⬜ ⬜")
    (println)))

;; The Game Loop

(defn game-loop [{:keys [target attempts] :as state}]
  (clear-screen)
  (print-board target attempts)
  (println (str "Attempt " (inc (count attempts)) " of 6 — enter your guess:"))

  (let [guess (str/lower-case (str/trim (read-line)))]
    (cond
      ;; Invalid input: re-prompt without consuming an attempt
      (not (re-matches #"[a-z]{5}" guess))
      (do
        (println "Invalid guess: must be exactly 5 letters.")
        (Thread/sleep 1200)
        (recur state))

      ;; Case 1: Win
      (= guess target)
      (do
        (clear-screen)
        (print-board target (conj attempts guess))
        (println "YOU WON! 🎉"))

      ;; Case 2: Lose (reached 6th try and missed)
      (= (count attempts) 5)
      (do
        (clear-screen)
        (print-board target (conj attempts guess))
        (println (str "GAME OVER! The word was: " (str/upper-case target))))

      ;; Case 3: Continue
      :else
      (recur (assoc state :attempts (conj attempts guess))))))

;; Entry Point
(game-loop {:target "react" :attempts []})

;; TODO: Word list
