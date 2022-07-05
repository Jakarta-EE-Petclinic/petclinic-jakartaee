package org.woehlke.jakartaee.petclinic.pettype;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBase;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBaseObject;
import org.woehlke.jakartaee.petclinic.pettype.impl.PetTypeListener;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 01.01.14
 * Time: 21:12
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = PetType.TABLENAME,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = PetType.TABLENAME + "_unique_uuid",
                        columnNames = {PetType.COL_UUID}
                ),
                @UniqueConstraint(
                        name = PetType.TABLENAME + "_unique_names",
                        columnNames = {
                                PetType.COL_NAME
                        }
                )
        }
)
@NamedQueries({
        @NamedQuery(
                name = "PetType.getAll",
                query = "select pt from PetType pt order by pt.name"
        )
})
@EntityListeners(PetTypeListener.class)
public class PetType extends EntityBaseObject implements EntityBase {

    public final static String TABLENAME = "owner_pet_type";
    public final static String COL_ID = "id";
    public final static String COL_UUID = "uuid";
    public final static String COL_NAME = "name";
    public final static String COL_SEARCHINDEX = "searchindex";
    private static final long serialVersionUID = -2213412509142145275L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COL_UUID, nullable = false, unique = true)
    private UUID uuid;

    @Column(name = COL_SEARCHINDEX, nullable = true)
    private String searchindex;

    @NotEmpty
    @Column(name = COL_NAME, nullable = false, unique = true)
    private String name;

    public PetType(@NotBlank String name) {
        this.name = name;
    }

    @Transient
    public String getTableName() {
        return TABLENAME;
    }

    @Transient
    public String getPrimaryKey() {
        return this.getName();
    }

    @Transient
    public String getPrimaryKeyWithId() {
        return this.getPrimaryKey() + "(" + this.getId() + "," + this.getUuid() + ")";
    }

}
