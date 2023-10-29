package raf.dsw.classycraft.app.core.observer;

public interface Pubsliher {
    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscribers(Object notification);
}
