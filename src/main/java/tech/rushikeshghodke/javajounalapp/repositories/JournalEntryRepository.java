package tech.rushikeshghodke.javajounalapp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import tech.rushikeshghodke.javajounalapp.entities.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
