package raf.dsw.classycraft.app.core.MessageGenerator;

import raf.dsw.classycraft.app.core.observer.Subscriber;

import java.util.ArrayList;

public class MessageGeneratorImplementation implements MessageGenerator{
    private ArrayList<Subscriber>subscribers;

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification instanceof Message){
            for(Subscriber subscriber:subscribers)
                subscriber.update(notification);

        }
    }
}
