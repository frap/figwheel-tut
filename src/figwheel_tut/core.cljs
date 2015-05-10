(ns ^:figwheel-always
  figwheel-tut.core
  (:require [sablono.core :as sab]
            [figwheel-tut.components :refer [like-gas]]
            [reagent.core :as reagent :refer [atom]]))

(defonce app-state (atom {:likes 66}))
;;(.log js/console "This is cool! waz sup?!")
;;(enable-console-print!)

;;(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

;;(defonce app-state (atom {:text "Hello world!"}))


(defn render! []
  (.render js/React
           (like-gas app-state)
           (.getElementById js/document "gas")))

(add-watch app-state :on-change (fn [_ _ _ _] (render!)))

;;(render!)

(defn simple-component []
  [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])

(defn render-simple []
  (reagent/render-component [simple-component]
                            (.-body js/document)))

;; (defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
;; )
