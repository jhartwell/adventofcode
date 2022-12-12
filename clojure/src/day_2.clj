(ns day-2
  (:require [clojure.java.io :as io]
            [clojure.string :as cstr]))

(def input-data-file "resources/elf_rock_paper_scissors")


;; a, x - rock
;; b, y paper
;; c, z scissors




(def points {["A" "X"] 4 ;; They pick rock, you pick rock. Draw
             ["A" "Y"] 8 ;; they pick rock, you pick paper, you win
             ["A" "Z"] 3 ;; they pick rock, you pick scissors, you lose
             ["B" "X"] 1 ;; They pick paper, you pick rock, you lose
             ["B" "Y"] 5 ;; They pick paper, you pick paper, draw
             ["B" "Z"] 9 ;; They pick paper, you pick scissors, you win.
             ["C" "X"] 7 ;; They pick scissors, you pick rock, you win
             ["C" "Y"] 2 ;; they pick scissors, you pick paper, they win
             ["C" "Z"] 6 ;; they pick scissors, you pick scissors, draw
             })
                       
(defn calculate
  [file]
  (with-open [r (io/reader file)]
    (->> r
         line-seq
         (reduce conj [])
         (map #(cstr/split % #"\s")))))
         

(defn part-1
  [file]
  (->> file
       calculate
       (reduce (fn [acc x] (+ acc (get points x 0))) 0)))

(defn part-2
  [file])
  
(part-1 input-data-file)

(get points (first (calculate input-data-file)))

   
         
