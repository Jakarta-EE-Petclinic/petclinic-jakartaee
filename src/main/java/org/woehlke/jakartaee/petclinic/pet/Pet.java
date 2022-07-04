package org.woehlke.jakartaee.petclinic.pet;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBase;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBaseObject;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.impl.PetListener;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 01.01.14
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Getter
@Setter
@ToString(exclude = {"owner"})
@EqualsAndHashCode(exclude = {"owner"}, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = Pet.TABLENAME,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = Pet.TABLENAME + "_unique_uuid",
                        columnNames = {Pet.COL_UUID}
                ),
                @UniqueConstraint(
                        name = Pet.TABLENAME + "_unique_names",
                        columnNames = {
                                Pet.COL_NAME,
                                Pet.COL_BIRTH_DATE,
                                Pet.COL_PETTYPE_ID,
                                Pet.COL_OWNER_ID
                        }
                )
        }
)
@NamedQueries({
        @NamedQuery(
                name = "Pet.getAll",
                query = "select p from Pet p order by p.name"
        )
})
@EntityListeners(PetListener.class)
@XmlRootElement(
        name = "Pet"
)
@XmlType(
        name = "Pet",
        namespace = "http://woehlke.org/org/woehlke/jakartaee/petclinic/oodm/entities/Pet",
        propOrder = {
                "id", "uuid", "name", "birthDate", "type", "visits"
        }
)
@XmlAccessorType(XmlAccessType.FIELD)
public class Pet extends EntityBaseObject implements EntityBase {

    public final static String TABLENAME = "owner_pet";
    public final static String COL_ID = "id";
    public final static String COL_UUID = "uuid";
    public final static String COL_NAME = "name";
    public final static String COL_BIRTH_DATE = "birth_date";
    public final static String COL_PETTYPE_ID = "owner_pet_type_id";
    public final static String COL_OWNER_ID = "owner_id";
    public final static String COL_SEARCHINDEX = "searchindex";
    private static final long serialVersionUID = 1007513582768464905L;

    @NotNull
    @XmlElement(required = true)
    @Column(name = COL_BIRTH_DATE, columnDefinition = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date birthDate;

    @Id
    @XmlElement(required = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement(required = true)
    @Column(name = COL_UUID, nullable = false, unique = true)
    private UUID uuid;

    @Column(name = COL_SEARCHINDEX, nullable = true)
    private String searchindex;

    @NotNull
    @NotEmpty
    @XmlElement(required = true)
    @Column(name = COL_NAME, nullable = false)
    private String name;

    @NotNull
    @XmlElement(required = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = COL_PETTYPE_ID)
    private PetType type;

    @NotNull
    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = COL_OWNER_ID)
    private Owner owner;

    @XmlElementWrapper(name = "visits", nillable = false, required = true)
    @XmlElement(name = "visit")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    private Set<Visit> visits = new HashSet<>();

    @Transient
    public String getTableName() {
        return TABLENAME;
    }

    @Transient
    public String[] getColumnNames() {
        String[] thisColumnNames = {
                COL_ID, COL_UUID,
                COL_NAME, COL_BIRTH_DATE,
                COL_PETTYPE_ID, COL_OWNER_ID
        };
        return thisColumnNames;
    }

    @Transient
    public String getPrimaryKey() {
        return "" + this.getName() + " ( " + this.getType().getName() + ")";
    }

    @Transient
    public String getPrimaryKeyWithId() {
        return this.getPrimaryKey() + "(" + this.getId() + "," + this.getUuid() + ")";
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getVisits() {
        List<Visit> list = new ArrayList<>();
        for (Visit visit : visits) {
            list.add(visit);
        }
        Collections.sort(list);
        return list;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

}
