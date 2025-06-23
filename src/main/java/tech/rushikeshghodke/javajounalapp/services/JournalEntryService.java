package tech.rushikeshghodke.javajounalapp.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import tech.rushikeshghodke.javajounalapp.entities.JournalEntry;
import tech.rushikeshghodke.javajounalapp.repositories.JournalEntryRepository;

import java.time.LocalDateTime;
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
        journalEntry.setDate(LocalDateTime.now());
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
        System.out.println(oldEntry);
        if (oldEntry != null) {
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());
        }
        journalEntryRepository.save(oldEntry);
        return oldEntry;
    }
}
