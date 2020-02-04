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

(deftest yudishtira-truthy-value
  (testing "truthy value (2)"
    (is (= 2 (yudishtira 2))))
  (testing "truthy value ([])"
    (is (= [] (yudishtira []))))
  (testing "truthy value (\"\")"
    (is (= "" (yudishtira ""))))
  (testing "falsy value (nil)"
    (is (= :ashwathama (yudishtira nil))))
  (testing "falsy value (false)"
    (is (= :ashwathama (yudishtira false)))))

(deftest duplicate-first-test
  (testing "non empty coll"
    (is (= [1 1 2 3 4 5] (duplicate-first [1 2 3 4 5]))))
  (testing "empty coll"
    (is (= nil (duplicate-first [])))))

(deftest test-five-point-someone
  (testing "x equals 5"
    (is (= :satan-bhagat (five-point-someone 5 3))))
  (testing "y equals 5"
    (is (= :chetan-bhagat (five-point-someone 3 5))))
  (testing "x greater than y"
    (is (= :greece (five-point-someone 10 9))))
  (testing "else condition"
    (is (= :universe (five-point-someone 10 20)))))