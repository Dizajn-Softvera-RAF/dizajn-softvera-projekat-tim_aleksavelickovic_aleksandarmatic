package raf.dsw.classycraft.app.core.Loggeri;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;
import raf.dsw.classycraft.app.core.observer.Subscriber;

import java.time.LocalDateTime;

public abstract class Logger implements Subscriber {




    public abstract void Print(Message notification);

    @Override
    public abstract void update(Object notification);

    }
