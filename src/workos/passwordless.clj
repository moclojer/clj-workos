(ns workos.passwordless
  (:require [workos.config :as config])
  (:import (com.workos.passwordless PasswordlessApi$CreateSessionOptions)))

;; (builder "email")
(defn builder
  "Creates an instance of [CreateSessionOptions] with the given builder parameters"
  [email
   & {:keys [redirect-url]
      :or {redirect-url config/redirect-url}}]
  (->
   (PasswordlessApi$CreateSessionOptions/builder)
   (.email email)
   (.redirectUri redirect-url)
   (.build)))

;; (send-magic-link "email")
(defn send-magic-link
  "Sends a passwordless session created with [createSession] via email.
   In the case of Magic Link, WorkOS will send an e-mail to the user with a unique
   link to authenticate with."
  [email]
  (let [workos @config/*workos
        session  (.createSession
                  (.-passwordless workos)
                  (builder email))
        send (.sendSession (.-passwordless workos) (.id session))]
    (.success send)))
