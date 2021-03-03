package com.durakkerem.service.impl;


import com.durakkerem.entity.Address;
import com.durakkerem.entity.Person;
import com.durakkerem.repository.AddressRepository;
import com.durakkerem.repository.PersonRepository;
import com.durakkerem.service.PersonService;
import com.durakkerem.service.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl  implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;


    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb =personRepository.save(person);
        List<Address> addressList = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.BUSINESS_ADDRESS);
            address.setActive(true);
            address.setPerson(person);
            addressList.add(address);
        });

        addressRepository.saveAll(addressList);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList =personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        personList.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setSurname(item.getSurname());
            personDto.setAddresses(item.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList()));
            personDtoList.add(personDto);
        });

        return personDtoList;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
