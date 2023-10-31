package raf.dsw.classycraft.app.core.Loggeri;

import raf.dsw.classycraft.app.core.MessageGenerator.Message;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.core.MessageGenerator.MessageType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        try {
            FileOutputStream fileStream = new FileOutputStream(fajl,true);
            String string = "["+type+"] ["+timeStamp+"] "+ text;
            write(fileStream,string);
            fileStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
    void write(FileOutputStream stream, String output) throws IOException {
        output = output + System.getProperty("line.separator");
        byte[] data = output.getBytes();
        stream.write(data,0, data.length);
    }
}
