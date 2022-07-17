package org.woehlke.jakartaee.petclinic.specialty;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBaseObject;

import java.util.Objects;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 01.01.14
 * Time: 21:11
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
        name = Specialty.TABLENAME,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = Specialty.TABLENAME + "_unique_uuid",
                        columnNames = {Specialty.COL_UUID}
                ),
                @UniqueConstraint(
                        name = Specialty.TABLENAME + "_unique_names",
                        columnNames = {
                                Specialty.COL_NAME
                        }
                )
        }
)
@NamedQueries({
        @NamedQuery(
                name = "Specialty.getAll",
                query = "select s from Specialty s order by s.name"
        )
})
public class Specialty extends EntityBaseObject implements EntityBase,Comparable<Specialty> {

    public final static String TABLENAME = "specialty";
    public final static String COL_ID = "id";
    public final static String COL_UUID = "uuid";
    public final static String COL_NAME = "name";
    public final static String COL_SEARCHINDEX = "searchindex";
    private static final long serialVersionUID = -836560513920170089L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COL_UUID, nullable = false, unique = true)
    private UUID uuid;

    @Column(name = COL_SEARCHINDEX, nullable = true)
    private String searchindex;

    @NotEmpty
    @XmlElement(required = true)
    @Column(name = COL_NAME, unique = true, nullable = false)
    private String name;

    public Specialty(@NotBlank String name) {
        this.name = name;
    }

    @Override
    public String getTableName() {
        return TABLENAME;
    }

    @Override
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
        if (!(o instanceof Specialty)) return false;
        Specialty specialty = (Specialty) o;
        return getName().equals(specialty.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(Specialty o) {
        return this.name.compareTo(o.name);
    }
}
