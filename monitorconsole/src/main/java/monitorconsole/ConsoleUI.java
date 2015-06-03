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
	
	private JRadioButton sortByHostName;
	private JRadioButton sortByHostIp;
	private JRadioButton sortByMeasurement;
	
	private JRadioButton sortAscending;
	private JRadioButton sortDescending;
	
    public ConsoleUI() {
        initUI();
    }

    private void initUI() {
    	textArea = new JTextArea(13, 60);
    	textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
    	textArea.setEditable(false);
    	scrollPane = new JScrollPane(textArea); 
    	
    	cpuButton = new JRadioButton("CPU");
    	cpuButton.setActionCommand("CPU");
    	memButton = new JRadioButton("Memory");
    	memButton.setActionCommand("Memory");
    	upButton = new JRadioButton("Network Up");
    	upButton.setActionCommand("Network Up");
    	downButton = new JRadioButton("Network Down");
    	downButton.setActionCommand("Network Down");

    	cpuButton.setSelected(true);
    	currentMeasurementType = "CPU";
    	
    	cpuButton.addActionListener(this);
    	memButton.addActionListener(this);
    	upButton.addActionListener(this);
    	downButton.addActionListener(this);
    	
    	JRadioButton[] measurementTypeButtons = {cpuButton,memButton,upButton,downButton};
    	ButtonGroup measurementTypeGroup = new ButtonGroup();
    	
    	for(JRadioButton button : measurementTypeButtons)
    		measurementTypeGroup.add(button);
    	
    	sortByHostName = new JRadioButton("by host name");
    	sortByHostName.setActionCommand("by host name");
    	sortByHostIp = new JRadioButton("by host IP");
    	sortByHostIp.setActionCommand("by host IP");
    	sortByMeasurement = new JRadioButton("by measurement");
    	sortByMeasurement.setActionCommand("by measurement");
    	sortByMeasurement.setSelected(true);
    	
    	JRadioButton[] sortKeyButtons = {sortByHostName,sortByHostIp,sortByMeasurement};
    	ButtonGroup sortKeyGroup = new ButtonGroup();
    	
    	for(JRadioButton button : sortKeyButtons)
    		sortKeyGroup.add(button);
    	
    	sortAscending = new JRadioButton("ascending");
    	sortAscending.setActionCommand("ascending");
    	sortDescending = new JRadioButton("descending");
    	sortDescending.setActionCommand("descending");
    	sortDescending.setSelected(true);
    	
    	JRadioButton[] sortTypeButtons = {sortAscending,sortDescending};
    	ButtonGroup sortTypeGroup = new ButtonGroup();
    	
    	for(JRadioButton button : sortTypeButtons)
    		sortTypeGroup.add(button);
    	
    	createLayout(scrollPane, measurementTypeButtons, sortKeyButtons, sortTypeButtons); 
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Monitor console");
        //setSize(600, 300);
    }
    
    private void createLayout(JScrollPane scrollPane, JRadioButton[] measurementTypeButtons, JRadioButton[] sortKeyButtons, JRadioButton[] sortTypeButtons) {
        
        JPanel mainPane = (JPanel) getContentPane();
        JPanel buttonPane = new JPanel();
        
        JPanel measurementTypePane = new JPanel();
        JPanel sortTypePane = new JPanel();
        
        mainPane.setLayout(new BorderLayout());
        buttonPane.setLayout(new BorderLayout());
        measurementTypePane.setLayout(new GridLayout(2, 4));
        sortTypePane.setLayout(new GridLayout(3, 3));
        
        measurementTypePane.add(new JLabel("Measurement"));
        measurementTypePane.add(new JLabel(""));
        measurementTypePane.add(new JLabel(""));
        measurementTypePane.add(new JLabel(""));
        for(JRadioButton button : measurementTypeButtons)
        	measurementTypePane.add(button);
        
        sortTypePane.add(new JLabel("Sort"));
        sortTypePane.add(new JLabel(""));
        sortTypePane.add(new JLabel(""));
        
        sortTypePane.add(new JLabel(""));
        for(JRadioButton button : sortTypeButtons)
        	sortTypePane.add(button);
        
        for(JRadioButton button : sortKeyButtons)
        	sortTypePane.add(button);
        
        buttonPane.add(measurementTypePane, BorderLayout.NORTH);
        buttonPane.add(sortTypePane, BorderLayout.SOUTH);
        
        mainPane.add(buttonPane, BorderLayout.NORTH);
        mainPane.add(scrollPane, BorderLayout.SOUTH);
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