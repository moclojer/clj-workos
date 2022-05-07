(ns workos.passwordless
  (:require [workos.config :as config])
  (:import (com.workos.passwordless PasswordlessApi$CreateSessionOptions)))

;; (builder email)
(defn builder
  "Creates an instance of [CreateSessionOptions] with the given builder parameters"
  [email]
  (->
   (PasswordlessApi$CreateSessionOptions/builder)
   (.email email)
   (.redirectUri config/redirect-url)
   (.build)))

;; (send-magic-link (new WorkOS) email)
(defn send-magic-link
  "Sends a passwordless session created with [createSession] via email.
   In the case of Magic Link, WorkOS will send an e-mail to the user with a unique
   link to authenticate with."
  [workos, email]
  (let [session  (.createSession
                  (.-passwordless workos)
                  (builder email))
        send (.sendSession (.-passwordless workos) (.id session))]
    (.success send)))
