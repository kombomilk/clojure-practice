(defn t []
  (let [x (read-line)]
    (when (not= x "42") (println x) (t))))

(t)