package com.snakeGame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private static final int SCREEN_HEIGHT = 500;
    private static final int SCREEN_WIDTH = 500;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
    }
}
