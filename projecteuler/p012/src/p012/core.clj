(ns p012.core)

(defn gen-primes [a b]
  "Generates prime numbers from a to b inclusively"
  (filter #(.isProbablePrime (BigInteger/valueOf %) 10) (range a (inc b))))

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 10))

(defn prime-denominators-of [n]
  (let [root (Math/ceil (/ n 2))
	prime (prime? n)]
    (if prime (list n) (gen-primes 1 root))))

(defn inc-hash-value
 [hash key]
 (let [exists (contains? hash key)
       value (if exists
	       (inc (get hash key))
	       1)]
   (assoc hash key value)))

(defn denominators-hash-of [n]
  (loop [num n
	 hash {}
	 primes (prime-denominators-of n)]
    (let [prime (first primes)]
      (if (or (= 1 num) (empty? primes))
	hash
	(if (zero? (rem num prime))
	  (recur (/ num prime) (inc-hash-value hash prime) primes)
	  (recur num hash (rest primes)))))))

(defn num-of-divisors [n]
  (let [values (map inc (vals (denominators-hash-of n)))]
    (reduce *' values)))

(defn sums []
  (letfn [(sum-seq [n sum]
		   (lazy-seq
		    (cons sum (sum-seq (inc n) (+ (inc n) sum)))))]
    (sum-seq 1 1)))

(nth (sums) (count (take-while #(< (num-of-divisors %) 500) (sums))))