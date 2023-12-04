(ns adventofcode.core
  (:require [adventofcode.day1]))


(defmulti run :day)
  
(defn main
  [args]
  (run args))
  
