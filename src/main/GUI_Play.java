package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import objects.SuperObject;
import org.json.simple.parser.ParseException;
import tiles.TileManager;
import tools.Musicas;

/**
 *
 * @author Mateus CohuzEr
 */
public class GUI_Play extends JPanel implements Runnable {

    //Screen Settings
    final int originalTileSize = 16;
    final int scale = 4;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public Graphics2D g2;

    //WORLD SETTINGS
    public final int maxWorldCol = 64;
    public final int maxWorldRow = 16;
    public final int worldWidth = tileSize * maxScreenCol;
    public final int worldHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    public TileManager tileManager = new TileManager(this);
    Musicas musicas = new Musicas();
    KeyHandler keyHandler = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyHandler);
    public SuperObject obj[] = new SuperObject[10];

    public GUI_Play() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        aSetter.setObject();
        musicas.playSound("D:\\documentos\\GitHub\\Mugen-Project-2\\src\\res\\musics\\dun_dun.wav");
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                try {
                    update();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI_Play.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI_Play.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(GUI_Play.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() throws InterruptedException, IOException, ProtocolException, MalformedURLException, ParseException {
        player.update();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2 = (Graphics2D) g;

        // TILE
        tileManager.draw(g2);

        //OBJECTS
        try {
            for (SuperObject obj1 : obj) {
                if (obj1 != null) {
                    obj1.draw(g2, this);
                }
            }
        } catch (Exception e) {
            System.out.println("GUI_Play load obj error: " + e);
        }

        //PLAYER
        player.draw(g2);

        g2.dispose();
    }
}
