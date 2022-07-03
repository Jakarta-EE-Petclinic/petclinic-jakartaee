# Testing

## TODO: Functional Tests with Selenium2 Webdriver, Arquillian Drone and Graphene ##
Samples are tested on Wildfly and GlassFish using the Aillian ecosystem.
Only one profile can be active at a given time otherwise there will be dependency conflicts.

* ``mvn clean install -Pwildfly-managed``
    This profile  will install a Wildfly server and start up the server.
    Useful for CI servers.

* ``mvn clrquean install -Pwildfly-remote``
    This profile requires you to start up a Wildfly server outside of the build.
    Useful for development to avoid the server start up cost per sample.

* ``mvn clean install -Pglassfish-remote``
    This profile requires you to start up a GlassFish 4 server outside of the build. Each sample will then
    reuse this instance to run the tests.
    Useful for development to avoid the server start up cost per test.

* ``mvn clean install -Pglassfish-managed``
    This profile  will install a Glassfish 4 server and start up the server.
    Useful for development, but has the downside of server startup per Test.
    You have to start a JavaDB (Derby) Server outside of the build before running the Test.

When developing and runing them from IDE, remember to activate the profile before running the test.
To learn more about Arquillian please refer to the [Arquillian Guides](http://arquillian.org/guides/)

