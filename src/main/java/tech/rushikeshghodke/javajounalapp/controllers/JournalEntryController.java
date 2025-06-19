package tech.rushikeshghodke.javajounalapp.controllers;

import org.springframework.web.bind.annotation.*;
import tech.rushikeshghodke.javajounalapp.entities.JournalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Integer, JournalEntry> journalEntryMap = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAllJournalEntries () {
        return new ArrayList<>(journalEntryMap.values());
    }

    @PostMapping
    public void createEntry (@RequestBody JournalEntry newEntry) {
        journalEntryMap.put(newEntry.getId(), newEntry);
    }

    @GetMapping("id/{id}")
    public JournalEntry getJournalEntryById (@PathVariable int id) {
        return journalEntryMap.get(id);
    }

    @DeleteMapping("id/{id}")
    public boolean deleteJournalEntry (@PathVariable int id) {
        journalEntryMap.remove(id);
        return true;
    }
 }
