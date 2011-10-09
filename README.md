# Swagger Play Framework Sample App

## Overview
This is a project to illustrate use of swagger plugin on play-framework.


### Prerequisites
You need the following installed and available in your $PATH:

<li>- Play Framework 1.2.3

<li>- Scala Plugin (play install scala)
	
<li>- Swagger Play Framework Plugin https://github.com/wordnik/swagger-play

<li>- Scala 2.8.1  (http://www.scala-lang.org)

### To build
Clone swagger-play from https://github.com/wordnik/swagger-play and build it using
<pre>
play build-module
</pre>

In swagger-play-sample-app, edit conf/dependencies.yml and update the line below to point to the swagger-play
<pre>
artifact:   "/path/to/swagger-play"
</pre>

<pre>
play install scala
play deps
play run
</pre>

