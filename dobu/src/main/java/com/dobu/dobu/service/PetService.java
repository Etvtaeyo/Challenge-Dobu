package com.dobu.dobu.service;

import com.dobu.dobu.entity.Pet;
import com.dobu.dobu.repository.PetRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.dobu.dobu.exception.ResourceNotFoundException;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public Page<Pet> listar(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Pet buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pet não encontrado"));
    }

    public Pet salvar(Pet pet) {
        return repository.save(pet);
    }

    public Pet atualizar(Long id, Pet petAtualizado) {

        Pet pet = buscarPorId(id);

        pet.setNome(petAtualizado.getNome());
        pet.setIdade(petAtualizado.getIdade());
        pet.setRaca(petAtualizado.getRaca());
        pet.setTutor(petAtualizado.getTutor());

        return repository.save(pet);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}