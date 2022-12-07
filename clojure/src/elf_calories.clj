(ns elf-calories
  (:require [clojure.string :as cstr]
            [clojure.java.io :as io]))

;; https://adventofcode.com/2022/day/1

(defn calculate
  [file]
  (with-open [r (io/reader file)]
    (->> r
         line-seq
         (reduce conj [])
         (partition-by cstr/blank?)
         (keep (fn [x] (when-not (cstr/blank? (first x))
                         (reduce (fn [acc i] (+ acc (Integer/parseInt i))) 0 x))))
         (apply max))))

(calculate "resources/elf_calories_input")
