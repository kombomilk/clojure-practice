(ns p001.core)

(defn sum-of-3-and-5-multiplies [limit]
  "Sums all the multiplies of 3 and 5(only natural numbers) from 1 to the limit"
  (reduce + (filter #(or (= 0 (rem % 3)) (= 0 (rem % 5)))(range 1 limit))))

(sum-of-3-and-5-multiplies 1000)