(ns clojure.core.matrix.impl.mathsops)

;; data structure for code generation of maths operations
;; format is (<symbol> <java.lang.Math equivalent>)

(def maths-ops
  '[(abs Math/abs)
	  (acos Math/acos)
	  (asin Math/asin)
	  (atan Math/atan)
	  (cbrt Math/cbrt)
	  (ceil Math/ceil)
	  (cos Math/cos)
	  (cosh Math/cosh)
	  (exp Math/exp)
	  (floor Math/floor)
	  (log Math/log)
	  (log10 Math/log10)
	  (round Math/rint)
	  (signum #?(:clj Math/signum :cljs Math/sign))
	  (sin Math/sin)
	  (sinh Math/sinh)
	  (sqrt Math/sqrt)
	  (tan Math/tan)
	  (tanh Math/tanh)
   	(to-degrees Math/toDegrees)
	  (to-radians Math/toRadians)])

;(defn ^double abs [^double x] (Math/abs x))
;(defn ^double acos [^double x] (Math/acos x))
;(defn ^double asin [^double x] (Math/asin x))
;(defn ^double atan [^double x] (Math/atan x))
;(defn ^double cbrt [^double x] (Math/cbrt x))
;(defn ^double ceil [^double x] (Math/ceil x))
;(defn ^double cos [^double x] (Math/cos x))
;(defn ^double cosh [^double x] (Math/cosh x))
;(defn ^double exp [^double x] (Math/exp x))
;(defn ^double floor [^double x] (Math/floor x))
;(defn ^double log [^double x] (Math/log x))
;(defn ^double log10 [^double x] (Math/log10 x))
;(defn ^double round [^double x] (double (Math/round x)))
;(defn ^double signum [^double x] #?(:clj (Math/signum x) :cljs (Math/sign x)))
;(defn ^double sin [^double x] (Math/sin x))
;(defn ^double sinh [^double x] (Math/sinh x))
;(defn ^double sqrt [^double x] (Math/sqrt x))
;(defn ^double tan [^double x] (Math/tan x))
;(defn ^double tanh [^double x] (Math/tanh x))

(defn ^double to-degrees [^double x] #?(:clj (Math/toDegrees x) :cljs (/ (* x 180.0) Math/PI)))
(defn ^double to-radians [^double x] #?(:clj (Math/toRadians x) :cljs (/ (* x Math/PI) 180.0)))

#?(:clj

(doseq [[sym op] maths-ops]
  (let []
    (eval `(defn ~sym
            ~(vary-meta
               `([~(vary-meta 'x assoc :tag 'double)]
                  (~op ~'x))
               assoc :tag double)))))

)

