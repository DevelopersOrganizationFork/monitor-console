package monitor.console.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsoleUI extends JFrame {

	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JRadioButton cpuButton, memButton, upButton, downButton;
	private JRadioButton sortByHostName, sortByHostIp, sortByMeasurement;
	private JRadioButton sortAscending, sortDescending;
	private String currentMeasurementType, currentSortType, currentSortKey;
	private JRadioButton[] measurementTypeButtons, sortKeyButtons, sortTypeButtons;
	
    public ConsoleUI() {
        initUI();
    }
    
    private void initUI() {
    	textArea = new JTextArea(13, 70);
    	textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
    	textArea.setEditable(false);
    	scrollPane = new JScrollPane(textArea); 
    	
    	initMeasurementButtons();
    	initSortButtons();
    	createLayout(scrollPane, measurementTypeButtons, sortKeyButtons, sortTypeButtons); 
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Monitor console");
        //setSize(600, 300);
    }
    
    private void initMeasurementButtons() {
    	RadioButtonActionListener actionListener = new RadioButtonActionListener(this);
    	
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
    	
    	cpuButton.addActionListener(actionListener);
    	memButton.addActionListener(actionListener);
    	upButton.addActionListener(actionListener);
    	downButton.addActionListener(actionListener);
    	
    	measurementTypeButtons = new JRadioButton[]{cpuButton,memButton,upButton,downButton};
    	ButtonGroup measurementTypeGroup = new ButtonGroup();
    	
    	for(JRadioButton button : measurementTypeButtons)
    		measurementTypeGroup.add(button);
    }
    
    private void initSortButtons() {
    	RadioButtonActionListener actionListener = new RadioButtonActionListener(this);
    	
    	sortByHostName = new JRadioButton("by host name");
    	sortByHostName.setActionCommand("hostName");
    	sortByHostIp = new JRadioButton("by host IP");
    	sortByHostIp.setActionCommand("hostIp");
    	sortByMeasurement = new JRadioButton("by measurement");
    	sortByMeasurement.setActionCommand("measurementValue");
    	sortByMeasurement.setSelected(true);
    	currentSortKey = "measurementValue";
    	
    	sortByHostName.addActionListener(actionListener);
    	sortByHostIp.addActionListener(actionListener);
    	sortByMeasurement.addActionListener(actionListener);
    	
    	sortKeyButtons = new JRadioButton[]{sortByHostName,sortByHostIp,sortByMeasurement};
    	ButtonGroup sortKeyGroup = new ButtonGroup();
    	
    	for(JRadioButton button : sortKeyButtons)
    		sortKeyGroup.add(button);
    	
    	sortAscending = new JRadioButton("ascending");
    	sortAscending.setActionCommand("ascending");
    	sortDescending = new JRadioButton("descending");
    	sortDescending.setActionCommand("descending");
    	sortDescending.setSelected(true);
    	currentSortType = "descending";
    	
    	sortAscending.addActionListener(actionListener);
    	sortDescending.addActionListener(actionListener);
    	
    	sortTypeButtons = new JRadioButton[]{sortAscending,sortDescending};
    	ButtonGroup sortTypeGroup = new ButtonGroup();
    	
    	for(JRadioButton button : sortTypeButtons)
    		sortTypeGroup.add(button);
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
    
    public void setcurrentMeasurementType(String currentMeasurementType) {
    	this.currentMeasurementType = currentMeasurementType;
    }
    
    public void setcurrentSortKey(String currentSortKey) {
    	this.currentSortKey = currentSortKey;
    }
    
    public void setcurrentSortType(String currentSortType) {
    	this.currentSortType = currentSortType;
    }
    
    public String getCurrentMeasurementType() {
    	return currentMeasurementType;
    }
    
    public String getCurrentSortKey() {
    	return currentSortKey;
    }
    
    public String getCurrentSortType() {
    	return currentSortType;
    }
    
    public void print(String text) {
    	textArea.setText(null);
        textArea.append(text);
    }
}