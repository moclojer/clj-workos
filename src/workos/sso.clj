(ns workos.sso
  (:require [workos.config :as config]))

(defn get-profile-token
  "Fetch the profile details and access token for the authenticated SSO user"
  [code]
  (.getProfileAndToken (.-sso @config/*workos)
                       code (:client config/apikey)))

(defn get-profile
  "Fetch the profile details via provided access token"
  [access-token]
  (.getProfile (.-sso @config/*workos) access-token))

(defn redirect-url
  "Generate an Oauth2 authorization URL where your users will
   authenticate using the configured SSO Identity Provider"
  [connection-id
   & {:keys [redirect-url]
      :or {redirect-url config/redirect-url}}]
  (->
   (.-sso @config/*workos)
   (.getAuthorizationUrl (:client config/apikey) redirect-url)
   (.connection connection-id)
   (.build)))
