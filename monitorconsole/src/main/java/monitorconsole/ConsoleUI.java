package monitorconsole;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsoleUI extends JFrame implements ActionListener {

	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JRadioButton cpuButton;
	private JRadioButton memButton;
	private JRadioButton upButton;
	private JRadioButton downButton;
	private String currentMeasurementType;
	
    public ConsoleUI() {
        initUI();
    }

    private void initUI() {
        
    	textArea = new JTextArea(13, 60);
    	textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
    	scrollPane = new JScrollPane(textArea); 
    	textArea.setEditable(false);
    	
    	cpuButton = new JRadioButton("CPU");
    	cpuButton.setMnemonic(KeyEvent.VK_LEFT);
    	cpuButton.setActionCommand("CPU");
    	cpuButton.setSelected(true);
    	currentMeasurementType = "CPU";

    	memButton = new JRadioButton("Memory");
    	memButton.setMnemonic(KeyEvent.VK_RIGHT);
    	memButton.setActionCommand("Memory");

    	upButton = new JRadioButton("Network Up");
    	upButton.setMnemonic(KeyEvent.VK_UP);
    	upButton.setActionCommand("Network Up");
    	
    	downButton = new JRadioButton("Network Down");
    	downButton.setMnemonic(KeyEvent.VK_DOWN);
    	downButton.setActionCommand("Network Down");
    	
    	cpuButton.addActionListener(this);
    	memButton.addActionListener(this);
    	upButton.addActionListener(this);
    	downButton.addActionListener(this);
    	
    	JRadioButton[] buttons = {cpuButton,memButton,upButton,downButton};
    	ButtonGroup group = new ButtonGroup();
    	
    	for(JRadioButton button : buttons)
    		group.add(button);
    	
    	createLayout(scrollPane, buttons); 
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Monitor console");
        //setSize(600, 300);
    }
    
    private void createLayout(JScrollPane scrollPane, JRadioButton[] buttons) {
        
        JPanel pane = (JPanel) getContentPane();
        JPanel controlsPane = new JPanel();
        BorderLayout gl = new BorderLayout();
        pane.setLayout(gl);
        
        for(JRadioButton button : buttons)
        	controlsPane.add(button);
        
        pane.add(controlsPane, BorderLayout.NORTH);
        pane.add(scrollPane, BorderLayout.SOUTH);
        pack();        
    }
    
    public void actionPerformed(ActionEvent actionEvent) {
    	currentMeasurementType = actionEvent.getActionCommand();
    }
    
    public String getCurrentMeasurementType() {
    	return currentMeasurementType;
    }
    
    public void print(String text) {
    	textArea.setText(null);
        textArea.append(text);
    }
}