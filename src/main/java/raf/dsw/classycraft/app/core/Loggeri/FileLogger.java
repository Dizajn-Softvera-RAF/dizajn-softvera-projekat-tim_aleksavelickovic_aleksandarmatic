package raf.dsw.classycraft.app.core.Loggeri;

import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class FileLogger extends Logger{
    private File fajl = new File("log.txt");
    MessageGeneratorImplementation mgi;
    public FileLogger(MessageGeneratorImplementation mgi) {
        this.mgi = mgi;
        this.mgi.addSubscriber(this);
    }

    @Override
    public void Print() {
        PrintWriter pw = null;
        String string = "["+type+"] ["+timeStamp+"] "+text;
        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/log.txt")));
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
