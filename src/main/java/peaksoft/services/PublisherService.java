package peaksoft.services;

import peaksoft.entity.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers();
    String updatePublisher(Long id,Publisher publisher);
    String deletePublisherByName(String name);
}
