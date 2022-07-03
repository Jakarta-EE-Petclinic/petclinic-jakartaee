# ToDo

## Search
* There is no Hibernate in OpenLiberty: Therefore there is no HibernateSearch useful.

## Learn more about OpenLiberty
* https://openliberty.io/blog/2018/06/29/full_java_ee_8_liberty_18002.html

## Learn more about OpenLiberty and Spring
* https://openliberty.io/blog/2018/06/29/full_java_ee_8_liberty_18002.html#spring

## Issues

### 13
* [Issuse 13 Remove Hibernate Search and build another Search Solution for wlp](https://github.com/Jakarta-EE-Petclinic/jakartaee-petclinic/issues/13)
* [branch 13_Remove_Hibernate_Search](https://github.com/Jakarta-EE-Petclinic/jakartaee-petclinic/tree/13_Remove_Hibernate_Search)
#### Strategy: Hibernate JPA in Liberty?
* https://developer.ibm.com/answers/questions/200704/hibernate-and-jpa-21-in-liberty-8556/
* https://openliberty.io/docs/ref/feature/
* https://www.ibm.com/support/knowledgecenter/SSAW57_liberty/com.ibm.websphere.wlp.nd.multiplatform.doc/ae/rwlp_feat.html
* https://openliberty.io/blog/2018/06/29/full_java_ee_8_liberty_18002.html
#### Strategy: Remove Hibernate Search and build another Search Solution for wlp


# 30.03.2020
Fixed #17, Fixed #21, Fixed #25, Fixed #26, Fixed #28, Fixed #29, Fixed #30

# 21.03.2020
## [Update PrimeFaces JSF to Version 8.0 #14](https://github.com/Jakarta-EE-Petclinic/jakartaee-petclinic/issues/14)
### changend dependencies:
- [ ] PrimeFaces » 8.0            (Mar 05, 2020)
- [ ] PrimeFaces Extensions - 8.0 (Mar 05, 2020)
````
<!-- https://mvnrepository.com/artifact/org.primefaces/primefaces -->
<dependency>
    <groupId>org.primefaces</groupId>
    <artifactId>primefaces</artifactId>
    <version>8.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.primefaces.extensions/primefaces-extensions -->
<dependency>
    <groupId>org.primefaces.extensions</groupId>
    <artifactId>primefaces-extensions</artifactId>
    <version>8.0</version>
</dependency>
````
### new  dependencies:

- [ ] PrimeFaces Extensions Master POM » 8.0
- [ ] PrimeFaces Extensions Resources CKEditor » 8.0
````
<!-- https://mvnrepository.com/artifact/org.primefaces.extensions/master-pom -->
<dependency>
    <groupId>org.primefaces.extensions</groupId>
    <artifactId>master-pom</artifactId>
    <version>8.0</version>
    <type>pom</type>
</dependency>
<!-- https://mvnrepository.com/artifact/org.primefaces.extensions/resources-ckeditor -->
<dependency>
    <groupId>org.primefaces.extensions</groupId>
    <artifactId>resources-ckeditor</artifactId>
    <version>8.0</version>
    <scope>runtime</scope>
</dependency>
````

### DevOps
* Maven Artifactory Plugin: https://www.jfrog.com/confluence/display/JFROG/Maven+Artifactory+Plugin

### Issues
# Fixed #37
# Fixed #39, Fixed #35

### Technology
* https://jakarta.ee/specifications/platform/9.1/jakarta-platform-spec-9.1.html
* https://jakarta.ee/specifications/security/2.0/
* https://jakarta.ee/specifications/platform/9.1/
* https://openliberty.io/docs/latest/jakarta-ee9-feature-updates.html