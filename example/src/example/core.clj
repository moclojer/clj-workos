(ns example.core
  (:gen-class)
  (:require [workos.passwordless :as passwordless]))

(defn -main
  [& args]
  (prn (passwordless/send-magic-link "example@moclojer.com")))
