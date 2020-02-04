(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest for-safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest for-informative-divides
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinity (informative-divide 3 0)))))

(deftest for-harishchandra
  (testing "truthy value (2)"
    (is (= 2 (harishchandra 2))))
  (testing "truthy value ([])"
    (is (= [] (harishchandra []))))
  (testing "truthy value (\"\")"
    (is (= "" (harishchandra ""))))
  (testing "falsy value (nil)"
    (is (= nil (harishchandra nil))))
  (testing "falsy value (false)"
    (is (= nil (harishchandra false)))))
