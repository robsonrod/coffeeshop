(ns coffeeshop.core
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [clojure.tools.namespace.repl :refer [refresh]]))

(defn respond-hello [request]
  {:status 200
   :body "Hello, Coffee Shop"})

(def routes
  #{["/hello" :get `respond-hello]})

(def service-map {::http/routes routes
                  ::http/port 8800
                  ::http/type :jetty})

(defonce server (atom nil))

(defn go []
  (reset! server
          (http/start
           (http/create-server
            (assoc service-map
                   ::http/join? false))))
  (prn "Server started on localhost:8800")
  (prn "Enter (reset) to reload")
  :started)

(defn halt []
  (http/stop @server))

(defn reset []
  (halt)
  (refresh :after 'dealer-api.core/go))
