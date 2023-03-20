package com.epam.example.storage.entity;

import java.time.Instant;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Super entity
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

  /**
   * Record create time
   */
  @CreationTimestamp
  private Instant createDate;

  /**
   * Record last update time
   */
  @UpdateTimestamp
  private Instant updateDate;

}
