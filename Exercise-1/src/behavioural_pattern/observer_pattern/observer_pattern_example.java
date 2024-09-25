package behavioural_pattern.observer_pattern;
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

class MobileDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Mobile Display updated: " + temperature);
    }
}

public class observer_pattern_example {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        MobileDisplay display = new MobileDisplay();
        station.addObserver(display);
        station.setTemperature(28.0f);
    }
}
