import java.awt.event.*;

class cGameEvent implements MouseListener{
    viewPro gameEvent;
    private int i;


    public cGameEvent(viewPro gameEvent){
        this.gameEvent = gameEvent;
    }

    public void mouseClicked(MouseEvent e) {
        int x = (e.getX())/25;
        int y = (e.getY())/25;  
        if(gameEvent.getCheck(x, y)== "" && gameEvent.getWin() == 0){
            gameEvent.setSqr(x,y);
            gameEvent.setChose(x, y);
            for(i=-4;i<=4;i++){
                if(gameEvent.getCheck(x, y).equals(gameEvent.getCheck(x+i, y))){
                    gameEvent.setPoint(gameEvent.getPoint() +1);
                }
                else if(gameEvent.getPoint() <5){
                    gameEvent.setPoint(0);
                }
            }
            if(gameEvent.getPoint()>=5){
                gameEvent.setWinPl();
                gameEvent.setWin(1);
            }
            for(i=-4;i<=4;i++){
                if(gameEvent.getCheck(x, y).equals(gameEvent.getCheck(x, y+i))){
                    gameEvent.setPoint(gameEvent.getPoint() +1);
                }
                else if(gameEvent.getPoint() <5){
                    gameEvent.setPoint(0);
                }
            }
            if(gameEvent.getPoint()>=5){
                gameEvent.setWinPl();
                gameEvent.setWin(1);
            }
            for(i=-4;i<=4;i++){
                if(gameEvent.getCheck(x, y).equals(gameEvent.getCheck(x+i, y+i))){
                    gameEvent.setPoint(gameEvent.getPoint() +1);
                }
                else if(gameEvent.getPoint() <5){
                    gameEvent.setPoint(0);
                }
            }
            if(gameEvent.getPoint()>=5){
                gameEvent.setWinPl();
                gameEvent.setWin(1);
            }
            for(i=-4;i<=4;i++){
                if(gameEvent.getCheck(x, y).equals(gameEvent.getCheck(x+i, y-i))){
                    gameEvent.setPoint(gameEvent.getPoint() +1);
                }
                else if(gameEvent.getPoint() <5){
                    gameEvent.setPoint(0);
                }
            }
            if(gameEvent.getPoint()>=5){
                gameEvent.setWinPl();
                gameEvent.setWin(1);
            }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

}
