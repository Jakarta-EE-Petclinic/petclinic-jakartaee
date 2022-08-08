#!/usr/bin/env bash

MY_MVN="./mvnw"

function dockerUp() {
    $MY_MVN docker-compose:up
}

function dockerDown() {
    $MY_MVN docker-compose:down
}

function doSetup() {

    $MY_MVN dependency:purge-local-repository clean dependency:resolve dependency:resolve-plugins dependency:tree dependency:sources dependency:analyze-dep-mgt dependency:analyze-report install
    $MY_MVN -Pliberty dependency:purge-local-repository clean dependency:resolve dependency:resolve-plugins dependency:tree dependency:sources dependency:analyze-dep-mgt dependency:analyze-report install site site:deploy liberty:help
    $MY_MVN -Pwildfly dependency:purge-local-repository clean dependency:resolve dependency:resolve-plugins dependency:tree dependency:sources dependency:analyze-dep-mgt dependency:analyze-report install site site:deploy wildfly:help
    $MY_MVN -glassfish dependency:purge-local-repository clean dependency:resolve dependency:resolve-plugins dependency:tree dependency:sources dependency:analyze-dep-mgt dependency:analyze-report install site site:deploy
    $MY_MVN -Ppayara dependency:purge-local-repository clean dependency:resolve dependency:resolve-plugins dependency:tree dependency:sources dependency:analyze-dep-mgt dependency:analyze-report install site site:deploy
    $MY_MVN -Ptomee dependency:purge-local-repository clean dependency:resolve dependency:resolve-plugins dependency:tree dependency:sources dependency:analyze-dep-mgt dependency:analyze-report install site site:deploy
    $MY_MVN -Parc-wildfly-managed dependency:purge-local-repository clean dependency:resolve dependency:resolve-plugins dependency:tree dependency:sources dependency:analyze-dep-mgt dependency:analyze-report install site site:deploy
}

function doRun() {
		./mvnw -Pliberty
}

function main() {
	doSetup
	#doRun
}

main
