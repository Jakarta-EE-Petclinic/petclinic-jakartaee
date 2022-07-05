# petclinic-jakartaee
Petclinic Jakarta EE - a JSF and Jakarta EE 9.1 Version of Spring Petclinic. 

And Update from Java EE 7 Petclinic

## What is this?
* JSF and Jakarta EE 9.1 Version of [Spring Petclinic](https://github.com/spring-projects/spring-petclinic)
* This is an Update of [Java EE 7 Petclinic](https://jakarta-ee-petclinic.github.io/petclinic-javaee7/)

## Where is it?
* Github: [https://github.com/Jakarta-EE-Petclinic/petclinic-jakartaee](https://github.com/Jakarta-EE-Petclinic/petclinic-jakartaee)
* Demo on OpenShift: [http://jakartaee8petclinic.rhcloud.com/](http://jakartaee8petclinic.rhcloud.com)
* Blog: [https://thomas-woehlke.blogspot.com/2014/02/java-ee-7-petclinic.html](https://thomas-woehlke.blogspot.com/2014/02/java-ee-7-petclinic.html)

## Motivation
* Some experimental Work with JSF, Jakarta EE 9.1 and Java EE 
* These Demo Application is planned to be the first in a series of “Rosetta Stone” to compare OOP Web Application Frameworks

## Why Petclinic?
* The Domain Classes show all relationships like one-to-many (1:n), many-to-one (n:1) and many-to-many (n:m)
* It is simple enough but yet it shows more than just the CRUD Use Cases (Create, Read, Update, Delete) of most Demos and Training Examples.
* You can think of it as smallest complete Web App with the usual things to solve.

## Spring Petclinic
* Github: [https://github.com/spring-projects/spring-petclinic](https://github.com/spring-projects/spring-petclinic)

## Software Design

* [Requirements Engineering (OOA,OOD,UML)](https://jakarta-ee-petclinic.github.io/petclinic-uml/)


### Petclinic Domain Class Modell
![Figure Domain Class Modell](uml/Petclinic__Domain_Class_Modell-Petclinic_Domain_Class_Modell.png)

### Petclinic Use Case Diagram

![Figure Uses Cases Petclinic](uml/Petclinic__Use_Cases-Petclinic_Use_Case_Diagram.png)


## PetType

### PetType Use Case Diagram

![Figure Uses Case PetType](uml/owner/concept/PetType__UseCase-PetType_Use_Case_Diagram.png)

### PetType State Diagram

| PetType States   | PetType Use Cases          | Frontend                                                |
|------------------|----------------------------|---------------------------------------------------------|
| PetType.list *   | PETTYPE_LIST_EMPTY         | Disable Edit-, Delete-, Search-Button and Paging-Widget |
| PetType.list *   | PETTYPE_LIST               |                                                         |
| PetType.search * | PETTYPE_LIST_SEARCH_RESULT |                                                         |
| PetType.addNew   | PETTYPE_NEW                |                                                         |
| PetType.edit     | PETTYPE_EDIT               |                                                         |
| PetType.delete   | PETTYPE_DELETE             |                                                         |
| PetType.list     | PETTYPE_LIST2 *            |                                                         |
| PetType.list     | PETTYPE_LIST3 *            |                                                         |
| PetType.list     | PETTYPE_LIST4 *            |                                                         |

*) TODO

![Figure Uses Cases PetType](uml/owner/concept/PetType__State-PetType_State_Diagram.png)

| PetType Use Cases | Actions                              | Frontend to View              | View to Backend (DB) | outcome             | precondition                   | postcondition                                |
|-------------------|--------------------------------------|-------------------------------|----------------------|---------------------|--------------------------------|----------------------------------------------|
| Use Case          | Actions                              | Frontend to View              | View to Backend (DB) | outcome             | precondition                   | postcondition                                |
| Use Case          | Actions                              | Frontend to View              | View to Backend (DB) | outcome             | precondition                   | postcondition                                |
| Use Case          | Actions                              | Frontend to View              | View to Backend (DB) | outcome             | precondition                   | postcondition                                |
| Use Case          | Actions                              | Frontend to View              | View to Backend (DB) | outcome             | precondition                   | postcondition                                |
| PetType.addNew    | PetTypeView.button_addNew_dialog()   | x                             |                      | change state        | PETTYPE_LIST                   | PETTYPE_NEW                                  |
| PetType.addNew    | PetTypeView.button_cancel_and_back() | x                             |                      | change state        | PETTYPE_NEW                    | PETTYPE_LIST                                 |
| PetType.addNew    | PetTypeView.button_addNew_perform()  | x, calls: PetType.db_addNew() |                      | if OK: change state | PETTYPE_NEW                    | PETTYPE_LIST                                 |
| PetType.addNew    | PetTypeView.db_addNew()              |                               | x                    | OK                  | length(list(PetType)) = n      | length(list(PetType)) = n+1                  |
| PetType.addNew    | PetTypeView.db_addNew()              |                               | x                    | not OK, invalid     | length(list(PetType)) = n      | display cause as flash message               |
| PetType.edit      | PetTypeView.button_edit_dialog()     | x                             |                      | change state        | PETTYPE_LIST                   | PETTYPE_EDIT                                 |
| PetType.edit      | PetTypeView.button_cancel_and_back() | x                             |                      | change state        | PETTYPE_EDIT                   | PETTYPE_LIST                                 |
| PetType.edit      | PetTypeView.button_update_perform()  | x, calls: PetType.db_update() |                      | if OK: change state | PETTYPE_EDIT                   | PETTYPE_LIST                                 |
| PetType.edit      | PetTypeView.db_update()              |                               | x                    | OK                  | length(list(PetType)) = n > 0  | length(list(PetType)) = n; 1 element changed |
| PetType.edit      | PetTypeView.db_update()              |                               | x                    | not OK, invalid     | length(list(PetType)) = n >= 0 | display cause as flash message               |
| PetType.delete    | PetTypeView.button_delete_dialog()   | x                             |                      | change state        | PETTYPE_LIST                   | PETTYPE_DELETE                               |
| PetType.delete    | PetTypeView.button_cancel_and_back() | x                             |                      | change state        | PETTYPE_DELETE                 | PETTYPE_LIST                                 |
| PetType.delete    | PetTypeView.button_delete_perform()  | x, calls: PetType.db_delete() |                      | if OK: change state | PETTYPE_DELETE                 | PETTYPE_LIST                                 |
| PetType.delete    | PetTypeView.db_delete()              |                               | x                    | OK                  | length(list(PetType)) = n > 0  | length(list(PetType)) = n-1                  |
| PetType.delete    | PetTypeView.db_delete()              |                               | x                    | not OK, invalid     | length(list(PetType)) = n >= 0 | display cause as flash message               |

![Figure PetTypeView](uml/owner/implementation/View__Class-OwnerView_Class_Diagram.png)


## Specialty

### Specialty Use Case Diagram

![Figure Uses Case Specialty](uml/vet/concept/Specialty__UseCase-Specialty_Use_Case_Diagram.png)

### Specialty State Diagram

| Specialty Use Cases | Specialty States             | Frontend                                                |
|---------------------|------------------------------|---------------------------------------------------------|
| Specialty.list *    | SPECIALTY_LIST_EMPTY         | Disable Edit-, Delete-, Search-Button and Paging-Widget |
| Specialty.list *    | SPECIALTY_LIST               |                                                         |
| Specialty.search *  | SPECIALTY_LIST_SEARCH_RESULT |                                                         |
| Specialty.addNew    | SPECIALTY_NEW                |                                                         |
| Specialty.edit      | SPECIALTY_EDIT               |                                                         |
| Specialty.delete    | SPECIALTY_DELETE             |                                                         | 
| Specialty.list      | SPECIALTY_LIST2 *            |                                                         |
| Specialty.list      | SPECIALTY_LIST3 *            |                                                         |
| Specialty.list      | SPECIALTY_LIST4 *            |                                                         |

*) TODO

![Figure Uses Cases Specialty](uml/vet/concept/Specialty__UseCase__State-Specialty_State_Diagram.png)

| Specialty Use Cases | Actions                                | Frontend to View                | View to Backend (DB) | outcome             | precondition                     | postcondition                                  |
|---------------------|----------------------------------------|---------------------------------|----------------------|---------------------|----------------------------------|------------------------------------------------|
| Use Case            | Actions                                | Frontend to View                | View to Backend (DB) | outcome             | precondition                     | postcondition                                  |
| Use Case            | Actions                                | Frontend to View                | View to Backend (DB) | outcome             | precondition                     | postcondition                                  |
| Use Case            | Actions                                | Frontend to View                | View to Backend (DB) | outcome             | precondition                     | postcondition                                  |
| Use Case            | Actions                                | Frontend to View                | View to Backend (DB) | outcome             | precondition                     | postcondition                                  |
| Specialty.addNew    | SpecialtyView.button_addNew_dialog()   | x                               |                      | change state        | SPECIALTY_LIST                   | SPECIALTY_NEW                                  |
| Specialty.addNew    | SpecialtyView.button_cancel_and_back() | x                               |                      | change state        | SPECIALTY_NEW                    | SPECIALTY_LIST                                 |
| Specialty.addNew    | SpecialtyView.button_addNew_perform()  | x, calls: Specialty.db_addNew() |                      | if OK: change state | SPECIALTY_NEW                    | SPECIALTY_LIST                                 |
| Specialty.addNew    | SpecialtyView.db_addNew()              |                                 | x                    | OK                  | length(list(Specialty)) = n      | length(list(Specialty)) = n+1                  |
| Specialty.addNew    | SpecialtyView.db_addNew()              |                                 | x                    | not OK, invalid     | length(list(Specialty)) = n      | display cause as flash message                 |
| Specialty.edit      | SpecialtyView.button_edit_dialog()     | x                               |                      | change state        | SPECIALTY_LIST                   | SPECIALTY_EDIT                                 |
| Specialty.edit      | SpecialtyView.button_cancel_and_back() | x                               |                      | change state        | SPECIALTY_EDIT                   | SPECIALTY_LIST                                 |
| Specialty.edit      | SpecialtyView.button_update_perform()  | x, calls: Specialty.db_update() |                      | if OK: change state | SPECIALTY_EDIT                   | SPECIALTY_LIST                                 |
| Specialty.edit      | SpecialtyView.db_update()              |                                 | x                    | OK                  | length(list(Specialty)) = n > 0  | length(list(Specialty)) = n; 1 element changed |
| Specialty.edit      | SpecialtyView.db_update()              |                                 | x                    | not OK, invalid     | length(list(Specialty)) = n >= 0 | display cause as flash message                 |
| Specialty.delete    | SpecialtyView.button_delete_dialog()   | x                               |                      | change state        | SPECIALTY_LIST                   | SPECIALTY_DELETE                               |
| Specialty.delete    | SpecialtyView.button_cancel_and_back() | x                               |                      | change state        | SPECIALTY_DELETE                 | SPECIALTY_LIST                                 |
| Specialty.delete    | SpecialtyView.button_delete_perform()  | x, calls: Specialty.db_delete() |                      | if OK: change state | SPECIALTY_DELETE                 | SPECIALTY_LIST                                 |
| Specialty.delete    | SpecialtyView.db_delete()              |                                 | x                    | OK                  | length(list(Specialty)) = n > 0  | length(list(Specialty)) = n-1                  |
| Specialty.delete    | SpecialtyView.db_delete()              |                                 | x                    | not OK, invalid     | length(list(Specialty)) = n >= 0 | display cause as flash message                 |

### SpecialtyViw Class
![Figure Class SpecialtyView](uml/vet/implementation/View__Class-VetView_and_SpecialtyView_Class_Diagram.png)

## Vetinarian

### Vetinarian Use Case Diagram

![Figure Uses Cases Vet](uml/vet/concept/Vet__UseCase-Vetinarian_Use_Case_Diagram.png)

### Vetinarian State Diagram

| Use Case     | Vetinarian States      | Frontend                                                |
|--------------|------------------------|---------------------------------------------------------|
| Vet.list *   | VET_LIST_EMPTY         | Disable Edit-, Delete-, Search-Button and Paging-Widget |
| Vet.list *   | VET_LIST               |                                                         |
| Vet.search * | VET_LIST_SEARCH_RESULT |                                                         |
| Vet.addNew   | VET_NEW                |                                                         |
| Vet.edit     | VET_EDIT               |                                                         |
| Vet.delete   | VET_DELETE             |                                                         |   
| Vet.list     | VET_LIST2 *            |                                                         |
| Vet.list     | VET_LIST3 *            |                                                         |
| Vet.list     | VET_LIST4 *            |                                                         |

*) TODO

![Figure Vetinarian_State_Diagram](uml/vet/concept/Vet__UseCase__State-Vetinarian_State_Diagram.png)

| Use Case    | Actions                           | Frontend to View                 | View to Backend (DB) | outcome             | precondition                      | postcondition                                   |
|-------------|-----------------------------------|----------------------------------|----------------------|---------------------|-----------------------------------|-------------------------------------------------|
| Use Case    | Actions                           | Frontend to View                 | View to Backend (DB) | outcome             | precondition                      | postcondition                                   |
| Use Case    | Actions                           | Frontend to View                 | View to Backend (DB) | outcome             | precondition                      | postcondition                                   |
| Use Case    | Actions                           | Frontend to View                 | View to Backend (DB) | outcome             | precondition                      | postcondition                                   |
| Use Case    | Actions                           | Frontend to View                 | View to Backend (DB) | outcome             | precondition                      | postcondition                                   |
| Vet.addNew  | VetView.button_addNew_dialog()    | x                                |                      | change state        | VET_LIST                          | VET_NEW                                         |
| Vet.addNew  | VetView.button_cancel_and_back()  | x                                |                      | change state        | VET_NEW                           | VET_LIST                                        |
| Vet.addNew  | VetView.button_addNew_perform()   | x, calls: Vetinarian.db_addNew() |                      | if OK: change state | VET_NEW                           | VET_LIST                                        |
| Vet.addNew  | VetView.db_addNew()               |                                  | x                    | OK                  | length(list(Vetinarian)) = n      | length(list(Vetinarian)) = n+1                  |
| Vet.addNew  | VetView.db_addNew()               |                                  | x                    | not OK, invalid     | length(list(Vetinarian)) = n      | display cause as flash message                  |
| Vet.edit    | VetView.button_edit_dialog()      | x                                |                      | change state        | VET_LIST                          | VET_EDIT                                        |
| Vet.edit    | VetView.button_cancel_and_back()  | x                                |                      | change state        | VET_EDIT                          | VET_LIST                                        |
| Vet.edit    | VetView.button_update_perform()   | x, calls: Vetinarian.db_update() |                      | if OK: change state | VET_EDIT                          | VET_LIST                                        |
| Vet.edit    | VetView.db_update()               |                                  | x                    | OK                  | length(list(Vetinarian)) = n > 0  | length(list(Vetinarian)) = n; 1 element changed |
| Vet.edit    | VetView.db_update()               |                                  | x                    | not OK, invalid     | length(list(Vetinarian)) = n >= 0 | display cause as flash message                  |
| Vet.delete  | VetView.button_delete_dialog()    | x                                |                      | change state        | VET_LIST                          | VET_DELETE                                      |
| Vet.delete  | VetView.button_cancel_and_back()  | x                                |                      | change state        | VET_DELETE                        | VET_LIST                                        |
| Vet.delete  | VetView.button_delete_perform()   | x, calls: Vetinarian.db_delete() |                      | if OK: change state | VET_DELETE                        | VET_LIST                                        |
| Vet.delete  | VetView.db_delete()               |                                  | x                    | OK                  | length(list(Vetinarian)) = n > 0  | length(list(Vetinarian)) = n-1                  |
| Vet.delete  | VetView.db_delete()               |                                  | x                    | not OK, invalid     | length(list(Vetinarian)) = n >= 0 | display cause as flash message                  |

### VetinarianView Class

![Figure View Class](uml/vet/implementation/View__Class-VetView_and_SpecialtyView_Class_Diagram.png)

### vet.oodm

![Figure DB Class](uml/vet/implementation/DB__Class-vet_oodm_Class_Diagram.png)

## Owner

### Owner Use Cases

![Figure Uses Cases Owner](uml/owner/concept/Owner__UseCases-Owner_Use_Case_Diagram.png)

### Owner State

| Use Case               | Owner States             | Frontend                                                |
|------------------------|--------------------------|---------------------------------------------------------|
| Owner.list *           | OWNER_LIST_EMPTY         | Disable Edit-, Delete-, Search-Button and Paging-Widget |
| Owner.list *           | OWNER_LIST               |                                                         |
| Owner.list *           | OWNER_LIST_SEARCH_RESULT |                                                         |
| Owner.addNew           | OWNER_NEW                |                                                         |  
| Owner.edit             | OWNER_EDIT               |                                                         |  
| Owner.delete           | OWNER_DELETE             |                                                         |   
| Owner.Pet.addNew       | OWNER_PET_NEW            |                                                         |
| Owner.Pet.edit         | OWNER_PET_EDIT           |                                                         |    
| Owner.Pet.delete       | OWNER_PET_DELETE         |                                                         | 
| Owner.Pet.Visit.addNew | OWNER_PET_VISIT_NEW      |                                                         |
| Owner.Pet.Visit.edit   | OWNER_PET_VISIT_EDIT     |                                                         |
| Owner.Pet.Visit.delete | OWNER_PET_VISIT_DELETE   |                                                         |

*) TODO

#### Owner State Diagram

![Figure Uses Cases Owner](uml/owner/concept/Owner__State-Owner_State_Diagram.png)

#### Owner State Diagram without Pet and Visits
![Figure Uses Cases Owner](uml/owner/concept/Owner__State__without_details-Owner_State_Diagram_without_Pet_and_Visits.png)

#### Owner State Diagram of Pet and Visits
![Figure Uses Cases Owner](uml/owner/concept/Owner__State__details-Owner_State_Diagram_of_Pet_and_Visits.png)

| Use Case               | Actions                                  | Frontend to View                  | View to Backend (DB) | outcome             | precondition                  | postcondition                              |
|------------------------|------------------------------------------|-----------------------------------|----------------------|---------------------|-------------------------------|--------------------------------------------|
| Use Case               | Actions                                  | Frontend to View                  | View to Backend (DB) | outcome             | precondition                  | postcondition                              |
| Use Case               | Actions                                  | Frontend to View                  | View to Backend (DB) | outcome             | precondition                  | postcondition                              |
| Use Case               | Actions                                  | Frontend to View                  | View to Backend (DB) | outcome             | precondition                  | postcondition                              |
| Use Case               | Actions                                  | Frontend to View                  | View to Backend (DB) | outcome             | precondition                  | postcondition                              |
| Owner.addNew           | OwnerView.button_owner_addNew_dialog()   | x                                 |                      | change state        | OWNER_LIST                    | OWNER_NEW                                  |
| Owner.addNew           | OwnerView.button_owner_cancel_and_back() | x                                 |                      | change state        | OWNER_NEW                     | OWNER_LIST                                 |
| Owner.addNew           | OwnerView.button_owner_addNew_perform()  | x, calls: Owner.db_owner_addNew() |                      | if OK: change state | OWNER_NEW                     | OWNER_LIST                                 |
| Owner.addNew           | OwnerView.db_owner_addNew()              |                                   | x                    | OK                  | length(list(Owner)) = n       | length(list(Owner)) = n+1                  |
| Owner.addNew           | OwnerView.db_owner_addNew()              |                                   | x                    | not OK, invalid     | length(list(Owner)) = n       | display cause as flash message             |
| Owner.details          | OwnerView.button_owner_details_dialog()  | x                                 |                      | change state        | OWNER_LIST                    | OWNER_DETAILS                              |
| Owner.details          | OwnerView.button_owner_back_to_list()    | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_LIST                                 |
| Owner.edit             | OwnerView.button_owner_edit_dialog()     | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_EDIT                                 |
| Owner.edit             | OwnerView.button_owner_cancel_and_back() | x                                 |                      | change state        | OWNER_EDIT                    | OWNER_DETAILS                              |
| Owner.edit             | OwnerView.button_owner_update_perform()  | x, calls: Owner.db_owner_update() |                      | if OK: change state | OWNER_EDIT                    | OWNER_DETAILS                              |
| Owner.edit             | OwnerView.db_owner_update()              |                                   | x                    | OK                  | length(list(Owner)) = n > 0   | length(list(Owner)) = n; 1 element changed |
| Owner.edit             | OwnerView.db_owner_update()              |                                   | x                    | not OK, invalid     | length(list(Owner)) = n >= 0  | display cause as flash message             |
| Owner.delete           | OwnerView.button_owner_delete_dialog()   | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_DELETE                               |
| Owner.delete           | OwnerView.button_owner_cancel_and_back() | x                                 |                      | change state        | OWNER_DELETE                  | OWNER_DETAILS                              |
| Owner.delete           | OwnerView.button_owner_delete_perform()  | x, calls: Owner.db_owner_delete() |                      | if OK: change state | OWNER_DELETE                  | OWNER_DETAILS                              |
| Owner.delete           | OwnerView.db_owner_delete()              |                                   | x                    | OK                  | length(list(Owner)) = n > 0   | length(list(Owner)) = n-1                  |
| Owner.delete           | OwnerView.db_owner_delete()              |                                   | x                    | not OK, invalid     | length(list(Owner)) = n >= 0  | display cause as flash message             |
| Owner.Pet.addNew       | OwnerView.button_pet_addNew_dialog()     | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_PET_NEW                              |
| Owner.Pet.addNew       | OwnerView.button_pet_addNew_perform()    | x, calls: Owner.db_pet_addNew()   |                      | change state        | OWNER_PET_NEW                 | OWNER_DETAILS                              |
| Owner.Pet.addNew       | OwnerView.db_pet_addNew()                |                                   | x                    | OK                  | length(list(Pet)) = n         | length(list(Pet)) = n+1                    |
| Owner.Pet.addNew       | OwnerView.db_pet_addNew()                |                                   | x                    | not OK, invalid     | length(list(Pet)) = n         | display cause as flash message             |
| Owner.Pet.edit         | OwnerView.button_pet_edit_dialog()       | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_PET_EDIT                             |
| Owner.Pet.edit         | OwnerView.button_pet_update_perform()    | x, calls: Owner.db_pet_update()   |                      | change state        | OWNER_PET_EDIT                | OWNER_DETAILS                              |
| Owner.Pet.edit         | OwnerView.db_pet_update()                |                                   | x                    | OK                  | length(list(Pet)) = n         | length(list(Pet)) = n; 1 element changed   |
| Owner.Pet.edit         | OwnerView.db_pet_update()                |                                   | x                    | not OK, invalid     | length(list(Pet)) = n         | display cause as flash message             |
| Owner.Pet.delete       | OwnerView.button_pet_delete_dialog()     | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_PET_DELETE                           |
| Owner.Pet.delete       | OwnerView.button_pet_delete_perform()    | x, calls: Owner.db_pet_delete()   |                      | change state        | OWNER_PET_DELETE              | OWNER_DETAILS                              |
| Owner.Pet.delete       | OwnerView.db_pet_delete()                |                                   | x                    | OK                  | length(list(Pet)) = n > 0     | length(list(Pet)) = n-1                    |
| Owner.Pet.delete       | OwnerView.db_pet_delete()                |                                   | x                    | not OK, invalid     | length(list(Pet)) = n >= 0    | display cause as flash message             |
| Owner.Pet.Visit.addNew | OwnerView.button_visit_addNew_dialog()   | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_PET_VISIT_NEW                        |
| Owner.Pet.Visit.addNew | OwnerView.button_visit_addNew_perform()  | x, calls: Owner.db_visit_addNew() |                      | change state        | OWNER_PET_VISIT_NEW           | OWNER_DETAILS                              |
| Owner.Pet.Visit.addNew | OwnerView.db_visit_addNew()              |                                   | x                    | OK                  | length(list(Visit)) = n       | length(list(Visit)) = n+1                  |
| Owner.Pet.Visit.addNew | OwnerView.db_visit_addNew()              |                                   | x                    | not OK, invalid     | length(list(Visit)) = n       | display cause as flash message             |
| Owner.Pet.Visit.edit   | OwnerView.button_visit_edit_dialog()     | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_PET_VISIT_EDIT                       |
| Owner.Pet.Visit.edit   | OwnerView.button_visit_update_perform()  | x, calls: Owner.db_visit_update() |                      | change state        | OWNER_PET_VISIT_EDIT          | OWNER_DETAILS                              |
| Owner.Pet.Visit.edit   | OwnerView.db_visit_update()              |                                   | x                    | OK                  | length(list(Visit)) = n       | length(list(Visit)) = n; 1 element changed |
| Owner.Pet.Visit.edit   | OwnerView.db_visit_update()              |                                   | x                    | not OK, invalid     | length(list(Visit)) = n       | display cause as flash message             |
| Owner.Pet.Visit.delete | OwnerView.button_visit_delete_dialog()   | x                                 |                      | change state        | OWNER_DETAILS                 | OWNER_PET_VISIT_DELETE                     |
| Owner.Pet.Visit.delete | OwnerView.button_visit_delete_perform()  | x, calls: Owner.db_visit_delete() |                      | change state        | OWNER_PET_VISIT_DELETE        | OWNER_DETAILS                              |
| Owner.Pet.Visit.delete | OwnerView.db_visit_delete()              |                                   | x                    | OK                  | length(list(Visit)) = n > 0   | length(list(Visit)) = n-1                  |
| Owner.Pet.Visit.delete | OwnerView.db_visit_delete()              |                                   | x                    | not OK, invalid     | length(list(Visit)) = n >= 0  | display cause as flash message             |

### OwnerView Class

![Figure View Class](uml/vet/implementation/View__Class-VetView_and_SpecialtyView_Class_Diagram.png)

### owner.oodm

![Figure DB Class](uml/owner/implementation/DB__class-owner_oodm_Class_Diagram.png)


## User: First Steps to do
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

## Imprint
* [(c) 2022 Thomas Woehlke](https://github.com/thomaswoehlke)
* [This Document](https://jakarta-ee-petclinic.github.io/petclinic-jakartaee/)
* [github repository](https://github.com/Jakarta-EE-Petclinic/petclinic-jakartaee)
