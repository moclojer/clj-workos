# clj-workos

Clojure(Script) wrapper for [WorkOS](https://workos.com/), based [workos-kotlin](https://github.com/workos/workos-kotlin)

## example

**envs:**

- WORKOS_API_KEY
- WORKOS_CLIENT_ID
- WORKOS_REDIRECT_URL

```clj
(ns example.core
  (:require [workos.sso :as sso]
            [workos.passwordless :as passwordless]))
  
(sso/send-magic-link "email@moclojer.com")
(passwordless/get-profile-toekn "TOKEN_FROM_MAGIC_LINK")
```
