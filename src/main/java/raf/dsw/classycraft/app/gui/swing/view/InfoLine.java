package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class InfoLine extends JPanel {
    private JLabel projectLabel = new JLabel(" ");
    private JLabel authorLabel = new JLabel(" ");

    public InfoLine() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        projectLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        authorLabel.setAlignmentX(LEFT_ALIGNMENT);
        add(projectLabel);
        add(authorLabel);
    }

    public void populate(String projectName, String author) {
        this.projectLabel.setText(projectName);
        this.authorLabel.setText(" | Author: " +  author);
        Font font1 = new Font(projectLabel.getFont().getName(), Font.PLAIN, 14);
        projectLabel.setFont(font1);
        authorLabel.setFont(font1);
        repaint();
    }

    public JLabel getAuthorLabel() {
        return authorLabel;
    }

    public JLabel getProjectLabel() {
        return projectLabel;
    }

    public void setupAuthor(String author) {
        this.authorLabel.setText(" | Author: " +  author);
        repaint();
    }

    public void setupProjectName(String project) {
        this.projectLabel.setText(project);
        repaint();
    }

    public void clear() {
        this.authorLabel.setText(" ");
        this.projectLabel.setText(" ");
        repaint();
    }

}
