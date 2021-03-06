package org.woehlke.jakartaee.petclinic.pet;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBaseObject;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.db.PetListener;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import jakarta.persistence.*;

import java.io.Serializable;
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
                query = "select p from Pet p order by p.birthDate, p.name"
        )
})
@EntityListeners(PetListener.class)
public class Pet extends EntityBaseObject implements EntityBase, Comparable<Pet>, Serializable {

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
    @Column(name = COL_BIRTH_DATE, columnDefinition = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date birthDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COL_UUID, nullable = false, unique = true)
    private UUID uuid;

    @Column(name = COL_SEARCHINDEX, nullable = true)
    private String searchindex;

    @NotNull
    @NotEmpty
    @Column(name = COL_NAME, nullable = false)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = COL_PETTYPE_ID)
    private PetType type;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = COL_OWNER_ID)
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    private Set<Visit> visits = new HashSet<>();

    @Transient
    public String getTableName() {
        return TABLENAME;
    }

    @Transient
    public String getPrimaryKey() {
        return "" + this.getBirthDate().toInstant().toString() +  " ( " +  this.getName() + ")";
    }

    @Transient
    public String getPrimaryKeyWithId() {
        return this.getPrimaryKey() + "(" + this.getId() + "," + this.getUuid() + ")";
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getVisits() {
        List<Visit> listVisit = new ArrayList<>();
        for (Visit visit : visits) {
            listVisit.add(visit);
        }
        Collections.sort(listVisit);
        return listVisit;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(getBirthDate(), pet.getBirthDate()) && Objects.equals(getName(), pet.getName()) && Objects.equals(getType(), pet.getType()) && Objects.equals(getOwner(), pet.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBirthDate(), getName(), getType(), getOwner());
    }

    @Override
    public int compareTo(Pet o) {
        return this.getBirthDate().compareTo(o.getBirthDate());
    }
}
