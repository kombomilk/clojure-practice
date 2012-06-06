(require 'java.math.BigInteger)

(defn gen-primes [a b]
  "Generates prime numbers from a to b inclusively"
  (filter #(.isProbablePrime (BigInteger/valueOf %) 1) (range a (inc b))))

(defn run
  [n]
  (let [input (read-line)
	[first second] (.split input " ")]
    (when (> n 0)
      (println (gen-primes (.Integer/valueOf first) (.Integer/valueOf second)))
      (run (dec n)))))

(run (.Integer/valueOf (read-line)))