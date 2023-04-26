package peaksoft.repositories;

import peaksoft.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers();
    String updatePublisher(Long id,Publisher publisher);
    String deletePublisherByName(String name);
}
