/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.pet;

import java.util.Date;
import java.util.Set;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.visit.Visit;

/** @author qtopierw */
public class Pet extends NamedEntity {

  /** Default serial version UID */
  private static final long serialVersionUID = 1L;

  private Date birthDate;

  private PetType type;

  private Owner owner;

  private Set<Visit> visits;

  /** @return the birthDate */
  public Date getBirthDate() {
    return birthDate;
  }

  /** @param birthDate the birthDate to set */
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  /** @return the type */
  public PetType getType() {
    return type;
  }

  /** @param type the type to set */
  public void setType(PetType type) {
    this.type = type;
  }

  /** @return the owner */
  public Owner getOwner() {
    return owner;
  }

  /** @param owner the owner to set */
  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  /** @return the visits */
  public Set<Visit> getVisits() {
    return visits;
  }

  /** @param visits the visits to set */
  public void setVisits(Set<Visit> visits) {
    this.visits = visits;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return super.toString()
        + "Pet [birthDate="
        + birthDate
        + ", owner="
        + owner
        + ", type="
        + type
        + ", visits="
        + visits
        + "]";
  }
}
