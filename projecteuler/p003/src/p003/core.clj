(ns p003.core)

(defn gen-primes [a b]
  "Generates prime numbers from a to b inclusively"
  (filter #(.isProbablePrime (BigInteger/valueOf %) 100) (range a (inc b))))

(defn largest-prime-factor [n]
  (let [root (Math/ceil (Math/sqrt n))
	primes (gen-primes 1 root)
	factors (filter #(= 0 (mod n %)) (reverse primes))]
    (first factors)))

(largest-prime-factor 600851475143)