/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.owner;

import java.util.Set;

import javax.validation.constraints.Digits;

import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.pet.Pet;

/** @author qtopierw */
public class Owner extends Person {
  
  /** Default serial version UID */
  private static final long serialVersionUID = 1L;
  
  private String address;

  private String city;

  @Digits(fraction = 0, integer = 10)
  private String telephone;

  private Set<Pet> pets;

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the telephone
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * @param telephone the telephone to set
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * @return the pets
   */
  public Set<Pet> getPets() {
    return pets;
  }

  /**
   * @param pets the pets to set
   */
  public void setPets(Set<Pet> pets) {
    this.pets = pets;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  
  @Override
  public String toString() {
    return "Owner [address=" + address + ", city=" + city + ", pets=" + pets + ", telephone=" + telephone + "]";
  }

  
}
