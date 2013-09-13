netflixosshc
============

Project to show how to use Netflix OSS at SAP HANA Cloud Platform

Compilation
============
Use Java 7 to compile this code

Build
============
Use 'mvn install' to create a WAR that will be deployed to SAP HANA Cloud

To deploy use the SAP HANA Cloud Client Tool

At deploy directory has a sample properties that I've used to deploy the demo

$neo deploy netflixosshc_war.properties

Sample Output:


SAP HANA Cloud Console Client



Requesting deployment for:

   application           : netflixosshc<br>
   account               : s0004616922trial<br>
   source                : netflixosshc.war<br>
   elasticity data       : [1 .. 1]<br>
   severity              : error<br>
   host                  : https://hanatrial.ondemand.com<br>
   SDK version           : 2.14.26.2<br>
   user                  : s0004616922<br>

Password for your user: 

[Thu Sep 12 22:16:36 BRT 2013] Deployment started...............<br>
[Thu Sep 12 22:17:15 BRT 2013] Deployment finished successfully



Running
=============
If you have a trial account you can't run 2 applications at same time, so I suggest you to run Hystrix-Dashboard on your local machine and the netflixosshc on SAP HANA Cloud

To run Hystrix-Dashboard see this instructions:

Clone https://github.com/Netflix/Hystrix project, after follow this instructions https://github.com/Netflix/Hystrix/tree/master/hystrix-dashboard

After Dashboard is running put the address of hystrix.stream that was deployed on SAP HANA Cloud. 

Example: http://netflixosshcs0004616922trial.hanatrial.ondemand.com/netflixosshc/hystrix.stream (It is without ssl)

 
