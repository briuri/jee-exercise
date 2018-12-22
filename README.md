# Senior JEE Developer Exercise, 2016-11-04

## Overview

This source code repository contains the artifacts necessary to complete the Senior JEE Developer Exercise.

### Directory Structure
* **exercise-ear**: Eclipse project for overarching EAR.
* **exercise-ejb**: Eclipse project containing CRUD EJBs.
* **exercise-jpa**: Eclipse project containing JPA entities.
* **exercise-rest**: Eclipse project containing web-facing REST API.
* **scripts**: Ad hoc scripts used on the deployment server.

### Demonstration URLs

I did not create a web client, but API can be tested with the RESTClient Firefox Addon.

1. [Method #1: User Add](http://exercise.urizone.net:8080/exercise-rest/api/user/add) (POST, JSON)
  * Sample Body: *{"email": "glenn@exercise.com", "username": "glenn", "password": "QWqw!@12", "roles": [{"name": "Analyst"}], "hobbies": [{"hobby": "tennis"}], "phones": [{"type": "OFFICE", "number": "2345678901"}]}*
2. [Method #2: Phone Delete](http://exercise.urizone.net:8080/exercise-rest/api/phone/delete) (POST, form data)
  * Sample Body: *userId=3&type=OFFICE*
3. [Method #3: Phone Update](http://exercise.urizone.net:8080/exercise-rest/api/phone/update) (POST, form data)
  * Sample Body: *userId=3&type=OFFICE&phone=1234567890*
4. [Method #4: Get Hobbies By User](http://exercise.urizone.net:8080/exercise-rest/api/user/1/hobbies) (GET, path parameter)
5. [Method #5: Get Users](http://exercise.urizone.net:8080/exercise-rest/api/user) (GET, no parameters)

## Development Timeline

This section documents the discrete blocks of time spent working on the exercise and steps through my thought process as if this were a typical software development effort. It includes any technical decisions or assumptions made.

The total time spent on this exercise was **8.25** hours, broken down among the following tasks (learning time is baked in, so real world execution would be faster):

1. Requirements Review (0.5 hours)
2. Environment Setup (1.25 hour)
3. Development (3.75 hour)
6. Deployment and Testing (2.25 hours)
7. Polish (0.5 hours)

## Technical Approach

### Requirements Review (0.5 hours)

1. Reviewed requirements and created 7 step technical approach.
2. Defined Technology Stack (*+=Need to install*).
  * Development Environment: Personal Desktop, Windows 10, JBoss Wildfly 10+, Eclipse IDE for Java EE (Neon)+, JBoss Tools 4.4.1+, Amazon S3 (for storing EARs), GitHub for source control with SourceTree
  * Deployment Server: Amazon EC2, JBoss Wildfly 10+, MySQL 5.7.11 database in Amazon RDS+
3. Assumptions
  * Assume no authentication requirements. Exercise will only remain online for duration of Ron's review. Mitigate security risks by reviewing log files and shutting down afterwards.
  * Assume no password hashing required. A real system would use one-way hashes for security.
  * Assume that user can only have 1 of each type of phone number (e.g. OFFICE, HOME, MOBILE).
  * Assume that REST API will consume JSON for entity mapping and form data for parameter mapping. API will produce JSON.
  * Assume that since Phone endpoints in REST API do not use primary key of phone table, this service is more REST-like or REST-ful than a strict REST service. As such, the pure PUT, POST, GET, DELETE approach will be skipped in favour of the "{entity}/{action}" URL pattern.
  * Assume no validation of email or phone number formats is needed in this iteration. Can enhance with regexp in future.
4. Decisions
  * Create new GitHub account to segregate this exercise from personal profile tied to current company.
  * To demonstrate cloud skills, use Amazon Web Services ecosystem and personal DNS resources to deploy the exercise.
  * Wildfly appserver deployed on an on-demand t2.micro instance running Amazon Linux (a flavor based on Red Hat).
  * MySQL installed as a managed service in Amazon RDS (no replication / backup for this exercise).
  * Push EAR files from dev environment to Amazon S3, where they can be pulled down on the appserver. Manually for this exercise, but could be scripted as an enhancement via Amazon CodeDeploy.
  * Host REST API on exercise.urizone.net so Ron can visit independently (support flextime review).

### Environment Setup (1.25 hours)

1. Configured development environment with missing tools /dependencies.
  * Installed fresh copies of Java EE tools to keep separation from current Java SE tools and mitigate troubleshooting issues. (C:\exercise\eclipse, C:\exercise\wildfly-10.1.0-Final, C:\exercise\workspace)
  * Created new GitHub account and Eclipse projects (exercise-*).
  * Set up Amazon S3 bucket "exercise-app" to hold EAR files ready to build.
2. Configure deployment server with necessary components.
  * Launch EC2 instance, exercise-app, and associated Security Groups, Elastic IP.
  * Install JDK 8, Wildfly 10, and mySQL command line client for testing (00-installJdk8.sh, 01-installWildfly.sh, 02-installMySqlAdmin.sh).
  * Script download of EAR from Amazon S3 bucket (getEar.sh).
3. Configure mySQL database.
  * Set up mySQL in Amazon RDS.
  * Create "exercise" user (03-createExerciseUser.sql).
  * Test connectivity between appserver and mySQL (runMysqlAsMaster.sh, runMysqlAsExercise.sh).
4. Create DNS records for exercise.urizone.net.
  * Test load of default Wildfly page.

### Development: JPA (1 hour)

1. Create 4 tables, and sample data (04-createExerciseTables.sql, 05-loadSampleData.sql).
  * Added sample data via raw SQL to validate table definitions before EJB layer was implemented.
2. Create entity beans and associated detached unit tests.
  * Added mysql connector JAR to JPA project.
  * Generated from tables, then cleaned up manually.
  * Added Bean Validation for field length / null conditions.

### Development: EJB (1 hours)

1. Develop EJBs (and associated unit tests) to provide CRUD functions for 4 tables.
  * Created DAO Interfaces and necessary named queries.
  * Created stateless bean implementations of each interface.
  * Skipped unit tests in this iteration -- need to learn Arquillian.

### Development: REST API (1.75 hours)

1. Develop REST API matching signatures in exercise instructions.
  * Defined interface based on instructions.
  * Wired up REST Annotations.
  * Developed implementation of interface.

### Deployment and Testing (2.25 hours)

1. Configure mySQL datasource in Wildfly.
2. Deploy EAR to local JBoss and perform manual testing of REST API through URL.
  * Troubleshooting: Conflicts between Jackson unmarshalling and Hibernate EAGER fetch behavior.
  * Troubleshooting: CASCADE / OneToMany triggers.
  * Note: POST methods are returning 204 instead of 200. Cannot change this without changing signature of API methods (to set Response status).
3. Deploy EAR to EC2 JBoss and perform manual testing of REST API through URL.
  * Saved Rest API commands for demo purposes.
4. Set up Wildfly as a Linux service.

### Polish (0.5 hours)

1. Copy deployment server ad hoc scripts into version control. Remove passwords for security.
2. Code review, refactoring, polish, final commit.
  * Captured potential enhancements / refactoring opportunities in TODO notes.
3. Open appserver security group to public Internet and email for review.