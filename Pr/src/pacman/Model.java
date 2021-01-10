package pacman;

import java.awt.*;
import java.awt.dnd.DropTargetAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.PropertyResourceBundle;
import javax.swing.*;

public class Model extends JPanel implements ActionListener {

    private Dimension d;
    private final Font font = new Font("Arial", Font.BOLD, 16);
    private boolean inGame = false;
    private boolean dead = false;

    private final int BLOCK_SIZE = 24;
    private final int BLOCK_NUMBER = 15;
    private final int SCREEN = BLOCK_NUMBER * BLOCK_SIZE;
    private final int NR_GHOSTS_MAX = 12;
    private final int PACMAN_SPEED = 6;

    private int NR_GHOSTS = 6;
    private int lives, score,score1;
    private int[] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    private Image heart, ghost;
    private Image up, down, left, right;
    private int pacman_x, pacman_y, pacman_dx, pacman_dy;
    private int req_dx, req_dy;

    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private final int maxSpeed = 6;
    private int currentSpeed = 3;
    private short[] screenData;
    private Timer timer;
    private final short levelData[] = {
            19, 26, 26, 18 , 26, 26, 26, 22, 0 , 19, 26, 26, 26, 26, 22,
            21,  0,  0,  21,  0,  0,  0, 21, 0 , 21, 0 , 0 , 0 , 0 , 21,
            21,  0,  0,  21,  0,  0,  0, 21, 0 , 21, 0 , 0 ,  0, 0 , 21,
            17, 26, 26,  16, 26, 18, 26, 24,26 , 24, 26, 18, 26, 18, 28,
            21,  0,  0,  21,  0, 21,  0, 0 , 0 ,  0,  0, 21, 0 , 21, 0 ,
            25, 26, 26,  20,  0, 25, 26, 22, 0 , 19, 26, 28, 0 , 21, 0 ,
            0 ,  0,  0,  21,  0, 0 ,  0, 21, 0 , 21, 0 , 0 , 0 , 21, 0 ,
            0 ,  0,  0,  21,  0, 19, 26, 24, 26, 24, 26, 22, 0 , 21, 0 ,
            19, 26, 26,  24, 18, 28, 0 , 0 , 0 , 0 , 0 , 17, 18, 24, 22,
            21,  0,  0,   0, 21, 0, 19, 26, 22 ,0 , 19, 24, 20, 0 , 21,
            25, 26, 22,  0, 21,  0, 21,  0, 17, 26, 28, 0 , 25, 26, 20,
            0,   0, 21,  0, 21,  0, 21, 0 , 21, 0 , 0 , 0 , 0 , 0 , 21,
            19, 26, 24, 26, 28,  0, 25, 18, 24, 26, 22, 0 , 19, 26, 20,
            21,  0,  0,  0,  0,  0,  0, 21, 0 , 0 , 21, 0 , 21, 0 , 21,
            25, 26, 26, 26, 26, 26, 26, 28, 0 , 0 , 25, 26, 24, 26, 28
    };

    public Model() {
        loadImg();
        init();
        addKeyListener(new Tadapter());
        setFocusable(true);
        initGame();
    }

    public void showIntro(Graphics2D g2d) {
        String start = "Press SPACE";
        g2d.setColor(Color.yellow);
        g2d.drawString(start, 150, 210);
    }

    public void drawScore(Graphics2D g2d) {
        g2d.setFont(font);
        g2d.setColor(Color.GREEN);
        String s = "SCORE:" + score;
        g2d.drawString(s, 290, SCREEN + 16);
        for (int i = 0; i < lives; i++) {
            g2d.drawImage(heart, i * 35, SCREEN + 3, this);
        }
    }
    private void checkMaze() {

      boolean finished=false;
      if (score1==134) {
          score1=0;
          finished = true;
      }

        if (finished) {

            score += 50;

            if (NR_GHOSTS < NR_GHOSTS_MAX) {
                NR_GHOSTS++;
            }

            if (currentSpeed < maxSpeed) {
                currentSpeed++;
            }
            initLevel();
        }
    }

    private void loadImg() {
        down = new ImageIcon("C:\\Users\\Andrei\\IdeaProjects\\Pr\\src\\images\\move3.gif").getImage();
        up = new ImageIcon("C:\\Users\\Andrei\\IdeaProjects\\Pr\\src\\images\\move4.gif").getImage();
        left = new ImageIcon("C:\\Users\\Andrei\\IdeaProjects\\Pr\\src\\images\\move2.gif").getImage();
        right = new ImageIcon("C:\\Users\\Andrei\\IdeaProjects\\Pr\\src\\images\\move.gif").getImage();
        ghost = new ImageIcon("C:\\Users\\Andrei\\IdeaProjects\\Pr\\src\\images\\fantoma.png").getImage();
        heart = new ImageIcon("C:\\Users\\Andrei\\IdeaProjects\\Pr\\src\\images\\inima.png").getImage();

    }

    private void init() {
        screenData = new short[BLOCK_NUMBER * BLOCK_NUMBER];
        d = new Dimension(400, 400);
        ghost_x = new int[NR_GHOSTS_MAX];
        ghost_dx = new int[NR_GHOSTS_MAX];
        ghost_y = new int[NR_GHOSTS_MAX];
        ghost_dy = new int[NR_GHOSTS_MAX];
        ghostSpeed = new int[NR_GHOSTS_MAX];
        dx = new int[4];
        dy = new int[4];
        pacman_x=10*BLOCK_SIZE;
        pacman_y=10*BLOCK_SIZE;
        timer = new Timer(40, this);
        timer.start();
    }


    private void initGame() {
        lives = 3;
        score = 0;
        NR_GHOSTS=4;
        initLevel();
        currentSpeed = 3;
    }

    private void initLevel() {
        int i;
        for (i = 0; i < BLOCK_NUMBER * BLOCK_NUMBER; i++) {
            screenData[i] = levelData[i];
        }
        i=0;
        int random;
        int dx=1;
        for ( i = 0; i < NR_GHOSTS; i++) {
            ghost_y[i] = 4 * BLOCK_SIZE;
            ghost_x[i] = 4 * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));
            if (random > currentSpeed) {
                random = currentSpeed;
            }
            ghostSpeed[i] = validSpeeds[random];
        }
    }

    private void playgame(Graphics2D g2d) {
        if (dead) {
            death();
        } else {
            movePacman();
            drawPacman(g2d);
            moveGhosts(g2d);
            checkMaze();
        }
    }


    public void movePacman() {
        int pos;
        short ch;

        if (pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
            pos = pacman_x / BLOCK_SIZE + BLOCK_NUMBER * (int) (pacman_y / BLOCK_SIZE);
            ch = screenData[pos];
            if ((ch & 16) != 0) {
                screenData[pos] =(short)(ch & 15);
                score++;
                score1++;
            }
            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacman_dx = req_dx;
                    pacman_dy = req_dy;
                }
            }
            if ((pacman_dx == -1 && pacman_dy == 0 && (ch & 1) != 0)
                    || (pacman_dx == 1 && pacman_dy == 0 && (ch & 4) != 0)
                    || (pacman_dx == 0 && pacman_dy == -1 && (ch & 2) != 0)
                    || (pacman_dx == 0 && pacman_dy == 1 && (ch & 8) != 0)) {
                pacman_dx = 0;
                pacman_dy = 0;
            }
        }

    pacman_x =pacman_x +PACMAN_SPEED *pacman_dx;
    pacman_y =pacman_y +PACMAN_SPEED *pacman_dy;
}
    private void moveGhosts(Graphics2D g2d) {

        int pos;
        int count;

        for (int i = 0; i < NR_GHOSTS; i++) {
            if (ghost_x[i] % BLOCK_SIZE == 0 && ghost_y[i] % BLOCK_SIZE == 0) {
                pos = ghost_x[i] / BLOCK_SIZE + BLOCK_NUMBER * (int) (ghost_y[i] / BLOCK_SIZE);

                count = 0;

                if ((screenData[pos] & 1) == 0 && ghost_dx[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && ghost_dy[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && ghost_dx[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && ghost_dy[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screenData[pos] & 15) == 15) {
                        ghost_dx[i] = 0;
                        ghost_dy[i] = 0;
                    } else {
                        ghost_dx[i] = -ghost_dx[i];
                        ghost_dy[i] = -ghost_dy[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghost_dx[i] = dx[count];
                    ghost_dy[i] = dy[count];
                }

            }

            ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeed[i]);
            ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeed[i]);
            drawGhost(g2d, ghost_x[i] + 1, ghost_y[i] + 1);

           if (pacman_x > (ghost_x[i] - 12) && pacman_x < (ghost_x[i] + 12)
                    && pacman_y > (ghost_y[i] - 12) && pacman_y < (ghost_y[i] + 12)
                    && inGame) {

                dead = true;
            }
        }
    }
    public void drawPacman(Graphics2D g2d) {
        if (req_dx == -1) {
            g2d.drawImage(left, pacman_x, pacman_y , this);
        } else if (req_dx == 1) {
            g2d.drawImage(right, pacman_x , pacman_y , this);
        } else if (req_dy == -1) {
            g2d.drawImage(up, pacman_x , pacman_y , this);
        } else {
            g2d.drawImage(down, pacman_x , pacman_y , this);
        }
    }



    public void drawGhost(Graphics2D g2d, int x, int y) {
        g2d.drawImage(ghost, x, y, this);
    }

    private void continueLevel() {
        int dx = 1;
        int random;
        for (int i = 0; i < NR_GHOSTS; i++) {
            ghost_y[i] = 4 * BLOCK_SIZE;
            ghost_x[i] = 4 * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));
            if (random > currentSpeed) {
                random = currentSpeed;
            }
            ghostSpeed[i] = validSpeeds[random];
        }
        pacman_x = 10*BLOCK_SIZE;
        pacman_y = 10*BLOCK_SIZE;
        pacman_dx = 0;
        pacman_dy = 0;
        req_dx = 0;
        req_dy = 0;
        dead = false;

    }


 private void death(){
        lives--;
        if(lives==0){
            inGame=false;
        }
    continueLevel();
    }

    public void drawMaze(Graphics2D g2d){
        short i=0;
        int x,y;
        for(y=0;y<SCREEN;y+=BLOCK_SIZE){
            for(x=0;x<SCREEN;x+=BLOCK_SIZE){
                g2d.setColor(new Color(0,72,251));
                g2d.setStroke(new BasicStroke(5));
                if(levelData[i] == 0){
                    g2d.fillRect(x,y,BLOCK_SIZE,BLOCK_SIZE);
                }
                if((screenData[i]&1)!=0){
                    g2d.drawLine(x,y,x,y+BLOCK_SIZE-1);
                }
                if((screenData[i]&2)!=0){
                    g2d.drawLine(x,y,x+BLOCK_SIZE-1,y);
                }
                if((screenData[i]&4)!=0){
                    g2d.drawLine(x+BLOCK_SIZE-1,y,x+BLOCK_SIZE-1,y+BLOCK_SIZE-1);
                }
                if((screenData[i]&8)!=0){
                    g2d.drawLine(x,y+BLOCK_SIZE-1,x+BLOCK_SIZE-1,y+BLOCK_SIZE-1);
                }
                if((screenData[i]&16)!=0){
                    g2d.setColor(new Color(255,255,255));
                    g2d.fillOval(x+10,y+10,6,6);

                }
                i++;
            }
        }
        g2d.setColor(new Color(0,72,251));
        g2d.drawLine(359,95,359,191);
        g2d.drawLine(191,359,263,359);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0,0,500,500);
        drawMaze(g2d);
        drawScore(g2d);

        if (inGame){
            playgame(g2d);
        } else {
            showIntro(g2d);

        }
    Toolkit.getDefaultToolkit().sync();
    }


class Tadapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            if (inGame){
                if(key==KeyEvent.VK_LEFT){
                    req_dx=-1;
                    req_dy=0;
                }
                else if(key==KeyEvent.VK_RIGHT){
                    req_dx=1;
                    req_dy=0;
                }
               else if(key==KeyEvent.VK_UP){
                    req_dx=0;
                    req_dy=-1;
                }
               else if(key==KeyEvent.VK_DOWN){
                    req_dx=0;
                    req_dy=1;
                }
               else if (key==KeyEvent.VK_ESCAPE && timer.isRunning()){
                   inGame=false;
                }
            } else {
                if (key== KeyEvent.VK_SPACE){
                    inGame=true;
                    initGame();
                }
            }

        }
}

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}