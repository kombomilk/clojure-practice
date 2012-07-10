(ns p014.core)

(defn formula [n]
  (if (even? n)
    (/ n 2)
    (inc (* 3 n))))

(defn sequence-from [n]
  (letfn [(seq-helper [next]
		      (lazy-seq
		       (cons next (seq-helper (formula next)))))]
    (take-while #(not= % 1) (seq-helper n))))

(defn pairs-max [p1 p2]
  (if (> (first p1)
	 (first p2))
    p1
    p2))

(defn max-chain-from []
  (second (reduce pairs-max
		  (map #(list (count (sequence-from %)) %) (range 1 1000000)))))
