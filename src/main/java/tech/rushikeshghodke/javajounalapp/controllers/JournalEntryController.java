package tech.rushikeshghodke.javajounalapp.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.rushikeshghodke.javajounalapp.entities.JournalEntry;
import tech.rushikeshghodke.javajounalapp.services.JournalEntryService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAllJournalEntries () {
        return journalEntryService.getAllJournalEntries();
    }

    @PostMapping
    public void createEntry (@RequestBody JournalEntry newEntry) {
        newEntry.setDate(LocalDateTime.now());
        journalEntryService.saveJournalEntry(newEntry);
    }

    @GetMapping("id/{id}")
    public JournalEntry getJournalEntryById (@PathVariable ObjectId id) {
        return journalEntryService.findJournalEntryById(id);
    }

    @DeleteMapping("id/{id}")
    public boolean deleteJournalEntry (@PathVariable ObjectId id) {
        journalEntryService.deleteJournalEntryById(id);
        return true;
    }

//    @PutMapping("id/{id}")
//    public JournalEntry updateJournalEntry (@PathVariable ObjectId id, JournalEntry newEntry) {
//        journalEntryService.updateJournalEntryById(id, newEntry);
//    }
 }
