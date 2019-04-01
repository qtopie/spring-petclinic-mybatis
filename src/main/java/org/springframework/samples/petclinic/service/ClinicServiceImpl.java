/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.mapper.OwnerMapper;
import org.springframework.samples.petclinic.mapper.PetMapper;
import org.springframework.samples.petclinic.mapper.PetTypeMapper;
import org.springframework.samples.petclinic.mapper.SpecialtyMapper;
import org.springframework.samples.petclinic.mapper.VetMapper;
import org.springframework.samples.petclinic.mapper.VisitMapper;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 * @author Vitaliy Fedoriv
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    private PetMapper petMapper;
    private VetMapper vetMapper;
    private OwnerMapper ownerMapper;
    private VisitMapper visitMapper;
    private SpecialtyMapper specialtyMapper;
	private PetTypeMapper petTypeMapper;

    @Autowired
     public ClinicServiceImpl(
       		 PetMapper petMapper,
    		 VetMapper vetMapper,
    		 OwnerMapper ownerMapper,
    		 VisitMapper visitMapper,
    		 SpecialtyMapper specialtyMapper,
			 PetTypeMapper petTypeMapper) {
        this.petMapper = petMapper;
        this.vetMapper = vetMapper;
        this.ownerMapper = ownerMapper;
        this.visitMapper = visitMapper;
        this.specialtyMapper = specialtyMapper; 
		this.petTypeMapper = petTypeMapper;
    }

	@Override
	@Transactional(readOnly = true)
	public Collection<Pet> findAllPets() throws DataAccessException {
		return petMapper.findAll();
	}

	@Override
	@Transactional
	public void deletePet(Pet pet) throws DataAccessException {
		petMapper.delete(pet);
	}

	@Override
	@Transactional(readOnly = true)
	public Visit findVisitById(int visitId) throws DataAccessException {
		Visit visit = null;
		try {
			visit = visitMapper.findById(visitId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
		// just ignore not found exceptions for Jdbc/Jpa realization
			return null;
		}
		return visit;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Visit> findAllVisits() throws DataAccessException {
		return visitMapper.findAll();
	}

	@Override
	@Transactional
	public void deleteVisit(Visit visit) throws DataAccessException {
		visitMapper.delete(visit);
	}

	@Override
	@Transactional(readOnly = true)
	public Vet findVetById(int id) throws DataAccessException {
		Vet vet = null;
		try {
			vet = vetMapper.findById(id);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
		// just ignore not found exceptions for Jdbc/Jpa realization
			return null;
		}
		return vet;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Vet> findAllVets() throws DataAccessException {
		return vetMapper.findAll();
	}

	@Override
	@Transactional
	public void saveVet(Vet vet) throws DataAccessException {
		vetMapper.save(vet);
	}

	@Override
	@Transactional
	public void deleteVet(Vet vet) throws DataAccessException {
		vetMapper.delete(vet);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Owner> findAllOwners() throws DataAccessException {
		return ownerMapper.findAll();
	}

	@Override
	@Transactional
	public void deleteOwner(Owner owner) throws DataAccessException {
		ownerMapper.delete(owner);
	}

	@Override
	@Transactional(readOnly = true)
	public PetType findPetTypeById(int petTypeId) {
		PetType petType = null;
		try {
			petType = petTypeMapper.findById(petTypeId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
		// just ignore not found exceptions for Jdbc/Jpa realization
			return null;
		}
		return petType;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<PetType> findAllPetTypes() throws DataAccessException {
		return petTypeMapper.findAll();
	}

	@Override
	@Transactional
	public void savePetType(PetType petType) throws DataAccessException {
		petTypeMapper.save(petType);
	}

	@Override
	@Transactional
	public void deletePetType(PetType petType) throws DataAccessException {
		petTypeMapper.delete(petType);
	}

	@Override
	@Transactional(readOnly = true)
	public Specialty findSpecialtyById(int specialtyId) {
		Specialty specialty = null;
		try {
			specialty = specialtyMapper.findById(specialtyId);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
		// just ignore not found exceptions for Jdbc/Jpa realization
			return null;
		}
		return specialty;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Specialty> findAllSpecialties() throws DataAccessException {
		return specialtyMapper.findAll();
	}

	@Override
	@Transactional
	public void saveSpecialty(Specialty specialty) throws DataAccessException {
		specialtyMapper.save(specialty);
	}

	@Override
	@Transactional
	public void deleteSpecialty(Specialty specialty) throws DataAccessException {
		specialtyMapper.delete(specialty);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Pet> findPetsByPetType(int petTypeId) throws DataAccessException {
		return petMapper.findByTypeId(petTypeId);
	}

	@Override
	@Transactional(readOnly = true)
	public Owner findOwnerById(int id) throws DataAccessException {
		Owner owner = null;
		try {
			owner = ownerMapper.findById(id);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
		// just ignore not found exceptions for Jdbc/Jpa realization
			return null;
		}
		return owner;
	}

	@Override
	@Transactional(readOnly = true)
	public Pet findPetById(int id) throws DataAccessException {
		Pet pet = null;
		try {
			pet = petMapper.findById(id);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
		// just ignore not found exceptions for Jdbc/Jpa realization
			return null;
		}
		return pet;
	}

	@Override
	@Transactional
	public void savePet(Pet pet) throws DataAccessException {
		petMapper.save(pet);
		
	}

	@Override
	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitMapper.save(visit);
		
	}

	@Override
	@Transactional(readOnly = true)
    @Cacheable(value = "vets")
	public Collection<Vet> findVets() throws DataAccessException {
		return vetMapper.findAll();
	}

	@Override
	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {
		ownerMapper.save(owner);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
		return ownerMapper.findByLastName(lastName);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Visit> findVisitsByPetId(int petId) {
		return visitMapper.findByPetId(petId);
	}
	
	


}
