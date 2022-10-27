package pattern02.observer.e2;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    List<Observer> observers = new ArrayList<Observer>();

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (int i = 0; i < observers.size(); ++i)
            observers.get(i).update(this);
    }
}