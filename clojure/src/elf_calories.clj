(ns elf-calories
  (:require [clojure.string :as cstr]
            [clojure.java.io :as io]))

;; https://adventofcode.com/2022/day/1

(def input-data-path "resources/elf_calories_input")

(defn calculate
  [file]
  (with-open [r (io/reader file)]
    (->> r
         line-seq
         (reduce conj [])
         (partition-by cstr/blank?)
         (keep (fn [x] (when-not (cstr/blank? (first x))
                         (reduce (fn [acc i] (+ acc (Integer/parseInt i))) 0 x)))))))

(defn part-one
  [file]
  (->> (calculate file)
       (apply max)))

(defn part-two
  [file]
  (->> (calculate file)
       (sort >)
       (take 3)
       (apply +)))
