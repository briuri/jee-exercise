#!/bin/bash
wget http://dev.mysql.com/get/mysql57-community-release-el6-8.noarch.rpm
sudo yum localinstall mysql57-community-release-el6-8.noarch.rpm
sudo yum install mysql
