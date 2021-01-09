(ns coffeeshop.sql.beans
  (:require [hugsql.core :as hugsql]))

(hugsql/def-db-fns "coffeeshop/sql/beans.sql")
