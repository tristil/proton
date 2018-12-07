(ns proton.layers.lang.crystal.core
  (:require [proton.lib.helpers :as helpers])
  (:use [proton.layers.base :only [init-layer! get-initial-config get-packages describe-mode register-layer-dependencies]]))

(defmethod init-layer! :lang/crystal
  [_ {:keys [config layers]}]
  (helpers/console! "init" :lang/crystal)
  (register-layer-dependencies :tools/linter [:linter-crystal :linter-rubocop]))

(defmethod get-initial-config :lang/crystal []
  [["crystal-linter.crystalExecutablePath" "/usr/bin/crystal"]])

(defmethod get-packages :lang/crystal []
    [:language-crystal-actual
     :crystal-block])

(defmethod describe-mode :lang/crystal
 []
 {:mode-name :crystal
  :atom-scope ["source.crystal"]
  :mode-keybindings
    {:t {:category "test"
         :t {:action "crystal-test:toggle"
             :title "toggle panel"}}}})
