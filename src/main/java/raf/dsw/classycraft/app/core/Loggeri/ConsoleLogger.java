package raf.dsw.classycraft.app.core.Loggeri;

import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;

public class ConsoleLogger extends Logger{
    MessageGeneratorImplementation mgi;
    public ConsoleLogger(MessageGeneratorImplementation mgi) {
        this.mgi = mgi;
        this.mgi.addSubscriber(this);
    }

    @Override
    public void Print() {
        System.out.println("["+type +"] ["+timeStamp+"] "+text);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Message){
            text = ((Message) notification).getText();
            type = ((Message) notification).getType();
            timeStamp = ((Message) notification).getTimestamp();
            Print();
        }
        else {
            text = "";
            type = null;
            timeStamp =null;
        }
    }
}