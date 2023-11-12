package raf.dsw.classycraft.app.core.Loggeri;

import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;

import java.io.*;

public class FileLogger extends Logger{
    File fajl = new File("src/main/resources/log.txt");
    MessageGeneratorImplementation mgi;
    public FileLogger(MessageGeneratorImplementation mgi) {
        this.mgi = mgi;
        this.mgi.addSubscriber(this);
    }

    @Override
    public void Print(Message notification) {
        PrintWriter pw = null;
        String string = "["+notification.getType() +"] ["+notification.getTimestamp()+"] "+notification.getText()+"\n";
        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(fajl,true)));
            pw.println(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (pw !=null)pw.close();
        }
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Message){
            Print((Message) notification);
        }

    }

}
