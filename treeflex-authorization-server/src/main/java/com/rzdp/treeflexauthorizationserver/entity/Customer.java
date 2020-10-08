package com.rzdp.treeflexauthorizationserver.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "customer_id",
                "username",
                "email"
        })
})
@Data
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    @NotBlank(message = "{validation.not-blank.customer.customerId}")
    private UUID customerId;

    @Column(name = "username")
    @NotBlank(message = "{validation.not-blank.customer.username}")
    @Min(value = 8, message = "{validation.min.customer.username}")
    @Max(value = 256, message = "{validation.max.customer.username}")
    private String username;

    @Column(name = "email")
    @NotBlank(message = "{validation.not-blank.customer.email}")
    @Max(value = 256, message = "{validation.max.customer.email}")
    @Email(message = "{validation.email.customer.email}")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "{validation.not-blank.customer.password}")
    @Min(value = 8, message = "{validation.min.customer.password}")
    @Max(value = 256, message = "{validation.max.customer.password}")
    private String password;

    @Column(name = "enabled")
    @NotNull(message = "{validation.not-null.customer.enabled")
    private Boolean enabled;

    @Column(name = "account_expired")
    @NotNull(message = "{validation.not-null.customer.accountNonExpired}")
    private Boolean accountExpired;

    @Column(name = "account_locked")
    @NotNull(message = "{validation.not-null.customer.accountNonLocked}")
    private Boolean accountLocked;

    @Column(name = "credentials_expired")
    @NotNull(message = "{validation.not-null.customer.credentialsNonExpired}")
    private Boolean credentialsExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(name = "customer_role",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

    public Customer(Customer customer) {
        this.id = customer.getId();
        this.customerId = customer.getCustomerId();
        this.username = customer.getUsername();
        this.email = customer.getEmail();
        this.password = customer.getPassword();
        this.enabled = customer.getEnabled();
        this.accountExpired = customer.getAccountExpired();
        this.accountLocked = customer.getAccountLocked();
        this.credentialsExpired = customer.getCredentialsExpired();
        this.roles = customer.getRoles();
    }
}
