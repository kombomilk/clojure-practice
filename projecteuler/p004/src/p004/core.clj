(ns p004.core
  (:require [clojure.string :as str]))

(defn notzero? [n]
  (not (zero? n)))

(defmulti palyndrome? #(type %))

(defmethod palyndrome? java.lang.String [s]
  (= s (str/reverse s)))

(defmethod palyndrome? :default [s]
  (= (str s) (str/reverse (str s))))

(def pairs
     (for [i (range 100 1000)
	   j (range 100 1000)
	   :when (and
		  (notzero? (mod i 10))
		  (notzero? (mod j 10))
		  (palyndrome? (* i j)))]
       (* i j)))

(last (sort pairs))