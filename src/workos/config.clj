(ns workos.config)

(def apikey
  {:secret (System/getenv "WORKOS_API_KEY")
   :client (System/getenv "WORKOS_CLIENT_ID")})

(def redirect-url
  (System/getenv "WORKOS_REDIRECT_URL"))
