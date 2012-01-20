# Swagger Play Framework Sample App

## Overview
This is a project to illustrate use of swagger plugin on play-framework.


### Prerequisites
You need the following installed and available in your $PATH:

<li>- Play Framework 1.2.4

<li>- Scala Plugin (play install scala)

<li>- Swagger Core pre-release version

<li>- Swagger Play Framework Plugin https://github.com/wordnik/swagger-play

<li>- Scala 2.8.1  (http://www.scala-lang.org)

### To build
Clone swagger-play from https://github.com/wordnik/swagger-play and build it using instructions in the README.md file

In swagger-play-sample-app, edit conf/dependencies.yml and update the line below to point to your locally 
cloned (and built) swagger-play.  Note!  This needs to be an absolute path!
<pre>
artifact:   "/path/to/swagger-play"
</pre>

Build and run swagger-play-sample-app:
<pre>
play install scala
play deps
play run
</pre>

### Take Swagger UI for a spin
If you hit http://localhost:9000 you should see swagger-ui (https://github.com/wordnik/swagger-ui) come up for the sample app


### Test API Listing directly
Open a browser window and confirm you can see API listing by hitting the following URLs

<li>- http://localhost:9000/resources.{format} : A list of available resources

<li>- http://localhost:9000/help/user.{format}  : User Resource API and Models

<li>- http://localhost:9000/help/pet.{format}   : Pet Resource API and Models

<li>- http://localhost:9000/help/store.{format} : Store Resource API and Models


