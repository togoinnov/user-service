package com.togoinov.user.domain.entities;

@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
@Table(name = "address")

public class Adress {

    @Id
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
