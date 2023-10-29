package raf.dsw.classycraft.app.core.MessageGenerator;

import raf.dsw.classycraft.app.core.observer.Pubsliher;
import raf.dsw.classycraft.app.core.observer.Subscriber;


public interface MessageGenerator extends Pubsliher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers(Object notification);
}
