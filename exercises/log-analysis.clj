(def log-lines 
  ["INFO: App ready" 
   "ERROR: Database connection failed" 
   "INFO: Useer logged in"])

(defn error? [line]
  (clojure.string/starts-with? line "ERROR:"))

(defn get-message [line]
  (clojure.string/replace line "ERROR: " ""))

(defn wrap-in-map [msg]
  {:type :error, :content msg})


(def processed-logs
  (->> log-lines
       (filter error?)
       (map get-message)
       (map wrap-in-map)
       (into [])))
       
processed-logs
