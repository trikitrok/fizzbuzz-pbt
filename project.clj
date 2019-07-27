(defproject fizzbuzz-pbt "0.1.0-SNAPSHOT"
  :description "Fizzbuzz kata using property-based testing"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[midje "1.9.1"]
                                  [org.clojure/test.check "0.10.0-alpha2"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             :midje {}})
