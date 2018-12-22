#!/bin/bash
aws s3 cp s3://exercise-app/exercise-ear.ear.zip .
cd /opt/wildfly/standalone/deployments
sudo unzip /home/ec2-user/exercise-ear.ear.zip
