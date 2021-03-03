package com.amela.sfgpetclinic.services.map;

import com.amela.sfgpetclinic.model.Specialty;
import com.amela.sfgpetclinic.model.Vet;
import com.amela.sfgpetclinic.services.SpecialtyService;
import com.amela.sfgpetclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@AllArgsConstructor
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
