(ns fizzbuzz-pbt.core
  (:require
    [clojure.string :as string]))

(defn fizzbuzz []
  (map #(string/replace (str %1 %2) #"^$" (str %3))
       (cycle ["" "" "Fizz"])
       (cycle ["" "" "" "" "Buzz"])
       (range 1 101)))
