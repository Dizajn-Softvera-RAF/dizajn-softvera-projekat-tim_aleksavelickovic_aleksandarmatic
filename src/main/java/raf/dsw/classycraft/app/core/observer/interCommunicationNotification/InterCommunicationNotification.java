package raf.dsw.classycraft.app.core.observer.interCommunicationNotification;

import raf.dsw.classycraft.app.classyRepository.composite.ClassyNode;
import raf.dsw.classycraft.app.core.MessageGenerator.Message;

public class InterCommunicationNotification {
    private String message;
    private ClassyNode classyNode;

    private String content;

    public InterCommunicationNotification(String message, ClassyNode classyNode,String content) {
        this.message = message;
        this.classyNode = classyNode;
        this.content=content;
    }

    public InterCommunicationNotification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClassyNode getClassyNode() {
        return classyNode;
    }

    public void setClassyNode(ClassyNode classyNode) {
        this.classyNode = classyNode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
