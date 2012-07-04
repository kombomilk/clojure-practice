(ns p002.core)

(defn fib-numbers
  "Lazy sequence of Fibonacci numbers"
  ([] (concat [1 1] (fib-sequence 1 1)))
  ([a b] (lazy-seq (cons (+' a b) (fib-sequence b (+' a b))))))

(defn fib-numbers-until [n]
  "Returns Fibonacci numbers sequence until the given limit"
  (take-while #(< % n) (fib-sequence)))

(defn even-fib-numbers-until [limit]
  "Returns all even Fibonacci numbers sequence until the given limit"
  (filter even? (fib-numbers-until limit)))

(defn sum-of-even-fib-numbers-until [limit]
  "Returns the sum of all even Fibonacci numbers until the given limit"
  (reduce + (even-fib-numbers-until limit)))

(sum-of-even-fib-numbers-until 4000000)