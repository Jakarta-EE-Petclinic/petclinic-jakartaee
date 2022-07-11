package org.woehlke.jakartaee.petclinic.vet.views;

import org.primefaces.model.DualListModel;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import java.io.Serializable;


/**
 *
 */
public interface VetCrudChangeableView extends CrudChangeableView<Vet>,
        LanguageChangeableView,
        SearchableView,
        CrudView2Model,
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
