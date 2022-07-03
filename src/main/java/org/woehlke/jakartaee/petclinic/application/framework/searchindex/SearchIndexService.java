package org.woehlke.jakartaee.petclinic.application.framework.searchindex;

import java.io.Serializable;

/**
 *
 */
public interface SearchIndexService extends Serializable {

    long serialVersionUID = 3078424024876641283L;

    void resetSearchIndex();
}
