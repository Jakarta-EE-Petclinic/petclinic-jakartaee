# petclinic-jakartaee
Petclinic Jakarta EE - a JSF and Jakarta EE 9.1 Version of Spring Petclinic. 
And Update from Java EE 7 Petclinic
## What is this?
* JSF and Jakarta EE 9.1 Version of [Spring Petclinic](https://github.com/spring-projects/spring-petclinic)
* This is an Update of [Java EE 7 Petclinic](https://github.com/Jakarta-EE-Petclinic/javaee7-petclinic)
## Where is it?
* Github: [https://github.com/Jakarta-EE-Petclinic/petclinic-jakartaee](https://github.com/Jakarta-EE-Petclinic/petclinic-jakartaee)
* Demo on OpenShift: [http://jakartaee8petclinic.rhcloud.com/](http://jakartaee8petclinic.rhcloud.com)
* Blog: [http://thomas-woehlke.blogspot.de/2018/10/jakarta-ee-8-petclinic.html](http://thomas-woehlke.blogspot.de/2018/10/jakarta-ee-8-petclinic.html)
## Motivation
* Some experimental Work with JSF, Jakarta EE 9.1 and Java EE 
* Comparison between Java EE / Jakarta EE and Spring Frameworks.
## Spring Petclinic
* Github: [https://github.com/spring-projects/spring-petclinic](https://github.com/spring-projects/spring-petclinic)

# Software Design
## Domain Class Modell
![Figure Domain Class Modell](etc/images/DomainClassModell.jpg)
## Use Cases
![Figure Uses Cases Vet](etc/images/UseCases.jpg)
![Figure Uses Cases Owner](etc/images/UseCasesOwner.jpg)
## Page Flow
![Figure Pageflow](etc/images/Pageflow.jpg)
## Screens
### Add Vet with ManyToMany Relation to Specialty
![Figure Add Vet with ManyToMany Relation to Specialty](etc/images/screenAddVet.png)
### New Visit
![Figure New Visit](etc/images/screenNewVisit.png)
### Owner
![Figure Owner](etc/images/screenOwner.png)

## First Steps to use
* add some PetTypes like dog,cat,mouse,...
* add some Specialties for Vetinarians like dentist, anesthetist, radiology,...
* add a Vetinarian
* add an Owner, add him am a Pet and his Pet a visit.

## visit Spring Petclinic
* [https://github.com/spring-projects/spring-petclinic](https://github.com/spring-projects/spring-petclinic)

## More Developer Info
* [Jakarta EE 9.1](etc/docs/JARTKARTA_EE.md)
* [Java jdk and jvm](etc/docs/JAVA_JDK_AND_JVM.md)
* [Java Server Faces JSF](etc/docs/JSF_PRIMEFACES.md)
* [Maven Plugins](etc/docs/MAVEN.md)
## Development
* [Software Design](etc/docs/Software_Design.md)
* [Maven Profiles and Git Branches](etc/docs/PROFILES_AND_BRANCHES.md)
* [ToDo](etc/TODO.md)
* [Testing](etc/docs/TESTING.md)
* [Source on Github](etc/docs/SOURCE.md)
## Jakarta EE Runtimes
* [OpenLiberty](etc/docs/RUNTIME_OPEN_LIBERTY.md)
* [Wildfly](etc/docs/RUNTIME_WILDFLY.md)
* [Glassfish](etc/docs/RUNTIME_GLASSFISH.md)
## Cloud
* [Openshift](etc/docs/CLOUD.md)
