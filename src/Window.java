import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private final JTextArea messagesArea = new JTextArea();
    private final JPanel messengerPanel = new JPanel();
    private final JScrollPane scrollPane = new JScrollPane(messagesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private final JTextField messageField = new JTextField();
    private final JLabel sendMessageLabel = new JLabel("Ваше сообщение");
    private final JButton sendBtn = new JButton("Отправить");
    private final ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            messagesArea.append(messageField.getText() + "\n");
            messageField.setText("");
        }
    };


    public Window() {
        setTitle("Messenger");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        initMessengerPanel();

        setVisible(true);
    }

    private void initMessengerPanel() {
        messagesArea.setEditable(false);
        messengerPanel.setPreferredSize(new Dimension(490, 490));
        scrollPane.setPreferredSize(new Dimension(450, 350));
        messageField.setPreferredSize(new Dimension(325, 30));
        messengerPanel.add(scrollPane);
        messengerPanel.add(sendMessageLabel);
        messengerPanel.add(messageField);
        messengerPanel.add(sendBtn);

        messageField.addActionListener(listener);
        sendBtn.addActionListener(listener);
        add(messengerPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }
}
