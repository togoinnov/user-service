package com.togoinov.user.domain.entities;

import com.togoinov.user.api.Sex;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private LocalDateTime dob;
    private String email;
    private String avatar;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE
            },
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @Singular(ignoreNullCollections = true)
//    @Valid
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @Nullable
    private List<Address> addresses;
    private String createdBy;
    @CreatedDate
    private LocalDateTime createdAt;
    private String updatedBy;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Version
    private LocalDateTime version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
