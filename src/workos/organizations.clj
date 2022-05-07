(ns workos.organizations
  (:import (com.workos.organizations OrganizationsApi$CreateOrganizationOptions)))

(defn builder
  "Creates an instance of [CreateOrganizationOptions] with the given params"
  [name, domains]
  (->
   (OrganizationsApi$CreateOrganizationOptions/builder)
   (.name name)
   (.domains domains)
   (.build)))

(defn create-organization
  "Parameters for [createOrganization]
   Use `CreateOrganizationOptions.builder()` to create a new builder instance"
  [workos, name, domains]
  (.createOrganization (.-organizations workos) (builder name domains)))
