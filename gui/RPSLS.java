package game.development;

/*
* Created by Frankieee on 10/25/2016
*
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RPSLS extends Frame{
 private Label choiceLabel;
 private Label playerScore;
 private Label computerScore;
 private CheckboxGroup choice;

 private TextArea textResults;
 private Button btn;
 private Dialog message;
 private TextField tfUScore;
 private TextField tfCScore;
 
 private int userChoice;
 private int compChoice;
 private int userScore = 0;
 private int compScore = 0;
 private String userInput;
 private String compInput;
 
 
 public RPSLS() {
  // TODO Auto-generated constructor stub
  setLayout(new FlowLayout());
  
  choiceLabel = new Label("Your Choice");
  choice = new CheckboxGroup();
  
  
  textResults = new TextArea("Results: \n", 4, 25);
    
  message = new Dialog(this, "GAME OVER!", Dialog.ModalityType.DOCUMENT_MODAL);
  message.setSize(200, 160);
  
    message.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    
    Button forMessage1 = new Button("YES");
    Button forMessage2 = new Button("NO");
    final Label gameOver = new Label("GAME OVER", Label.CENTER);
    
    forMessage1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userScore = 0;
                compScore = 0;
                message.setVisible(false);
            }
        });
    
    forMessage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    message.setLayout(new FlowLayout());
    message.add(gameOver);
    message.add(new Label("Wanna play again!??\n", Label.CENTER));
    message.add(forMessage1);
    message.add(forMessage2);
    
    btn = new Button("RockPaperScissorsLizardSpock!");
    btn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Checkbox select = choice.getSelectedCheckbox();
                  
                  userInput = select.getLabel();
                  
                  if(userInput.equals("Rock")){
                      userChoice = 1;
                  } else if(userInput.equals("Paper")){
                      userChoice = 2;
                  } else if(userInput.equals("Scissors")){
                      userChoice = 3;
                  } else if(userInput.equals("Lizard")){
                      userChoice = 4;
                  } else if(userInput.equals("Spock")){
                      userChoice = 5;
                  }
                  textResults.append(String.format("\nPlayer selected: " + userInput));
                  
                  Random rand = new Random();
                  compChoice = rand.nextInt(5) + 1;
                  
                  if(compChoice == 1){
                      compInput = "Rock";
                  } else if(compChoice == 2){
                      compInput = "Paper";
                  } else if(compChoice == 3){
                      compInput = "Scissors";
                  } else if(compChoice == 4){
                      compInput = "Lizard";
                  } else if(compChoice == 5){
                      compInput = "Spock";
                  }
                  textResults.append(String.format("\nComputer selected: " + compInput + "\n"));
                  
                  if(userChoice == 1){
                      if(compChoice == 3 || compChoice == 5){
                          userScore++;
                      }
                      else if(userChoice != compChoice){
                          compScore++;
                      }
                  } else if(userChoice == 2){
                      if(compChoice == 1 || compChoice == 5){
                          userScore++;
                      } else if(userChoice != compChoice){
                          compScore++;
                      }
                  } else if(userChoice == 3){
                      if(compChoice == 2 || compChoice == 4){
                          userScore++;
                      } else if(userChoice != compChoice){
                          compScore++;
                      }
                  } else if(userChoice == 4){
                      if(compChoice == 2 || compChoice == 5){
                          userScore++;
                      } else if(userChoice != compChoice){
                          compScore++;
                      }
                  } else if(userChoice == 5){
                      if(compChoice == 1 || compChoice == 3){
                          userScore++;
                      } else if(userChoice != compChoice){
                          compScore++;
                      }
                  }
                  
                  tfUScore.setText(String.valueOf(userScore));
                  tfCScore.setText(String.valueOf(compScore));
                  
                  if(userScore == 5){
                      textResults.append("\nYOU WIN THIS ROUND!");
                      gameOver.setText(String.format("Game over! PLAYER won.\n"));
                      message.setVisible(true);
                  } else if(compScore == 5){
                      textResults.append("\nCOMPUTER WINS THIS ROUND!");
                      gameOver.setText(String.format("Game over! COMPUTER won.\n"));
                      message.setVisible(true);
                  }
                  tfUScore.setText(String.valueOf(userScore));
                  tfCScore.setText(String.valueOf(compScore));

                  
                  
                  
               //TODO
               // 1-5 (choice)
               // compare choice comp and user
               // update score
               //if score == 5, terminate
               // if user choice == ok, restart, otherwise, exit the games
              }
      });

            playerScore = new Label("Player Score: ");
                  computerScore = new Label("Computer Score: ");
                  tfUScore = new TextField("", 1);
                  tfCScore = new TextField("", 1);

                  
    add(new Checkbox("Rock", choice, false));
    add(new Checkbox("Paper", choice, false));
    add(new Checkbox("Scissors", choice, false));
    add(new Checkbox("Lizard", choice, false));
    add(new Checkbox("Spock", choice, false));
    add(textResults);
    add(btn);
    add(playerScore);
    add(tfUScore);
    add(computerScore);
    add(tfCScore);

          setTitle("ROCK PAPER SCISSORS LIZARD SPOCK ");
          setSize(750, 300);
          setVisible(true);

          // close window
          addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent we) {
                  System.exit(0);
              }
          });
          
   }


   

   public static void main(String[] args) {
    // TODO Auto-generated method stub
    RPSLS play = new RPSLS();
   }
}
