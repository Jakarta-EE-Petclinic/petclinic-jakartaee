package org.woehlke.jakartaee.petclinic.vet;

import org.primefaces.model.DualListModel;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView;
import org.woehlke.jakartaee.petclinic.application.framework.views.LanguageChangeableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.SearchableView;
import org.woehlke.jakartaee.petclinic.application.framework.views.CrudView2Model;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.io.Serializable;


/**
 *
 */
public interface VetView extends CrudView<Vet>,
        LanguageChangeableView,
        SearchableView,
        CrudView2Model,
        Serializable {

    String JSF_PAGE = "veterinarian.jsf";

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



    long serialVersionUID = -4141782100256382881L;
}