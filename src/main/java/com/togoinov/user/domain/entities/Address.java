package com.togoinov.user.domain.entities;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private UUID id;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String land;
    private String createdBy;
    @CreatedDate
    private LocalDateTime createdAt;
    private String updatedBy;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Version
    private LocalDateTime version;

}
