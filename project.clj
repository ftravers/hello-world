(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.clojure/core.async "0.2.374"]
                 [reagent "0.5.0"]]

  :profiles {:dev
             {:dependencies
              [[figwheel-sidecar "0.5.0-2"]
               [org.clojure/tools.nrepl "0.2.12"]
               [com.cemerick/piggieback "0.2.1"]]
              :source-paths ["src" "dev"]}
             :repl { :plugins [[cider/cider-nrepl "0.11.0-SNAPSHOT"]] }
             }
  
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-2"]]
  
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel true
                :compiler {:main hello-world.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/hello_world.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/hello_world.js"
                           :main hello-world.core
                           :optimizations :advanced
                           :pretty-print false}}]}

  :figwheel {             :css-dirs ["resources/public/css"] ;; watch and update CSS
             ;; :nrepl-port 7888
             })
