package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> repo = new HashMap<>();
    private long seq = 0;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newEntry = new TimeEntry();
        newEntry.setUserId(timeEntry.getUserId());
        newEntry.setHours(timeEntry.getHours());
        newEntry.setProjectId(timeEntry.getProjectId());
        newEntry.setDate(timeEntry.getDate());

        seq = seq + 1;
        newEntry.setId(seq);

        repo.put(seq, newEntry);
        return newEntry;
    }

    public TimeEntry find(long timeEntryId) {
        return repo.get(timeEntryId);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        if (repo.get(timeEntryId) == null) {
            return null;
        }

        TimeEntry newEntry = new TimeEntry();

        newEntry.setUserId(timeEntry.getUserId());
        newEntry.setHours(timeEntry.getHours());
        newEntry.setProjectId(timeEntry.getProjectId());
        newEntry.setDate(timeEntry.getDate());
        newEntry.setId(timeEntryId);

        repo.put(timeEntryId, newEntry);
        return newEntry;
    }

    public void delete(long timeEntryId) {
        repo.remove(timeEntryId);
    }
}
