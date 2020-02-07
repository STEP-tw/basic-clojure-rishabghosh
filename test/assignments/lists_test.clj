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

(deftest some?-test
  (testing "with empty list"
    (is (nil? (some?' odd? []))))
  (testing "odd? with odd value"
    (is (true? (some?' odd? [1 3 5]))))
  (testing "odd? with one even value in list"
    (is (true? (some?' odd? [1 2 3]))))
  (testing "even? with no even values in list"
    (is (false? (some?' even? [1 3 5])))))

(deftest ascending?-test
  (testing "with correct sequence"
    (is (true? (ascending? [1 2 3]))))
  (testing "with wrong sequence"
    (is (false? (ascending? [1 4 3])))))

;(deftest distinct'-test
;  (testing "should return distinct elements"
;    (is (= [1 2 3 4 5] (take 5 (distinct' [1 1 2 2 3 4 4 5])))))
;  (testing "should return distinct names"
;    (is (= ["john" "lenon"] (take 2 (distinct' ["john" "john" "lenon"]))))))


;(deftest dedupe'-test
;  (testing "should return consecutive distinct elements"
;    (is (= [1 2 3 4 5 1] (take 6 (dedupe' [1 1 2 2 3 4 4 5 1]))))
;    ))

(deftest sum-of-adjacent-digits-test
  (testing "should return (6 8 10 15) for (2 4 4 6 9)"
    (is (= '(6 8 10 15) (sum-of-adjacent-digits [2 4 4 6 9])))
    ))

(deftest max-three-digit-sequence-test
  (testing "should return [3 4 5]"
    (is (= [3 4 5] (max-three-digit-sequence [1 2 3 4 5]))))
  (testing "max 3 digit sequence"
    (is (= [2 -1 2] (max-three-digit-sequence [1 2 -1 2 0])))))

(deftest difference-test
  (testing "get intersection"
    (is (= [4 5] (difference [1 2 3] [1 2 3 4 5]))))
  (testing "should return [9]"
    (is (= [9] (difference [1 3 5 7] [1 3 5 7 9]))))
  )
