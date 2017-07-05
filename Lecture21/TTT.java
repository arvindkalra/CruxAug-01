package Lecture21;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TTT extends JFrame implements ActionListener {
	private static final int BOARD_SIZE = 3;
	private boolean Xturn = true;

	private final String XMOVE = "X";
	private final String ZMOVE = "O";

	private static final int XWINS = 1;
	private static final int ZWINS = 2;
	private static final int TIE = 3;
	private static final int INCOMPLETE = 4;

	private final JButton[][] board = new JButton[BOARD_SIZE][BOARD_SIZE];

	public TTT() {
		super.setTitle("Tic Tac Toe");
		super.setSize(700, 700);

		GridLayout layout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(layout);

		Font font = new Font("Comic Sans MS", 1, 225);

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton("");

				button.setFont(font);

				button.addActionListener(this);

				super.add(button);
				this.board[row][col] = button;
			}
		}
		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();

		this.makeMove(btn);
		int gs = this.getGameStatus();
		if (gs != this.INCOMPLETE) {
			this.showResult(gs);
			int res = JOptionPane.showConfirmDialog(this, "Do You Want To Restart???");
			if (res == JOptionPane.YES_OPTION) {
				for (int i = 0; i < this.BOARD_SIZE; i++) {
					for (int j = 0; j < this.BOARD_SIZE; j++) {
						this.board[i][j].setText("");
					}
				}
				this.Xturn = true;
			} else {
				super.dispose();
			}

		}
	}

	private void makeMove(JButton btn) {
		if (btn.getText().length() == 0) {

			Color red = new Color(255, 11, 17);
			Color blue = new Color(11, 35, 255);

			if (Xturn) {
				btn.setText(XMOVE);
				btn.setForeground(blue);
			} else {
				btn.setText(ZMOVE);
				btn.setForeground(red);
			}
			Xturn = !Xturn;

		} else {
			JOptionPane.showMessageDialog(this, "Invalid Move...");
		}
	}

	private int getGameStatus() {
		int row = 0, col = 0;
		String text1 = "", text2 = "";

		// check for rows..
		row = 0;
		while (row < this.BOARD_SIZE) {
			col = 0;
			while (col < this.BOARD_SIZE - 1) {
				text1 = this.board[row][col].getText();
				text2 = this.board[row][col + 1].getText();
				if (text1 != text2 || text1.length() == 0) {
					break;
				}
				col++;
			}
			if (col == this.BOARD_SIZE - 1) {
				return text1.equals(XMOVE) ? this.XWINS : this.ZWINS;
			}
			row++;
		}

		// check for columns..
		col = 0;
		while (col < this.BOARD_SIZE) {
			row = 0;
			while (row < this.BOARD_SIZE - 1) {
				text1 = this.board[row][col].getText();
				text2 = this.board[row + 1][col].getText();
				if (text1 != text2 || text1.length() == 0) {
					break;
				}
				row++;
			}
			if (row == this.BOARD_SIZE - 1) {
				return text1.equals(XMOVE) ? this.XWINS : this.ZWINS;
			}
			col++;
		}

		// check for diagonal 1...
		for (row = 0, col = 0; row < this.BOARD_SIZE - 1 && col < this.BOARD_SIZE - 1; row++, col++) {
			text1 = this.board[row][col].getText();
			text2 = this.board[row + 1][col + 1].getText();
			if (text1 != text2 || text1.length() == 0) {
				break;
			}
		}
		if (row == this.BOARD_SIZE - 1) {
			return text1.equals(XMOVE) ? this.XWINS : this.ZWINS;
		}

		// check for diagonal 2...
		row = 0;
		col = this.BOARD_SIZE - 1;
		while (row < this.BOARD_SIZE - 1 && col > 0) {
			text1 = this.board[row][col].getText();
			text2 = this.board[row + 1][col - 1].getText();
			if (text1 != text2 || text1.length() == 0) {
				break;
			}
			row++;
			col--;
		}
		if (row == this.BOARD_SIZE - 1) {
			return text1.equals(XMOVE) ? this.XWINS : this.ZWINS;
		}

		// check for incomplete...
		row = 0;
		while (row < this.BOARD_SIZE) {
			col = 0;
			while (col < this.BOARD_SIZE) {
				text1 = this.board[row][col].getText();
				if (text1.length() == 0) {
					return this.INCOMPLETE;
				}
				col++;
			}
			row++;
		}
		return this.TIE;
	}

	private void showResult(int gs) {
		if (gs == this.XWINS) {
			JOptionPane.showMessageDialog(this, "X Wins...");
		} else if (gs == this.ZWINS) {
			JOptionPane.showMessageDialog(this, "O Wins...");
		} else {
			JOptionPane.showMessageDialog(this, "Its Tie...");
		}
	}
}
