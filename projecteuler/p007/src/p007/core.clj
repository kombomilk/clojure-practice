(ns p007.core)

(defn gen-primes [a b]
  "Generates prime numbers from a to b inclusively"
  (filter #(.isProbablePrime (BigInteger/valueOf %) 100) (range a (inc b))))

(def primes (gen-primes 1 Integer/MAX_VALUE))

(nth primes 10000)