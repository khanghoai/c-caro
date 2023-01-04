import javax.swing.*;
import java.awt.*;

public class viewPro{
    public static void main(String[] args) {
        new viewPro();
    }

    private final int row=26,col=40,hei=688,wid=1348;
    private JFrame f;
    private JPanel gameMain,gameMenu,winMenu,menu,game;
    private JLabel winName;
    private JButton menuNew,menuExit,gameNew,gameExit,winExit,winNew;
    private JPanel[][] sqa = new JPanel[row][col];
    private JLabel[][] check = new JLabel[row][col];
    private int x,y,turn = 1,turnPl = 1/* 1 or 2 */,win = 0/* 0 or 1 */,point = 0;
    
    public viewPro(){
        f = new JFrame("Cờ caro");
        menu = new JPanel();
        game = new JPanel();
        winMenu = new JPanel();
        gameMain = new JPanel();
        gameMenu = new JPanel();
        winName = new JLabel();
        menuNew = new JButton("Bắt Đầu");
        menuExit = new JButton("Thoát");
        gameNew = new JButton("Chơi Lại");
        gameExit = new JButton("Về trang chủ");
        winExit = new JButton("Về trang chủ");
        winNew = new JButton("Chơi Lại");

        cGameEvent g = new cGameEvent(this);
        cMenuEvent m = new cMenuEvent(this);

        f.setResizable(false);
        f.setSize(wid,hei);
        f.setLayout(null);

        menu.setBounds(483,100,400,500);
        menu.setLayout(null);

        menuNew.setBounds(100,100,200,70);
        menuExit.setBounds(100,230,200,70);
        menuNew.addActionListener(m);
        menuExit.addActionListener(m);

        game.setBounds(0,0,wid,hei);
        game.setLayout(null);
        game.setVisible(false);

        gameMain.setBounds(331,0,1000,650);
        gameMain.setLayout(new GridLayout(row,col));
        gameMain.setBackground(Color.red);
        gameMain.addMouseListener(g);

        gameMenu.setBounds(0,0,331,650);
        gameMenu.setBackground(Color.blue);
        gameMenu.setLayout(null);

        winMenu.setBackground(Color.blue);
        winMenu.setLayout(null);
        winMenu.setBounds(700,200,250,300);
        winMenu.setVisible(false);

        gameNew.setBounds(43,300,250,50);
        gameNew.addActionListener(m);
        gameExit.setBounds(43,380,250,50);
        gameExit.addActionListener(m);
        winName.setBounds(54,10,350,30);
        winName.setForeground(Color.red);
        winExit.setBounds(50,100,150,50);
        winExit.addActionListener(m);
        winNew.setBounds(50,170,150,50);
        winNew.addActionListener(m);

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sqa[i][j] = new JPanel();
                sqa[i][j].setSize(25, 25);
                sqa[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                sqa[i][j].setBackground(Color.lightGray);
                check[i][j] = new JLabel("");
                sqa[i][j].add(check[i][j]);
                gameMain.add(sqa[i][j]);
            }
        }

        winMenu.add(winName);
        winMenu.add(winExit);
        winMenu.add(winNew);
        gameMenu.add(gameNew);
        gameMenu.add(gameExit);

        menu.add(menuNew);
        menu.add(menuExit);
        
        game.add(gameMain);
        game.add(gameMenu);

        f.add(winMenu);
        f.add(menu);
        f.add(game);
        f.setLayout(null);
        f.setVisible(true);
    }

    public JButton getMenuNew(){
        return menuNew;
    }

    public void newGame(){
        turnPl = 1;
        playAgain();
        game.setVisible(true);
        menu.setVisible(false);
    }

    public JButton getMenuExit(){
        return menuExit;
    }

    public void exitMenu(){
        System.exit(0);
    }

    public JButton getGameNew(){
        return gameNew;
    }

    public JButton getGameExit(){
        return gameExit;
    }

    public void playAgain(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                check[i][j].setText("");
            }
        }
        winMenu.setVisible(false);
        sqa[y][x].setBorder(BorderFactory.createLineBorder(Color.black));
        win = 0;
        point = 0;
        turn = turnPl;
    }

    public void exitGame(){
        game.setVisible(false);
        menu.setVisible(true);
        winMenu.setVisible(false);
    }
    
    public JButton getWinExit(){
        return winExit;
    }

    public JButton getWinNew(){
        return winNew;
    }

    public String getStrAgW(){
        return winNew.getText();
    }

    public void setWinPl(){
        winMenu.setVisible(true);
        if(turn == 2){
            winName.setText("Người chơi 1 chiến thăng");
        }
        else{
            winName.setText("Người chơi 2 chiến thăng");
        }
    }

    public void setSqr(int x,int y){
        if(turn == 1){
            check[y][x].setText("X");
            check[y][x].setForeground(Color.red);
            turn =2;
        }
        else{
            check[y][x].setText("O");
            check[y][x].setForeground(Color.blue);
            turn =1;
        }
    }

    public void setChose(int nX,int nY){
        sqa[nY][nX].setBorder(BorderFactory.createLineBorder(Color.red));
        sqa[y][x].setBorder(BorderFactory.createLineBorder(Color.black));
        x = nX;
        y = nY;
    }

    public String getCheck(int x,int y){
        return check[y][x].getText();
    }

    public int getTurn(){
        return turn;
    }

    public void setTurn(int x){
        turn = x;
    }

    public int getWin(){
        return win;
    }

    public void setWin(int x){
        win = x;
    }

    public void setPoint(int x){
        point = x;
    }

    public int getPoint(){
        return point;
    }

    public int getTurnPl(){
        return turnPl;
    }

    public void setTurnPl(int x){
        turnPl = x;
    }
}
