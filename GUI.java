import javax.swing.*;
import java.awt.*;

public class GUI {
	public static void main(String [] args) {
		Calculatr window = new Calculatr();
		try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {}
		window.setTitle("Calculator");
		window.setSize(525, 850);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		
		
	}
}
