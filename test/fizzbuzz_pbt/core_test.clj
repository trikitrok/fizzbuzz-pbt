(ns fizzbuzz-pbt.core-test
  (:require
    [midje.sweet :refer :all]
    [clojure.set :as set]
    [clojure.test.check.generators :as gen]
    [midje.experimental :refer [for-all]]
    [fizzbuzz-pbt.core :as sut]))

(defn- multiples-of [n]
  (iterate #(+ % n) n))

(defn- fizzbuzz-for [n]
  (let [pos (dec n)]
    (nth (sut/fizzbuzz) pos)))

(def multiples-of-3
  (set (take-while #(< % 101) (multiples-of 3))))

(def multiples-of-5
  (set (take-while #(< % 101) (multiples-of 5))))

(facts
  "about fizzbuzz"

  (fact
    "multiples of 3 but not 5 are Fizz"
    (for-all
      [n (gen/elements
           (set/difference
             multiples-of-3
             multiples-of-5))]
      {:num-tests 100}
      (fizzbuzz-for n) => "Fizz"))

  (fact
    "multiples of 5 but not 3 are Buzz"
    (for-all
      [n (gen/elements
           (set/difference
             multiples-of-5
             multiples-of-3))]
      {:num-tests 100}
      (fizzbuzz-for n) => "Buzz"))

  (fact
    "multiples of 3 and 5 are FizzBuzz"
    (for-all
      [n (gen/elements
           (set/intersection
             multiples-of-5
             multiples-of-3))]
      {:num-tests 100}
      (fizzbuzz-for n) => "FizzBuzz"))

  (fact
    "the rest of numbers are casted to string"
    (for-all
      [n (gen/elements
           (set/difference
             (set (range 1 101))
             multiples-of-3
             multiples-of-5))]
      {:num-tests 100}
      (fizzbuzz-for n) => (str n))))
