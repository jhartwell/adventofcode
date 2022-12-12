(ns day-2
  (:require [clojure.java.io :as io]
            [clojure.string :as cstr]))

(defn calculate
  [points-table file]
  (with-open [r (io/reader file)]
    (->> r
         line-seq
         (reduce conj [])
         (map #(cstr/split % #"\s"))
         (reduce (fn [acc x] (+ acc (get points-table x 0))) 0))))

(def input-data-file "resources/elf_rock_paper_scissors")

;; Due to the limited number of potential outcomes there isn't much harm
;; in creating the point tables by hand

(def part-1-points {["A" "X"] 4 ;; They pick rock, you pick rock. Draw
             ["A" "Y"] 8 ;; they pick rock, you pick paper, you win
             ["A" "Z"] 3 ;; they pick rock, you pick scissors, you lose
             ["B" "X"] 1 ;; They pick paper, you pick rock, you lose
             ["B" "Y"] 5 ;; They pick paper, you pick paper, draw
             ["B" "Z"] 9 ;; They pick paper, you pick scissors, you win.
             ["C" "X"] 7 ;; They pick scissors, you pick rock, you win
             ["C" "Y"] 2 ;; they pick scissors, you pick paper, they win
             ["C" "Z"] 6 ;; they pick scissors, you pick scissors, draw
             })
                       
(def part-2-points {["A" "X"] 3 ;; They pick rock and you lose, pick scissors 
             ["A" "Y"] 4 ;; they pick rock and you draw, pick rock 
             ["A" "Z"] 8 ;; they pick rock and you win, pick paper
             ["B" "X"] 1 ;; They pick paper and you lose, pick rock
             ["B" "Y"] 5 ;; They pick paper and you draw, pick paper
             ["B" "Z"] 9 ;; They pick paper and you win, pick scissors
             ["C" "X"] 2 ;; They pick scissors and you lose, pick paper
             ["C" "Y"] 6 ;; they pick scissors and you draw, pick scissors
             ["C" "Z"] 7 ;; they pick scissors and you win, pick rock
             })

(def part-1 (partial calculate part-1-points))
(def part-2 (partial calculate part-2-points))

(part-1 input-data-file)
(part-2 input-data-file)
