package org.example.model;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Layout {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel title;
    private JButton startButton;
    private JButton exitButton;

    public Layout() {
        frame = new JFrame();
        startButton = new JButton("START");
        exitButton = new JButton("EXIT");
        title = new JLabel("BATTLESHIP");
        mainPanel = new JPanel(new GridBagLayout());

        List<JButton> layoutButtons = initLayout();
    }

    private List<JButton> initLayout(){

    }
}
