package peaksoft.services.impl;

import peaksoft.entity.Publisher;
import peaksoft.repositories.PublisherRepository;
import peaksoft.repositories.impl.PublisherRepoImpl;
import peaksoft.services.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepository publisherRepository = new PublisherRepoImpl();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.getAllPublishers();
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        return publisherRepository.updatePublisher(id,publisher);
    }

    @Override
    public String deletePublisherByName(String name) {
        return publisherRepository.deletePublisherByName(name);
    }
}
