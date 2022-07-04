package org.woehlke.jakartaee.petclinic.specialty;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBase;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBaseObject;

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
@XmlRootElement(name = "Specialty")
@XmlType(
        name = "Specialty",
        namespace = "http://woehlke.org/org/woehlke/jakartaee/petclinic/oodm/entities/Specialty",
        propOrder = {
                "id", "uuid", "name"
        }
)
@XmlAccessorType(XmlAccessType.FIELD)
public class Specialty extends EntityBaseObject implements EntityBase {

    public final static String TABLENAME = "specialty";
    public final static String COL_ID = "id";
    public final static String COL_UUID = "uuid";
    public final static String COL_NAME = "name";
    public final static String COL_SEARCHINDEX = "searchindex";
    private static final long serialVersionUID = -836560513920170089L;

    @Id
    @XmlElement(required = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement(required = true)
    @Column(name = COL_UUID, nullable = false, unique = true)
    private UUID uuid;

    @Column(name = COL_SEARCHINDEX, nullable = false)
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
    public String[] getColumnNames() {
        String[] thisColumnNames = {
                COL_ID, COL_UUID, COL_NAME
        };
        return thisColumnNames;
    }

    @Override
    public String getPrimaryKey() {
        return this.getName();
    }

    @Transient
    public String getPrimaryKeyWithId() {
        return this.getPrimaryKey() + "(" + this.getId() + "," + this.getUuid() + ")";
    }

}
