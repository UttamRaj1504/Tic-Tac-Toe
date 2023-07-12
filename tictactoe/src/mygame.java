import com.sun.source.doctree.StartElementTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mygame extends JFrame implements ActionListener {
JLabel heading,clockLabel ;
Font font = new Font("ALGERIAN",Font.BOLD,40);
JPanel mainPanel;
JButton []btns = new JButton[9];

int gamechances[] ={2,2,2,2,2,2,2,2,2};
int activeplayer =0;
int wps[][]= {
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}};
int winner =2;
boolean gameover = false;


    public mygame() {

        setTitle("Tic Tac Toe");
        setSize(500, 500);
        ImageIcon icon = new ImageIcon("src/img/OIP2.jpeg");
        setIconImage(icon.getImage());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
creategui();
        setVisible(true);


    }


    private void creategui(){

        this.getContentPane().setBackground(Color.decode("#000000"));
        this.setLayout(new BorderLayout());

        heading = new JLabel("Tic Tac Toe");
        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
this.add(heading, BorderLayout.NORTH);

clockLabel = new JLabel("Enjoy");
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setFont(font);
clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
this.add(clockLabel, BorderLayout.SOUTH);
// pannel section *************
   mainPanel= new JPanel();
   mainPanel.setLayout(new GridLayout(3,3));
   for(int i =1; i<=9; i++){
       JButton btn = new JButton(  "");

       btn.setIcon(new ImageIcon("src/img/img_3.png"));
       btn.setFont(font);
       mainPanel.add(btn);
       btns[i-1]=btn;
       btn.addActionListener(this);
       btn.setName(String.valueOf(i-1));
   }
   this.add(mainPanel, BorderLayout.CENTER);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton)e.getSource();
        String nameStr= currentButton.getName();
        System.out.println(nameStr);

        int name = Integer.parseInt(nameStr.trim());

        if(gameover){
            JOptionPane.showMessageDialog(this ,"Game Over ");
            return ;
        }

        if(gamechances[name]==2){
            if(activeplayer==1){
                currentButton.setIcon(new ImageIcon("src/img/img_1.png"));

                gamechances[name]=activeplayer;
                activeplayer =0;
            }
            else{
                currentButton.setIcon(new ImageIcon("src/img/img_2.png"));
                gamechances[name]=activeplayer;
                activeplayer=1;
            }


            for(int []temp :wps){
                if((gamechances[temp[0]]== gamechances[temp[1]]) &&  (gamechances[temp[1]]==gamechances[temp[2]]) &&(gamechances[temp[2]]!=2)  ){

winner =gamechances[temp[0]];
gameover = true ;
JOptionPane.showMessageDialog(null, "Player"+ winner +"has won the game");

int i =JOptionPane.showConfirmDialog(this ,"Do you want to play this game more");
if(i==0){
    this.setVisible(false);
    new mygame();
}
else if(i==1){
    System.exit(8832);
}
else{}
                    System.out.println(i);
                    break;

                }
            }


            int c = 0;
            for(int x : gamechances){
                if(x==2){
                    c++;
                    break;
                }
            }
            if(c==0 && gameover==false){
                JOptionPane.showMessageDialog(null, "Its Draw");
                int i = JOptionPane.showConfirmDialog(this , "Play more ??");
                if(i==0){
                    this.setVisible(false);
new mygame();
                }
                else if(i==1){
                    System.exit(265);

                }
                gameover= true;

            }

        }
        else{
            JOptionPane.showMessageDialog(this, "position already occupied");
        }
    }
}
