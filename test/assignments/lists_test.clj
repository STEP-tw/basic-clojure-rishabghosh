(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

;(deftest map'-test
;  (testing "identity with single coll"
;    (is (= (1 2 3) (map' identity [1 2 3]))))
;  (testing "inc with single coll"
;    (is (= (2 3 4) (map' inc [1 2 3]))))
;  (testing "addition with two collections"
;    (is (= (2 4 6) (map' + [1 2 3] [1 2 3 4]))))
;  )

(deftest filter'-test
  (testing "filter even numbers"
    (is (= [2 4] (filter' even? [1 2 3 4]))))
  (testing "filter not nil values"
    (is (= [1 2 4] (filter' (comp not nil?) [1 nil 2 nil nil 4]))))
  )

(deftest reduce-test
  (testing "+ without initial value"
    (is (= 15 (reduce' + [1 2 3 4 5]))))
  (testing "conj with initial value"
    (is (= #{:a :c :b} (reduce' conj #{} [:a :b :c]))))
  (testing "simple factorial"
    (is (=
          120
          (reduce' * (range 1 (inc 5)))
          ))))

(deftest count-test
  (testing "with empty list"
    (is (zero? (count' []))))
  (testing "with integer elements in list"
    (is (= 4 (count' [4 2 6 2]))))
  (testing "list containing multiple data types"
    (is (= 5 (count' [1 \a "string" [1 2] {:foo :bar}])))))

(deftest reverse-test
  (testing "with empty list"
    (is (= () (reverse' []))))
  (testing "with elements in list"
    (is (= '(3 2 1) (reverse' [1 2 3]))))
  (testing "with string"
    (is (= '(\e \r \u \j \o \l \c) (reverse' "clojure"))))
  (testing "with non-seqable"
    (is (nil? (reverse' true)))))

(deftest every?-test
  (testing "with empty list"
    (is (true? (every?' odd? []))))
  (testing "odd? with odd value"
    (is (true? (every?' odd? [1 3 5]))))
  (testing "odd? with one even value in list"
    (is (false? (every?' odd? [1 2 3])))))
