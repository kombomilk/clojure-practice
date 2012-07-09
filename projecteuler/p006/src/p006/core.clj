(ns p006.core)

(defn square [n]
  (* n n))

(defn sum-of-squares-below [n]
  (reduce +' (map square (range 1 (inc n)))))

(defn square-of-sum-below [n]
  (square (reduce +' (range 1 (inc n)))))

(- (square-of-sum-below 100) (sum-of-squares-below 100))