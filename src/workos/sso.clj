(ns workos.sso
  (:require [workos.config :as config])
  (:import (com.workos WorkOS)))

(defn get-profile-token
  "Fetch the profile details and access token for the authenticated SSO user"
  [code]
  (.getProfileAndToken (.-sso (WorkOS. (:secret config/apikey))) code (:client config/apikey)))

(defn get-profile
  "Fetch the profile details via provided access token"
  [access-token]
  (.getProfile (.-sso (WorkOS. (:secret config/apikey))) access-token))

