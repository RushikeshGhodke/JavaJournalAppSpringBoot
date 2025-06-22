package tech.rushikeshghodke.javajounalapp.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import tech.rushikeshghodke.javajounalapp.entities.JournalEntry;
import tech.rushikeshghodke.javajounalapp.repositories.JournalEntryRepository;

import java.util.Date;
import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public List<JournalEntry> getAllJournalEntries () {
        return journalEntryRepository.findAll();
    }

    public void saveJournalEntry (JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public JournalEntry findJournalEntryById (ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public void deleteJournalEntryById (ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

    public JournalEntry updateJournalEntryById (ObjectId id, JournalEntry newEntry) {
        JournalEntry oldEntry = findJournalEntryById(id);
        if (oldEntry != null) {
            if (oldEntry.getTitle() != newEntry.getTitle()) oldEntry.setTitle(newEntry.getTitle());
            if (oldEntry.getContent() != newEntry.getContent()) oldEntry.setContent(newEntry.getContent());
        }
        journalEntryRepository.save(newEntry);
        return newEntry;
    }
}
