package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long timeEntryId);
    List<TimeEntry> list();
    TimeEntry update(long timeEntryId, TimeEntry timeEntry);
    void delete(long timeEntryId);
}
