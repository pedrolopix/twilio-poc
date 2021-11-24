.ONESHELL:
include .env
include .lastsid

dev:
	mvn quarkus:dev

build:
	mvn clean package

new:
	@echo calling ${callto} && \
	SID=$(shell java -jar target/quarkus-app/quarkus-run.jar new ${callto} new.xml)  && \
	echo "SID: $$SID"  && \
	echo "SID=$$SID">.lastsid

update:
	java -jar target/quarkus-app/quarkus-run.jar update ${SID} update.xml
