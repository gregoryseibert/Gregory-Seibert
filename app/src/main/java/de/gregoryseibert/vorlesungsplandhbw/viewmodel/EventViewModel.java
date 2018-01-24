package de.gregoryseibert.vorlesungsplandhbw.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;

import de.gregoryseibert.vorlesungsplandhbw.model.SimpleDate;
import de.gregoryseibert.vorlesungsplandhbw.model.Week;
import de.gregoryseibert.vorlesungsplandhbw.service.EventRepository;

/**
 * Created by Gregory Seibert on 11.01.2018.
 */

public class EventViewModel extends ViewModel {
    private EventRepository eventRepository;
    private ExecutorService executorService;

    private MutableLiveData<Week> week;

    public EventViewModel(EventRepository eventRepository, ExecutorService executorService) {
        this.eventRepository = eventRepository;
        this.executorService = executorService;
    }

    public void init(String url, SimpleDate date) {
        if(week == null) {
            this.week = new MutableLiveData<>();
        }

        executorService.execute(() -> week.postValue(eventRepository.getAllEventsOfWeek(url, date)));
    }

    public LiveData<Week> getEvents() {
        return this.week;
    }
}
