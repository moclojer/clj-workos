(ns workos.config
  (:import (com.workos WorkOS)))

(def apikey
  {:secret (System/getenv "WORKOS_API_KEY")
   :client (System/getenv "WORKOS_CLIENT_ID")})

(def redirect-url
  (System/getenv "WORKOS_REDIRECT_URL"))

(def *workos
  "WorkoOS instance initiated"
  (delay
   (WorkOS. (:secret apikey))))
