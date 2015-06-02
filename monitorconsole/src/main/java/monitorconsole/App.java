package monitorconsole;

/**
 * @author Artur Kiszka
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ConsoleClient().start();
        System.out.println("Running...");
    }
}