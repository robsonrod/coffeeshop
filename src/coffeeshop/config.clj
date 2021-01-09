(ns coffeeshop.config)

(def db
{:classname "org.sqlite.JDBC"
 :subprotocol "sqlite"
 :subname "resources/db/beans.db"})
