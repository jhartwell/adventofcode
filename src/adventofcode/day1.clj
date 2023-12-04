(ns adventofcode.day1
  (:require [clojure.java.io :as io]
            [clojure.string :as cstr]))

(def compress (comp #(Integer/parseInt %) cstr/join (juxt first last)))

(defn process-line
  [line]
  (->> line
       (re-seq #"\d{1}")
       compress))
       

(defn load-data
  [file]
  (with-open [r (io/reader file)]
    (into [] (line-seq r))))

(defn process
  [{:keys [file]}]
  (prn (->> file
            load-data
            (map process-line)
            (apply +))))


(comment

  (def p1 "a1b2c3d4e5f")
  (def p2 "treb7uchet")
  (process-line p1)
  )
