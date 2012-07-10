(ns p010.core)

(defn gen-primes [a b]
  "Generates prime numbers from a to b inclusively"
  (filter #(.isProbablePrime (BigInteger/valueOf %) 10) (range a (inc b))))

(def primes (gen-primes 1 Integer/MAX_VALUE))

(defn primes-below [n]
  (take-while #(< % n) primes))

(reduce + (primes-below 2000000))