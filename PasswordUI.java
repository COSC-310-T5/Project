import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PasswordUI implements ActionListener {
    boolean verified;
    JDialog frame;
    JTextField input;
    public PasswordUI() {
        verified = false;

        frame = new JDialog();
        JPanel root = new JPanel();
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        root.setLayout(new GridBagLayout());
        input = new JPasswordField();
        input.setPreferredSize(new Dimension(270, 50));
        JButton submitButton = new JButton("Submit");
        submitButton.setActionCommand("submit");
        submitButton.addActionListener(this);

        MainUI.addComponent(root, input, 0, 0, 1, 1, 0.9, 1, -1, 0, 0);
        MainUI.addComponent(root, submitButton, 1, 0, 1, 1, 0.1, 1, -1, 0, 0);

        // frame parameter boilerplate code
        frame.add(root);    // add the main root panel to the frame
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setTitle("Credential Check");
        frame.pack();
        frame.setSize(300, 100);
        frame.setLocation(500, 300);
        //frame.setVisible(true);     // actually show the window
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // this is a listener method that waits for any GUI event to occur and runs the corresponding method for each event
        if (e.getActionCommand().equals("submit")) {
            if (input.getText().equals("password")) {
                verified = true;
                frame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(frame, "Incorrect password.", "Error!", 0);
            }
        }
    }
}