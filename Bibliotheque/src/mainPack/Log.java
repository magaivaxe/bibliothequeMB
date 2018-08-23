
package mainPack;

/**
 * Singleton class to create and fill the log files
 * @author Marcos Gomes
 */
public final class Log {
    // Singleton
    private Log() {super();}
    
    public static Log getInstance() {return LogHolder.INSTANCE;}
    
    private static class LogHolder {
        private static final Log INSTANCE = new Log();
    }
}
