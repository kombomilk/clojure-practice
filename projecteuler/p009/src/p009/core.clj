(ns p009.core)

(defn sqr [x] (* x x))

(defn sum-of-sqr [x y]
  (+ (sqr x) (sqr y)))

(defn pythagorean? [a b c]
  (= (sqr c) (sum-of-sqr a b)))

(defn all-sum-pairs-of [n]
  (let [half (Math/floor (/ n 2))]
    (for [i (range 1 (inc half))]
      [(- n i) i])))

(defn find-pythagorians-given-sum [sum]
  (for [c (range 1 (- sum 2))
	[b a] (all-sum-pairs-of (- sum c))
	:when (pythagorean? a b c)]
      (list a b c)))

(reduce * (first (find-pythagorians-given-sum 1000)))