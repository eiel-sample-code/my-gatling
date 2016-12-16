{-# LANGUAGE OverloadedStrings #-}
module Main where

import Network.Wai (responseLBS, Application)
import Network.HTTP.Types (status200)
import Network.Wai.Handler.Warp (run, Port)
import System.Environment (getEnvironment)
import Data.List (lookup)
import Data.Maybe

main :: IO ()
main = do
  putStr "start Server: http://localhost:"
  print "80"
  run 80 helloApp

helloApp :: Application
helloApp req respond = respond $ responseLBS status200 [] "{\"status\": \"success\"}"
