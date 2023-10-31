package raf.dsw.classycraft.app.core.Loggeri;

import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import java.time.LocalDateTime;

public abstract class Logger implements Subscriber {
    String text;
    MessageType type;
    LocalDateTime timeStamp;

    public abstract void Print();

    @Override
    public abstract void update(Object notification);


}