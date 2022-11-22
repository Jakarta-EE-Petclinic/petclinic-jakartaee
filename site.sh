#!/usr/bin/env bash

./mvnw -Parq-wildfly-managed -Pwildfly -Ppayara -Pglassfish -Pliberty -Ptomee -Puml -Pwar -Pdocker.glassfis -Pdocker-liberty -Pdocker-wildfly site site:deploy