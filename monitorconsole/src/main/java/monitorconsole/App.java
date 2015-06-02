package monitorconsole;

import java.awt.EventQueue;
/**
 * @author Artur Kiszka
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Struktura projektu" );
        
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                ConsoleUI ex = new ConsoleUI();
                ex.setVisible(true);
            }
        });
        
        new ConsoleClient().start();
    }
}
