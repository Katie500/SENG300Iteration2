package com.diy.software;

<<<<<<< HEAD
import java.awt.EventQueue;

import javax.swing.JFrame;

public class AttendantScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendantScreen window = new AttendantScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AttendantScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
=======
import com.diy.hardware.DoItYourselfStation;
import javax.swing.*;

public class AttendantStationGui extends javax.swing.JFrame {
    JFrame frame;
    public static void main(String[] args) {
        new DoItYourselfStation();
        //create gui here
    }
}
>>>>>>> 62adfd7e8e40db90fa19efe7ff98cd25ce02c77d
