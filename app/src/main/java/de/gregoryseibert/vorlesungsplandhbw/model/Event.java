package de.gregoryseibert.vorlesungsplandhbw.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Gregory Seibert on 11.01.2018.
 */

@Entity
public class Event {
    @ColumnInfo(name = "loadedat")
    public SimpleDate loadedAt;
    @PrimaryKey
    @ColumnInfo(name = "startdate")
    public SimpleDate startDate;
    @ColumnInfo(name = "enddate")
    public SimpleDate endDate;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "room")
    public String room;
    @ColumnInfo(name = "lecturer")
    public String lecturer;
    @ColumnInfo(name = "type")
    public EventType type;

    public Event(SimpleDate loadedAt, SimpleDate startDate, SimpleDate endDate, String title, String room, String lecturer, EventType type) {
        this.loadedAt = loadedAt;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.room = room;
        this.lecturer = lecturer;
        this.type = type;
    }

    public Event(String title, EventType eventType) {
        this.title = title;
        type = eventType;
    }

    @Override
    public String toString() {
        return type.toString() + " '" + title + "': " + startDate.getFormatTime() + " - " + endDate.getFormatTime() + ", " + startDate.getFormatDate();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SimpleDate) {
            if(((SimpleDate) obj).getFormatDate().equals(this.getStartDate().getFormatDate())) {
                return true;
            }
        }

        return false;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public SimpleDate getLoadedAt() {
        return loadedAt;
    }

    public SimpleDate getStartDate() {
        return startDate;
    }

    public void setStartDate(SimpleDate startDate) {
        this.startDate = startDate;
    }

    public SimpleDate getEndDate() {
        return endDate;
    }

    public void setEndDate(SimpleDate endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public enum EventType {
        EXAM, LECTURE, EMPTY
    }
}
