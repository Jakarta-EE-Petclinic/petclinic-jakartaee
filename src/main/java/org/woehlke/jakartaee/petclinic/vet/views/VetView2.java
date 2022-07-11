package org.woehlke.jakartaee.petclinic.vet.views;

import org.primefaces.model.DualListModel;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageSelectorView;
import org.woehlke.jakartaee.petclinic.application.framework.has.SearchView;
import org.woehlke.jakartaee.petclinic.application.framework.has.View2Model;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import java.io.Serializable;


/**
 *
 */
public interface VetView2 extends CrudView<Vet>,
        LanguageSelectorView,
        SearchView,
        View2Model,
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
