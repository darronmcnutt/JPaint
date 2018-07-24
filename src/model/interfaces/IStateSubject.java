package model.interfaces;

public interface IStateSubject {
    void registerObserver(IStateObserver observer);
    void notifyObserver();
}
