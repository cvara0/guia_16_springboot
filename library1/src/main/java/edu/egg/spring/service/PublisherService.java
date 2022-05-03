package edu.egg.spring.service;

import edu.egg.spring.entity.PublisherEntity;
import edu.egg.spring.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Transactional
    public void create(PublisherEntity publisherEntityDto) {
        PublisherEntity publisherEntity = new PublisherEntity();
        publisherEntity.setName(publisherEntityDto.getName());
        publisherEntity.setName(publisherEntityDto.getName());
        publisherRepository.save(publisherEntity);
    }

    @Transactional
    public void update(PublisherEntity publisherEntityDto) {
        PublisherEntity publisherEntity = publisherRepository.findById(publisherEntityDto.getId()).get();
        publisherEntity.setName(publisherEntityDto.getName());
        publisherEntity.setName(publisherEntityDto.getName());
        publisherRepository.save(publisherEntity);
    }

    @Transactional(readOnly = true)
    public PublisherEntity getById(Long id) {
        return publisherRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<PublisherEntity> getAll() {
        return publisherRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}
