(ns coffeeshop.beans
(:require [coffeeshop.sql.beans :as sql]
          [coffeeshop.config :refer [db]]
          [io.pedestal.http :as http]))

(defn all-beans [_]
  (http/json-response (sql/beans db)))
