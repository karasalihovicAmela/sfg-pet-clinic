package com.amela.sfgpetclinic.services.springdatajpa;

import com.amela.sfgpetclinic.model.Vet;
import com.amela.sfgpetclinic.repositories.VetRepostory;
import com.amela.sfgpetclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class VetSDJpaService implements VetService {

    private final VetRepostory vetRepostory;

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();

        vetRepostory.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long aLong) {

        return vetRepostory.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {

        return vetRepostory.save(object);
    }

    @Override
    public void delete(Vet object) {

        vetRepostory.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

        vetRepostory.deleteById(aLong);
    }
}
