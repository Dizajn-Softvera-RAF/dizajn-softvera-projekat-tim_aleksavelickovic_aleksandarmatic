package raf.dsw.classycraft.app.core.MessageGenerator;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MessageGeneratorImplementation implements MessageGenerator{
    private ArrayList<Subscriber>subscribers;

    public MessageGeneratorImplementation(){
        subscribers = new ArrayList<>();
    }
    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void generate(String text, MessageType type, LocalDateTime time){
        Message newMessage = new Message(text,type,time);
        ApplicationFramework.getInstance().getMessageGeneratorImplementation().notifySubscribers(newMessage);
        ApplicationFramework.getInstance().log(newMessage);
    }

    @Override
    public void notifySubscribers(Object notification) {
       // if(notification instanceof Message){
            for(Subscriber subscriber:subscribers)
                subscriber.update(notification);

       // }
    }

    public ArrayList<Subscriber> getSubscribers() {
        return subscribers;
    }
}
