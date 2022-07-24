#!/usr/bin/env bash

export POSTGRESQL_HOST=localhost
export POSTGRESQL_PORT=5432
export POSTGRESQL_DATABASE=petclinic_jakartaee_tomee
export POSTGRESQL_USER=petclinic_jakartaee                                                                                                                                                                                                                                                                                                                                                                                                                                                                aee
export POSTGRESQL_PASSWORD=petclinic_jakartaeepwd

#./mvnw -Ptomee-docker docker-compose:up

./mvnw -Ptomee

#./mvnw -Ptomee-docker docker-compose:down
