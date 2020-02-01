package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable {

    private WormGame game;
    private int pieceLength;

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Piece piece : game.getWorm().getPieces()) {
            g.setColor(Color.BLACK);
            g.fill3DRect(pieceLength*piece.getX(), pieceLength*piece.getY(), pieceLength, pieceLength, true);
        }

        g.setColor(Color.RED);
        g.fillOval(pieceLength * game.getApple().getX(), pieceLength * game.getApple().getY(), pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
