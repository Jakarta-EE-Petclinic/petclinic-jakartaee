package org.woehlke.jakartaee.petclinic.visit;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBase;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBaseObject;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import org.woehlke.jakartaee.petclinic.visit.impl.VisitListener;

import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 01.01.14
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Getter
@Setter
@ToString(exclude = {"pet"})
@EqualsAndHashCode(exclude = {"pet"}, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = Visit.TABLENAME,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = Visit.TABLENAME + "_unique_uuid",
                        columnNames = {
                                Visit.COL_UUID
                        }
                ),
                @UniqueConstraint(
                        name = Visit.TABLENAME + "_unique_names",
                        columnNames = {
                                Visit.COL_VISIT_DATE,
                                Visit.COL_DESCRIPTION,
                                Visit.COL_PET_ID
                        }
                )
        }
)
@NamedQueries({
        @NamedQuery(
                name = "Visit.getAll",
                query = "select s from Visit s"
        )
})
@EntityListeners(VisitListener.class)
@XmlRootElement(name = "Visit")
@XmlType(
        name = "Visit",
        namespace = "http://woehlke.org/org/woehlke/jakartaee/petclinic/oodm/entities/Visit",
        propOrder = {
                "id", "uuid", "date", "description"
        }
)
@XmlAccessorType(XmlAccessType.FIELD)
public class Visit extends EntityBaseObject implements EntityBase {

    public final static String TABLENAME = "owner_pet_visit";
    public final static String COL_ID = "id";
    public final static String COL_UUID = "uuid";
    public final static String COL_VISIT_DATE = "visit_date";
    public final static String COL_DESCRIPTION = "description";
    public final static String COL_PET_ID = "owner_pet_id";
    private static final long serialVersionUID = 2357446696894656827L;

    @Id
    @XmlElement(required = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement(required = true)
    @Column(name = COL_UUID, nullable = false, unique = true)
    private UUID uuid;

    @NotNull
    @XmlElement(required = true)
    @Column(name = COL_VISIT_DATE, nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date date;

    @NotEmpty
    @XmlElement(required = true)
    @Column(name = COL_DESCRIPTION, nullable = false)
    private String description;

    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = COL_PET_ID)
    private Pet pet;

    @Transient
    @Override
    public String getTableName() {
        return TABLENAME;
    }

    @Transient
    @Override
    public String[] getColumnNames() {
        String[] thisColumnNames = {
                COL_ID, COL_UUID,
                COL_VISIT_DATE, COL_DESCRIPTION, COL_PET_ID
        };
        return thisColumnNames;
    }

    @Transient
    @Override
    public String getPrimaryKey() {
        String primaryKey = description;
        return primaryKey + " ( " + date + " )";
    }

    @Transient
    @Override
    public String getPrimaryKeyWithId() {
        return this.getPrimaryKey() + "(" + this.getId() + "," + this.getUuid() + ")";
    }

}
