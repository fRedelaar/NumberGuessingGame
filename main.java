import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {
	private JTextField txtGuess; 	//text field  for users guess
	private JLabel lblOutput; 		//label for too high/low output
	// line 44		lblOutput = new JLabel("Enter a number above and click on 'Guess!'");
	// By declaring it here (in class level), you make the scope bigger for the entire class
	// handy for when you make new methods that need these variables outside of this class.
	private int theNumber; //number we are trying to guess
	private int triesLeft = 7;
	
	
	public void checkGuess() 
	{ //method to check if guess is too high/low
		//get the users guess
		String guessText = txtGuess.getText();
		String message = "";
		int counter = 0;
		
		{
			try { //makes sure that if user enters a string, no exception
				// will make made.
				//check the guess for too high/low int
				int guess = Integer.parseInt(guessText);
				
				triesLeft--;
				
				//too high
				if (guess > theNumber) 
				{
					message = guess + " was too high. Guess again";
					message += "You have " + triesLeft + " tries Left.";
					lblOutput.setText(message);
				}
				
				//too low
				if (guess < theNumber) 
				{
					message = guess + " was too low. Guess again";
					message += "You have " + triesLeft + " tries Left.";
					lblOutput.setText(message);
					
				}
				
				if (guess == theNumber) {
					message = guess + " was right! You win!";
					lblOutput.setText(message);
					newGame();
				}
				
				if (triesLeft <= 0) {
					javax.swing.JOptionPane.showConfirmDialog(null, "You lost! The number was: "+theNumber+". Play again?");
					newGame();
				}
			}
			catch(Exception e) {
				lblOutput.setText("Enter a whole number between 1 - 100.");
			}
			
			finally {
				txtGuess.requestFocus();
				txtGuess.selectAll();
			}
		}
	}
	
	public void newGame() // create new random number
	{
		Random r = new Random();
		theNumber = r.nextInt(99) + 1;
		triesLeft = 7;
	}
	
	
	public main() {
		setTitle("Felicia is cool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblFelicia = new JLabel("Felicia's nummer guessing game");
		lblFelicia.setBounds(0, 11, 434, 15);
		lblFelicia.setFont(new Font("Arial", Font.BOLD, 16));
		lblFelicia.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFelicia);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 66, 414, 36);
		getContentPane().add(panel);
		
		JLabel lblmessage = new JLabel("Guess a number between 1 and 100:");
		panel.add(lblmessage);
		lblmessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess! ");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuess.setBounds(173, 128, 89, 15);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click on 'Guess!'. You have 7 guesses.");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 194, 434, 15);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) 
	{
		main theGame = new main();
		theGame.newGame();
		theGame.setSize(new Dimension(430, 330));
		theGame.setVisible(true);
	}
}
