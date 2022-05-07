(ns workos.sso
  (:require [workos.config :as config])
  (:import (com.workos WorkOS)))

(defn get-profile-token
  "Fetch the profile details and access token for the authenticated SSO user"
  [code]
  (.getProfileAndToken (.-sso (WorkOS. (:secret config/apikey)))
                       code (:client config/apikey)))

(defn get-profile
  "Fetch the profile details via provided access token"
  [access-token]
  (.getProfile (.-sso (WorkOS. (:secret config/apikey))) access-token))

(defn redirect-url
  "Generate an Oauth2 authorization URL where your users will
   authenticate using the configured SSO Identity Provider"
  [connection-id
   & {:keys [redirect-url]
      :or {redirect-url config/redirect-url}}]
  (->
   (.-sso (WorkOS. (:secret config/apikey)))
   (.getAuthorizationUrl (:client config/apikey) redirect-url)
   (.connection connection-id)
   (.build)))
