package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    private JTextField nameField, emailField;
    private JRadioButton notificationsAccept;
    private JCheckBox confirm;

    class BtnEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String notify = "Yes";

            if (!notificationsAccept.isSelected()) {
                notify = "No";
            }

            String title = "Thanks!";
            String details = "Your data\nName: " + name + "\nEmail: " + email + "\nNotifications are accepted: " + notify;

            if (!confirm.isSelected()) {
                title = "Warning...";
                details = "We can't process your data without confirmation...";
            }

            JOptionPane.showMessageDialog(null, details, title, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public ContactForm() {
        super("Contact Form");
    }

    public ContactForm prepare() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(600, 400);

        super.setBounds(screenSize.width / 2 - frameSize.width / 2,
                screenSize.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10));

        // --- Text fields ---

        this.nameField = new JTextField("", 1);
        this.emailField = new JTextField("", 1);

        container.add(new JLabel("Your name:"));
        container.add(this.nameField);
        container.add(new JLabel("Your email:"));
        container.add(this.emailField);

        // --- Radio buttons ---

        this.notificationsAccept = new JRadioButton("Accept notifications");
        JRadioButton notificationsRefuse = new JRadioButton("Refuse notifications");

        this.notificationsAccept.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(this.notificationsAccept);
        group.add(notificationsRefuse);

        container.add(this.notificationsAccept);
        container.add(notificationsRefuse);

        // --- Checkbox ---

        this.confirm = new JCheckBox("Confirm?");

        container.add(this.confirm);

        // --- Button ---

        JButton btn = new JButton("Send");

        container.add(btn);
        btn.addActionListener(new BtnEventListener());

        return this;
    }
}
