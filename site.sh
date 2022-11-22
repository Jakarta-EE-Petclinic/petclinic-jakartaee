#!/usr/bin/env bash

./mvnw -Parq-wildfly-managed -Pwildfly -Ppayara -Pglassfish -Pliberty -Ptomee -Puml -Pwar -Pdocker-glassfish -Pdocker-liberty -Pdocker-wildfly site site:deploy