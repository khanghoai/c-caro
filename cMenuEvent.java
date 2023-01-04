import java.awt.event.*;



public class cMenuEvent implements ActionListener{
    viewPro menuEvent;

    public cMenuEvent(viewPro menuEvent){
        this.menuEvent = menuEvent;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuEvent.getMenuNew()){
            menuEvent.newGame();
        }

        if(e.getSource() == menuEvent.getMenuExit()){
            menuEvent.exitMenu();
        }

        if(e.getSource() == menuEvent.getGameNew()){
            menuEvent.playAgain();    
        }

        if(e.getSource() == menuEvent.getGameExit()){
            menuEvent.exitGame();
        }

        if(e.getSource()==menuEvent.getWinNew()){
            if(menuEvent.getTurn() == 2){
                menuEvent.setTurnPl(2);
            }
            else{
                menuEvent.setTurnPl(1);
            }
            menuEvent.playAgain();
        }
        if(e.getSource() == menuEvent.getWinExit()){
            menuEvent.exitGame();
        }
          
        
        
    }
}
