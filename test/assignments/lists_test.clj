(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

;(deftest map'-test
;  (testing "identity with single coll"
;    (is (= (1 2 3) (map' identity [1 2 3]))))
;  (testing "addition with two collections"
;    (is (= (2 4 6) (map' + [1 2 3] [1 2 3]))))
;  )

(deftest filter'-test
  (testing "filter even numbers"
    (is (= [2 4] (filter' even? [1 2 3 4]))))
  (testing "filter not nil values"
    (is (= [1 2 4] (filter' (comp not nil?) [1 nil 2 nil nil 4]))))
  )
