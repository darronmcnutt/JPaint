package model.interfaces;

public interface IApplicationStateSubject {
    void registerObserver(IApplicationStateObserver observer);
    void notifyObserver();
}
