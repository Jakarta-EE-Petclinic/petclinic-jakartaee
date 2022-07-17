package org.woehlke.jakartaee.petclinic.pettype;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBaseObject;
import org.woehlke.jakartaee.petclinic.pettype.db.PetTypeListener;

import jakarta.persistence.*;

import java.util.Objects;
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
                query = "select p from PetType p order by p.name"
        )
})
@EntityListeners(PetTypeListener.class)
public class PetType extends EntityBaseObject implements EntityBase, Comparable<PetType> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetType)) return false;
        PetType petType = (PetType) o;
        return getName().equals(petType.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(PetType o) {
        return this.name.compareTo(o.name);
    }
}
