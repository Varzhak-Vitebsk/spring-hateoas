package com.epam.example.storage.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "subscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionEntity extends BaseEntity {

  /**
   * Unique id
   */
  @NotNull
  @Id
  @SequenceGenerator(name = "subscription_id_gen", sequenceName = "subscription_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "subscription_id_gen")
  private Long id;

  /**
   * User
   */
  @Valid
  @ManyToOne(fetch = FetchType.LAZY)
  @Cascade(CascadeType.ALL)
  private UserEntity user;

}
