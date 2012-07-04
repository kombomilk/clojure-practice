(ns p002.core
  (:import java.math.BigInteger
	   java.lang.Integer))

(defn gen-primes [a b]
  "Generates prime numbers from a to b inclusively"
  (filter #(.isProbablePrime (BigInteger/valueOf %) 1) (range a (inc b))))

(defn my-read []
  (let [x (.trim (read-line))] x))

(defn print-list [l]
  (doseq [i (conj l " ")]
    (println i)))

(defn run [n]
  (let [input (read-line)
	[first second] (.split input " ")]
    (when (> n 0)
      (print-list (gen-primes (Integer/valueOf first) (Integer/valueOf second)))
      (run (dec n)))))

(run (dec (Integer/valueOf (read-line))))
; (my-read)
