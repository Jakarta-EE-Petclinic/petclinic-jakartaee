#!/usr/bin/env bash

./mvnw -Pwildfly -Parq-wildfly-managed -Ppayara -Pliberty -Ptomee site site:deploy