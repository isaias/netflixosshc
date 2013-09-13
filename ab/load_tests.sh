#!/bin/sh
#ORDER_DEMO_ADDRESS=http://localhost:8080/NetflixHanaCloud
ORDER_DEMO_ADDRESS=https://netflixosshcs0004616922trial.hanatrial.ondemand.com/netflixosshc
ORDER_DEMO_NUM_REQ=100
ORDER_DEMO_CONC=4
#Success
ab -Tapplication/json -uput_order_success.json -n$ORDER_DEMO_NUM_REQ -c$ORDER_DEMO_CONC $ORDER_DEMO_ADDRESS/rest/OrderConfirmation&
ab -Tapplication/json -uput_order_success_1.json -n$ORDER_DEMO_NUM_REQ -c$ORDER_DEMO_CONC $ORDER_DEMO_ADDRESS/rest/OrderConfirmation&
ab -Tapplication/json -uput_order_success_2.json -n$ORDER_DEMO_NUM_REQ -c$ORDER_DEMO_CONC $ORDER_DEMO_ADDRESS/rest/OrderConfirmation&
ab -Tapplication/json -uput_order_success_3.json -n$ORDER_DEMO_NUM_REQ -c$ORDER_DEMO_CONC $ORDER_DEMO_ADDRESS/rest/OrderConfirmation&


#Timeout on GetUserInformation

ab -Tapplication/json -uput_order_timeout_user.json -n$ORDER_DEMO_NUM_REQ -c$ORDER_DEMO_CONC $ORDER_DEMO_ADDRESS/rest/OrderConfirmation&

