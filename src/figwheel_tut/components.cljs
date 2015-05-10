(ns figwheel-tut.components
  (:require [sablono.core :as sab]))

(defn like-gas [data]
  (sab/html [:div
             [:h1 "Gases popularity dubious: " (:likes @data)]
             [:div [:a {:href "#"
                        :onClick #(swap! data update-in [:likes] inc)}
                    "Thumbs up"]]]))
