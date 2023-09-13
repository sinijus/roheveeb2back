package ee.valiit.roheveeb2back.domain.location;

import ee.valiit.roheveeb2back.domain.location.county.County;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Size(max = 255)
    @NotNull
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Size(max = 255)
    @Column(name = "longitude")
    private String longitude;

    @Size(max = 255)
    @Column(name = "latitude")
    private String latitude;

}