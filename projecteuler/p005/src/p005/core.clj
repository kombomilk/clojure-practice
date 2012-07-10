(ns p005.core)

(defn inc-hash-value
 [hash key]
 (let [exists (contains? hash key)
       value (if exists
	       (inc (get hash key))
	       1)]
   (assoc hash key value)))

(defn merge-max [hash1 hash2]
  "Merges two hashes taking the max value if same keys"
  (merge-with max hash1 hash2))

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 100))

(defn gen-primes [a b]
  (filter prime? (range a (inc b))))

(defn prime-denominators-of [n]
  (let [root (Math/ceil (/ n 2))
	prime (prime? n)]
    (if prime (list n) (gen-primes 1 root))))

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

(defn multiply-of-numbers-hash [hash]
  (reduce * (map #(Math/pow % (get hash %)) (keys hash))))

(defn lcd-of-numbers-below [n]
  (int (multiply-of-numbers-hash
	(reduce merge-max (map denominators-hash-of (range 1 (inc n)))))))

(lcd-of-numbers-below 20)