package gui;

import java.util.*;

//import javax.swing.JFrame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class Game extends Frame {

	private Label lblYourchoice;
	private Label lblPlayerSc;
	private Label lblComputerSc;
	private TextField playerScInput;
	private TextField computerScInput;
	private Button btnGame;
	private TextArea result;
//	private TextArea playerChose;
//	private TextArea computerChose;
//	private TextArea whoWin;
	public CheckboxGroup cbg;
	public Checkbox chkrock;
	public Checkbox chkpaper;
	public Checkbox chkscissors;
	public Checkbox chklizard;
	public Checkbox chkspock;
	public Checkbox chk;
	private String playerSelect;
	private String compSelect;
	
	private int playerPoints = 0;
	private int previousPlayerSc = 0;
	private int computerPoints = 0;
	private int previousCompSc = 0;;

public Game() {
	
	
	
	setLayout(new FlowLayout());
	lblYourchoice = new Label("Your Choice:");
	
	setLayout(new GridLayout(5,1));
	
	cbg = new CheckboxGroup();
	chkrock = new Checkbox("Rock", cbg, true);
	chkpaper = new Checkbox("Paper", cbg, false);
	chkscissors = new Checkbox("Scissors", cbg, false);
	chklizard = new Checkbox("Lizard", cbg, false);
	chkspock = new Checkbox("Spock", cbg, false);
	
	result = new TextArea("Results:", 60, 30);
//	playerChose = new TextArea("", 70, 30);
//	computerChose = new TextArea("", 80, 30);
	//whoWin = new TextArea("", 90, 30);
	
	
	btnGame = new Button("RockPaperScissorsLizardSpock");

	lblPlayerSc = new Label("Player's Score");
	playerScInput = new TextField("0", 20);
	lblComputerSc = new Label("Computer's Score");
	computerScInput = new TextField("0", 20);
	
	btnGame.addActionListener(new MyActionListener());
	
	// add them to container
    add(lblYourchoice);
    add(lblPlayerSc);
    add(lblComputerSc);
    add(playerScInput);
    add(computerScInput);
    add(btnGame);
    add(result);
    add(chkrock);
    add(chkpaper);
    add(chkscissors);
    add(chklizard);
    add(chkspock);
    
    
    
	setTitle("RockPaperScissorsLizardSpock");
	setSize(800, 1000);
	setVisible(true);
	// close window
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    });
}

	//inner class
	class MyActionListener extends Applet implements ActionListener, ItemListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		//	while(playerPoints != 5 || computerPoints != 5){
				
				String[] arr = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
				Random random = new Random();
			
				//randomly selects an index from the arr
				int select = random.nextInt(arr.length);
				compSelect = arr[select];
				result.insert("Computer chose " + compSelect, 10);
				
				//register a listener for the check boxes
				chkrock.addItemListener(this);
				chkpaper.addItemListener(this);
				chkscissors.addItemListener(this);
				chklizard.addItemListener(this);
				chkspock.addItemListener(this);
			
				chk = cbg.getSelectedCheckbox();
				playerSelect = chk.getLabel();
			
				if((playerSelect == "Rock" && compSelect == "Lizard") || (playerSelect == "Rock" && compSelect == "Scissors") 
						|| (playerSelect == "Lizard" && compSelect == "Hand") || (playerSelect == "Lizard" && compSelect == "Spock")
						|| (playerSelect == "Hand" && compSelect == "Rock") || (playerSelect == "Hand" && compSelect == "Spock")
						|| (playerSelect == "Scissors" && compSelect == "Hand") || (playerSelect == "Scissors" && compSelect == "Lizard")
						|| (playerSelect == "Spock" && compSelect == "Rock") || (playerSelect == "Spock" && compSelect == "Scissors")) {
					playerPoints++;
					previousPlayerSc = Integer.parseInt(playerScInput.getText());
					//convert int to string to be able na ma butang sa text field
					playerScInput.setText(Integer.toString(previousPlayerSc + playerPoints));
					System.out.println("Player chose " + playerSelect + " and computer chose " + compSelect + "\nPlayerPoints: " + playerPoints);
					System.out.println("Player has won in this turn");
				} else if((compSelect == "Rock" && playerSelect == "Lizard") || (compSelect == "Rock" && playerSelect == "Scissors") 
						|| (compSelect == "Lizard" && playerSelect == "Hand") || (compSelect == "Lizard" && playerSelect == "Spock")
						|| (compSelect == "Hand" && playerSelect == "Rock") || (compSelect == "Hand" && playerSelect == "Spock")
						|| (compSelect == "Scissors" && playerSelect == "Hand") || (compSelect == "Scissors" && playerSelect == "Lizard")
						|| (compSelect == "Spock" && playerSelect == "Rock") || (compSelect == "Spock" && playerSelect == "Scissors")) {
					computerPoints++;
					previousCompSc = Integer.parseInt(computerScInput.getText());
					computerScInput.setText(Integer.toString(previousCompSc + computerPoints));					
					System.out.println("Player chose " + playerSelect + " and computer chose " + compSelect + "\nComputerPoints: " + computerPoints);
					System.out.println("Computer has won in this turn");
				}
		//	}
			
//			if(playerPoints == 5)
//				System.out.println("Player has won!");
//			else if(computerPoints == 5)
//				System.out.println("Computer has won!");
		}
	
		
		public void itemStateChanged(ItemEvent arg0) {
			if(chk.getState() == true) 
				result.insert("Player chose " + playerSelect, 20);
			}	
		}

	public static void main(String[] args) {
		new Game();
	}
}