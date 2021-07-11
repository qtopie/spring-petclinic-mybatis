/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.visit;

import java.util.Date;
import org.springframework.samples.petclinic.model.BaseEntity;

/** @author qtopierw */
public class Visit extends BaseEntity {

  private Date date;

  private String description;

  private Integer petId;

  /** @return the date */
  public Date getDate() {
    return date;
  }

  /** @param date the date to set */
  public void setDate(Date date) {
    this.date = date;
  }

  /** @return the description */
  public String getDescription() {
    return description;
  }

  /** @param description the description to set */
  public void setDescription(String description) {
    this.description = description;
  }

  /** @return the petId */
  public Integer getPetId() {
    return petId;
  }

  /** @param petId the petId to set */
  public void setPetId(Integer petId) {
    this.petId = petId;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return super.toString()
        + "Visit [date="
        + date
        + ", description="
        + description
        + ", petId="
        + petId
        + "]";
  }
}
