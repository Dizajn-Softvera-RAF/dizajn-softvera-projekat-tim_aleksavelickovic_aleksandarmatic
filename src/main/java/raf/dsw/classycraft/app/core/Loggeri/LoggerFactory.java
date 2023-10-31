package raf.dsw.classycraft.app.core.Loggeri;

import raf.dsw.classycraft.app.core.MessageGenerator.MessageGeneratorImplementation;

public class LoggerFactory {

    public Logger creatLogger(String ime, MessageGeneratorImplementation mgi){
        if(ime.toUpperCase().equals("FILE")){return new FileLogger(mgi);}
        if (ime.toUpperCase().equals("CONSOLE")){return new ConsoleLogger(mgi);}
        else return null;

    }
}
