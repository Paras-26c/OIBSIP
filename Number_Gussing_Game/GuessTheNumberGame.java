import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumberGame extends JFrame implements ActionListener {
    private int randomNumber;
    private int attemptsLeft;
    private int round;
    private int score;
    private final int MAX_ATTEMPTS = 5;

    private JTextField guessField;
    private JLabel messageLabel, attemptLabel, scoreLabel, roundLabel;
    private JButton guessButton, newRoundButton;

    public GuessTheNumberGame() {
        setTitle("🎯 Guess the Number Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Initialize components
        roundLabel = new JLabel("Round: 1", SwingConstants.CENTER);
        attemptLabel = new JLabel("Attempts left: " + MAX_ATTEMPTS, SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        messageLabel = new JLabel("I'm thinking of a number between 1 and 100...", SwingConstants.CENTER);

        guessField = new JTextField();
        guessButton = new JButton("Submit Guess");
        newRoundButton = new JButton("Start New Round");
        newRoundButton.setEnabled(false);

        // Add components to frame
        add(roundLabel);
        add(messageLabel);
        add(guessField);
        add(attemptLabel);
        add(scoreLabel);
        add(guessButton);
        add(newRoundButton);

        // Add listeners
        guessButton.addActionListener(this);
        newRoundButton.addActionListener(e -> startNewRound());

        // Start game
        startNewRound();

        setVisible(true);
    }

    private void startNewRound() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        attemptsLeft = MAX_ATTEMPTS;
        round++;
        messageLabel.setText("Round " + round + ": Guess a number between 1 and 100");
        attemptLabel.setText("Attempts left: " + attemptsLeft);
        roundLabel.setText("Round: " + round);
        guessField.setText("");
        guessField.setEditable(true);
        guessButton.setEnabled(true);
        newRoundButton.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            attemptsLeft--;

            if (userGuess == randomNumber) {
                int points = (attemptsLeft + 1) * 10;
                score += points;
                messageLabel.setText("🎉 Correct! You scored " + points + " points!");
                guessField.setEditable(false);
                guessButton.setEnabled(false);
                newRoundButton.setEnabled(true);
            } else if (attemptsLeft > 0) {
                if (userGuess < randomNumber) {
                    messageLabel.setText("Too low! Try again.");
                } else {
                    messageLabel.setText("Too high! Try again.");
                }
                attemptLabel.setText("Attempts left: " + attemptsLeft);
            } else {
                messageLabel.setText("❌ Out of attempts! The number was: " + randomNumber);
                guessField.setEditable(false);
                guessButton.setEnabled(false);
                newRoundButton.setEnabled(true);
            }

            scoreLabel.setText("Score: " + score);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessTheNumberGame());
    }
}

