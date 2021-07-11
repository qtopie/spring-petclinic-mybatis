/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.vet;

import java.util.Set;
import org.springframework.samples.petclinic.model.Person;

/** @author qtopierw */
public class Vet extends Person {

  private Set<Specialty> specialties;

  /** @return the specialties */
  public Set<Specialty> getSpecialties() {
    return specialties;
  }

  /** @param specialties the specialties to set */
  public void setSpecialties(Set<Specialty> specialties) {
    this.specialties = specialties;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return super.toString() + "Vet [specialties=" + specialties + "]";
  }
}
