Camel Hibernate JPA: Camel with JPA consumer
=====================================================================
Author: Elkin Munoz

Technologies: Fuse, OSGi, Camel, Hibernate, Blueprint, Aries Auto Enlist XA Transactions

Product: Fuse 6.3

Breakdown
---------
This code example demonstrates how to create a JPA consumer in blueprint, manage 2nd level cache and enable it in the fuse container.

For more information see:

* <https://access.redhat.com/site/documentation/JBoss_Fuse/> for more information about using JBoss Fuse
* https://access.redhat.com/solutions/960843 Ehcache Second Level Cache working on JBoss Fuse
* https://access.redhat.com/solutions/2759411 Ehcache Second Level Cache working on JBoss Fuse

System Requirements
-------------------
Before building and running this project you need:

* Maven 3.2 or higher
* JDK 1.7 or 1.8
* JBoss Fuse 6.3
* Custom vendor database (Oracle was used in this example)

Build and Deploy
----------------

1) clone this project

	git clone https://github.com/emunozd/hibernate-jpa.git

2) change to project directory 

	cd fuse-camel-hibernate-jpa

3) update your database configuration

	vi hibernate-jpa/datasource.xml

4) build

	mvn clean install

5) start JBoss Fuse 6.3

	./bin/fuse

6) start Oracle database (refer to vendor documentation if you need to do this, for easy testing I recommend using Oracle XE)

7) deploy Oracle JDBC driver

Download the latest driver from Oracle and install it to your local maven repository (account required):

	mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=12.1.0.1 -Dpackaging=jar

8) install features

	features:install camel-jpa
  features:install jndi
  features:install jpa
  features:install hibernate
  features:install cxf

8) install Oracle library

  osgi:install -s wrap:mvn:com.oracle/ojdbc6/12.1.0.1

Usage
-----

1) Copy the hibernate-jpa/datasource.xml file to the deployment/ folder in the JBoss Fuse 6.3
2) install project binary in JBoss Fuse 6.3

  osgi:install mvn:com.redhat.example.fuse/hibernate-jpa/0.0.1-SNAPSHOT
  start <bundle-id>

3) check log entries with:

  log:tail -n 50

-------------------

Done.
