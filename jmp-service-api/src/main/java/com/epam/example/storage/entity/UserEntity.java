package com.epam.example.storage.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Builder
public class UserEntity extends BaseEntity {

  /**
   * Unique id
   */
  @NotNull
  @Id
  @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "user_id_gen")
  private Long id;

  /**
   * User's name
   */
  @NotBlank
  private String name;

  /**
   * User's surname
   */
  @NotBlank
  private String surname;

  /**
   * User's birthday
   */
  @NotBlank
  private LocalDate birthday;

  /**
   * User's subscriptions
   */
  @Valid
  @NotNull
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @Builder.Default
  private Set<SubscriptionEntity> subscriptions = new HashSet<>();

}
