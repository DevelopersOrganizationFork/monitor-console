package monitorconsole;

import javax.swing.*;

public class ConsoleUI extends JFrame {

	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JRadioButton cpuButton;
	private JRadioButton memButton;
	private JRadioButton upButton;
	private JRadioButton downButton;
	
    public ConsoleUI() {
        initUI();
    }

    private void initUI() {
        
    	textArea = new JTextArea(12, 50);
    	scrollPane = new JScrollPane(textArea); 
    	textArea.setEditable(false);
    	
    	/*cpuButton = new JRadioButton("CPU");
    	cpuButton.setMnemonic(KeyEvent.VK_LEFT);
    	cpuButton.setActionCommand("CPU");
    	cpuButton.setSelected(true);

    	memButton = new JRadioButton("Mem");
    	memButton.setMnemonic(KeyEvent.VK_left);
    	memButton.setActionCommand("Mem");

    	upButton = new JRadioButton("Mem");
    	upButton.setMnemonic(KeyEvent.VK_LEFT);
    	upButton.setActionCommand("Mem");
    	
    	downButton = new JRadioButton("Mem");
    	downButton.setMnemonic(KeyEvent.VK_LEFT);
    	downButton.setActionCommand("Mem");
    	
    	*/

    	createLayout(scrollPane);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Monitor console");
        //setSize(600, 300);
    }
    
    private void createLayout(JComponent... arg) {
        
        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0]));//.addGap(200));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0]));//.addGap(120));
        
        pack();        
    }
    
    public void print(String text) {
    	textArea.setText(null);
        textArea.append(text);
    }
}