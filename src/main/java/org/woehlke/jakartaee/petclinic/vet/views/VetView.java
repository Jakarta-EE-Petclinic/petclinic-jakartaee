package org.woehlke.jakartaee.petclinic.vet.views;

import org.primefaces.model.DualListModel;
import org.woehlke.jakartaee.petclinic.application.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasLanguage;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasSearch;
import org.woehlke.jakartaee.petclinic.application.framework.has.HasViewModelOperations;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import java.io.Serializable;


/**
 *
 */
public interface VetView extends CrudView<Vet>,
        HasLanguage,
        HasSearch,
        HasViewModelOperations,
        Serializable {

    long serialVersionUID = -4141782100256382881L;

    /**
     * @param name
     * @return specialty
     */
    Specialty findSpecialtyByName(String name);

    /**
     * @return specialtiesPickList
     */
    DualListModel<Specialty> getSpecialtiesPickList();

    /**
     * @param specialtiesPickList
     */
    void setSpecialtiesPickList(DualListModel<Specialty> specialtiesPickList);
}
