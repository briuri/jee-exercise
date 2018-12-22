#!/bin/bash
wget http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.zip
cd /opt
sudo unzip ~/wildfly-10.1.0.Final.zip
sudo ln -fs wildfly-10.1.0.Final wildfly
