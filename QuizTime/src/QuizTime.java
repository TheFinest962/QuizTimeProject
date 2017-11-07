import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

//Main class
public class QuizTime {
  
  //Main Method
  public static void main(String[] args) {
    new QuizTime();
  }
  
//Create new frame
//Run a UIManager to change the look and feel of the buttons and Jframe
//Add the list of questions to Jframe
  public QuizTime() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | NullPointerException ex) {
          ex.printStackTrace();
        }
        
        List<Question> quiz = new ArrayList<>(30);
        quiz.add(new ChoiceQuestion("Where is Japan Located?", "Asia", "North America", "Africa", "Europe", "Asia"));
        quiz.add(new ChoiceQuestion("In what year was the U.S. Constitution Written?", "1787", "1790", "1788", "1787" , "1789"));
        quiz.add(new ChoiceQuestion("What does the Roman Number 'L' Stand for?", "50", "100", "150", "200", "50"));
        quiz.add(new ChoiceQuestion("What is the smallest state in the United States", "Rhode Island", "Connecticut", "Delware", "Rhode Island", "New Jersey"));
        quiz.add(new ChoiceQuestion("What is a meteor called when it reaches earth?", "Meteorite", "Meteorite", "A rock", "Shooting Star", "A comet"));
        quiz.add(new ChoiceQuestion("Which of the following is a mammal?", "Platypus", "Frog", "Dinosaur", "Platypus", "Alligator"));
        quiz.add(new ChoiceQuestion("Who wrote the famous chinese military treatise know as 'The Art of War'?", "Sun Tzu", "Gou Ziyi", "Sun Tzu", "Li Guang", "Xiang Yu"));
        quiz.add(new ChoiceQuestion("What animal is the symbol of the U.S. Democratic Party?", "Donkey", "Horse", "Elephant", "Donkey", "Dog"));
        quiz.add(new ChoiceQuestion("How old must someone be to run for president of the United States?", "35" , "35", "40", "45", "30"));
        quiz.add(new ChoiceQuestion("Who was the first president to live in the white house?", "John adams" , "George Washington","John Adams", "Thomas Jefferson", "Richard Nixon"));
        quiz.add(new ChoiceQuestion("In 1893, which country became the first to give women the right to vote?", "New Zealand", "American", "England", "France", "New Zealand"));
        quiz.add(new ChoiceQuestion("What is the fear of clowns called?", "Coulrophobia", "Arachnophobia", "Coulrophobia", "Caligynephobia", "Clinophobia"));
        quiz.add(new ChoiceQuestion("Who is the supreme leader of North Korea?", "Kim Jong Un", "Vladmir Putin", "Barack Obama", "Kim Jong Un", "The Queen"));
        quiz.add(new ChoiceQuestion("The statue of liberty was a gift to the U.S. from what country?", "France", "England", "Germany", "Canada", "France"));
        quiz.add(new ChoiceQuestion("In what year was the first iPhone released?", "2007", "2004", "2005", "2006", "2007"));
        quiz.add(new ChoiceQuestion("St. Patricks day was originially associated with what color?", "Blue", "Blue", "Orange", "Always Green", "None of the above"));
        quiz.add(new ChoiceQuestion("How many feet are in a mile?", "5280", "4560", "7640", "5280", "1730"));
        quiz.add(new ChoiceQuestion("In what year did the french revolution begin?", "1789", "1790", "1789", "1720", "1769"));
        quiz.add(new ChoiceQuestion("Who was the first billionaire in the U.S?", "John Rockefeller", "Donald Trump", "John Rockefeller", "Henry Ford", "Bill Gates"));
        quiz.add(new ChoiceQuestion("What is the abreviation of Potassium?", "K", "P", "Po", "K", "R"));
        quiz.add(new ChoiceQuestion("How many ounces are in a galon?", "128", "128", "64", "256", "32"));
        quiz.add(new ChoiceQuestion("In what year did WW2 end?", "1945", "1914", "1960", "1945", "1930"));
        quiz.add(new ChoiceQuestion("What is the only fruit that caries its seed on the outside?", "Strawberries", "Apples", "Strawberries", "Kiwi", "None of the above"));
        quiz.add(new ChoiceQuestion("What was the first planet discovered with a telescope in 1781?", "Uranus", "Mars", "Saturn", "Uranus", "None of the above"));
        quiz.add(new ChoiceQuestion("What is the diameter of the earth?", "8000 mi", "10000 mi", "20000", "8000", "15000"));
        quiz.add(new ChoiceQuestion("What is the worlds biggest island?", "Greenland", "IceLand", "Easter Island", "GreenLand", "Great Britian"));
        quiz.add(new ChoiceQuestion("What is the worlds longest river?", "Amazon River", "Amazon River", "Mississippi River", "Nile river", "None of the above"));
        quiz.add(new ChoiceQuestion("Oneirophobia is the fear of:", "Dreams", "Tight spaces", "Being alone", "Missing out", "Dreams"));
        quiz.add(new ChoiceQuestion("Who freed India from the opression of Great Britian", "Ghandi", "Mughal", "Ghandi", "Singh", "Vajpayee"));
        quiz.add(new ChoiceQuestion("What does the 'C' in 'LCD' stand for?","Crystal", "Crystal", "Carbon", "Compact", "LCD doesn't stand for anything"));
        
          
        JFrame frame = new JFrame("QUIZ TIME!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QuizPane(quiz));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }
  
//Create Quiz
//next and intro buttons along with the Panel
//Main Panel you will see on startup and after the quiz has finished
  @SuppressWarnings("serial")
public class QuizPane extends JPanel {
    
    private List<Question> quiz;
    
    private JButton next;
    private JLabel score;
    
    private CardLayout cardLayout;
    private int currentQuestion;
    private int totalCorrect;
    
    private JPanel QuestionsPanel;
    
    public QuizPane(List<Question> quiz) {
      this.quiz = quiz;
      cardLayout = new CardLayout();
      QuestionsPanel = new JPanel(cardLayout);
      QuestionsPanel.setBorder(new EmptyBorder(40,45,40,45));
      
      JButton start = new JButton("Start");
      start.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          currentQuestion = -1;
          nextQuestion();
          
        }
      });
      
      JButton intro = new JButton("Instructions");
      intro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          instructionBox();
        }
      });
      
      JPanel mainPanel = new JPanel(new GridBagLayout());
      mainPanel.add(start);
      mainPanel.add(intro);
      QuestionsPanel.add(mainPanel, "start");
      
      for (int index = 0; index < quiz.size(); index++) {
        Question question = quiz.get(index);
        QuestionPane pane = new QuestionPane(question);
        question.setButtonGroup(pane.getButtonGroup());
        QuestionsPanel.add(pane, Integer.toString(index));
      }
      /*QuestionsPanel.add(new JLabel(""), "last");*/
      score = new JLabel("");
      QuestionsPanel.add(score, "last");
      currentQuestion = 0;
      cardLayout.show(QuestionsPanel, "Start");
      
      setLayout(new BorderLayout());
      add(QuestionsPanel);
      
      JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      next = new JButton("Next");
      buttonPane.add(next);
      next.setEnabled(false);
      
      add(buttonPane, BorderLayout.SOUTH);
      
      next.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          nextQuestion();
        }
      });
    }
    
    //Method that handles all of the current logic, takes the user input and checks if correct prints score
    //First checks if there are still any questions left in the quiz if false it will do the above if
    //there are still questions then it will allow you to go to the next question and function as normal
    protected void nextQuestion() {
      // store the selected answer for each question
    	try {
      if (currentQuestion >= 0 && currentQuestion < quiz.size() ) {
        Question currentQObject = quiz.get(currentQuestion);
        if (currentQObject != null) {
          currentQObject.setUserResponse(getSelected(currentQObject.getButtonGroup()));
        }
      }
      currentQuestion++;
      if (currentQuestion >= quiz.size()) {
        cardLayout.show(QuestionsPanel, "last");
        next.setEnabled(false);
        
        // Just iterate over quiz list to check if answers are correct:
        //int totalCorrect = 0;
        for (Question q : quiz) {
          if (q.isCorrect()) { 
            totalCorrect++;
          }
        }
        
        //Print the answers correct 
        System.out.println("Your score is:" + totalCorrect + "/30");
        score.setText("Your score is: " + totalCorrect + "/30");
      } else {
        cardLayout.show(QuestionsPanel, Integer.toString(currentQuestion));
        next.setText("Next");
        //next.setEnabled(true);
      }
    	}
    	catch(NullPointerException e) {
    		System.out.println("Pick an answer!");
    		JOptionPane.showMessageDialog(null, "<html><b><div width='111px' height = '82px' align='center'> Please pick an answer to continue. </div></body></html>", "ERROR", JOptionPane.ERROR_MESSAGE);
    	  }
    }
    
    private String getSelected(ButtonGroup buttonGroup) {
      JRadioButton selectedRadio = null;
      Enumeration<AbstractButton> e = buttonGroup.getElements();
      while (e.hasMoreElements()) {
        JRadioButton rad = (JRadioButton) e.nextElement();
        if (rad.isSelected()) {
          selectedRadio = rad;
          break;
        }
      }
      return selectedRadio.getText();
    }
    
    protected void instructionBox() {
      JOptionPane.showMessageDialog(null,"<html><b><div width='111px' height = '82px' align='justified'> 1. A quiz composed of 30 questions, You must answer the previous question for moving on to the next one. Good Luck!</div></body></html>",
                                    "Instructions",
                                    JOptionPane.INFORMATION_MESSAGE);
    }
  }
  
  //Inface Question 
  //complete group of methods
  public interface Question {
    
    public String getPrompt();
    
    public void setButtonGroup(ButtonGroup buttonGroup);
    
    public ButtonGroup getButtonGroup();
    
    public String getCorrectAnswer();
    
    public String[] getOptions();
    
    public String getUserResponse();
    
    public void setUserResponse(String response);
    
    public boolean isCorrect();
  }
  
  //Class where methods will be given some logic
  public class ChoiceQuestion implements Question {
    
    private final String prompt;
    private final String correctAnswer;
    private final String[] options;
    private ButtonGroup buttonGroup;
    
    private String userResponse;
    
    public ChoiceQuestion(String prompt, String correctAnswer, String... options) {
      this.prompt = prompt;
      this.correctAnswer = correctAnswer;
      this.options = options;
    }
    
    @Override
    public void setButtonGroup(ButtonGroup buttonGroup) {
      this.buttonGroup = buttonGroup;
    }
    
    @Override
    public ButtonGroup getButtonGroup() {
      return this.buttonGroup;
    }
    
    @Override
    public String getPrompt() {
      return prompt;
    }
    
    @Override
    public String getCorrectAnswer() {
      return correctAnswer;
    }
    
    @Override
    public String[] getOptions() {
      return options;
    }
    
    @Override
    public String getUserResponse() {
      return userResponse;
    }
    
    @Override
    public void setUserResponse(String response) {
      userResponse = response;
    }
    
    @Override
    public boolean isCorrect() {
      return getCorrectAnswer().equals(getUserResponse());
    }
  }
  
  //Pane when taking the quiz
  @SuppressWarnings("serial")
public class QuestionPane extends JPanel {
    
    private Question question;
    
    private ButtonGroup buttonGroup = null;
    
    public QuestionPane(Question question) {
      this.question = question;
      
      setLayout(new BorderLayout());
      
      JLabel prompt = new JLabel("<html><b>" + question.getPrompt() + "</b></html>");
      prompt.setHorizontalAlignment(JLabel.LEFT);
      
      add(prompt, BorderLayout.NORTH);
      
      JPanel guesses = new JPanel(new GridBagLayout());
      guesses.setBorder(new EmptyBorder(10,10,10,10));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 1;
      gbc.anchor = GridBagConstraints.WEST;
      
      List<String> options = new ArrayList<>(Arrays.asList(question.getOptions()));
      Collections.sort(options);
      
      ButtonGroup bg = new ButtonGroup();
      for (String option : options) {
        JRadioButton btn = new JRadioButton(option);
        btn.setName(option);
        bg.add(btn);
        
        guesses.add(btn, gbc);
      }
      this.buttonGroup = bg;
      
      add(guesses);
    }
    
    public ButtonGroup getButtonGroup() {
      return buttonGroup;
    }
    
    public Question getQuestion() {
      return question;
    }
    
    public class ActionHandler implements ActionListener {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        getQuestion().setUserResponse(e.getActionCommand());
      }
      
    }
    
  }
}

