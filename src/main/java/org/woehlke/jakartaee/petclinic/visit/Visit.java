package org.woehlke.jakartaee.petclinic.visit;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBaseObject;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import jakarta.persistence.*;
import org.woehlke.jakartaee.petclinic.visit.db.VisitListener;

import java.util.Date;
import java.util.Objects;
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
                query = "select s from Visit s order by s.date"
        )
})
@EntityListeners(VisitListener.class)
public class Visit extends EntityBaseObject implements EntityBase,Comparable<Visit> {

    public final static String TABLENAME = "owner_pet_visit";
    public final static String COL_ID = "id";
    public final static String COL_UUID = "uuid";
    public final static String COL_VISIT_DATE = "visit_date";
    public final static String COL_DESCRIPTION = "description";
    public final static String COL_PET_ID = "owner_pet_id";
    public final static String COL_SEARCHINDEX = "searchindex";
    private static final long serialVersionUID = 2357446696894656827L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COL_UUID, nullable = false, unique = true)
    private UUID uuid;

    @Column(name = COL_SEARCHINDEX, nullable = true)
    private String searchindex;

    @NotNull
    @Column(name = COL_VISIT_DATE, nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date date;

    @NotEmpty
    @Column(name = COL_DESCRIPTION, nullable = false)
    private String description;

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
    public String getPrimaryKey() {
        String primaryKey = description;
        return primaryKey + " ( " + date + " )";
    }

    @Transient
    @Override
    public String getPrimaryKeyWithId() {
        return this.getPrimaryKey() + "(" + this.getId() + "," + this.getUuid() + ")";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;
        Visit visit = (Visit) o;
        return Objects.equals(getDate(), visit.getDate()) && Objects.equals(getDescription(), visit.getDescription()) && Objects.equals(getPet(), visit.getPet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getDescription());
    }

    @Override
    public int compareTo(Visit o) {
        return this.date.compareTo(o.date);
    }
}
