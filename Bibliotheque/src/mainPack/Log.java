
package mainPack;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Singleton class to create and fill the log files
 * @author Marcos Gomes
 */
public final class Log {
    // Fieds
    private String path, filename;
    // Singleton 
    private Log() {super();}
    
    public static Log getInstance() {return LogHolder.INSTANCE;}
    
    private static class LogHolder {
        private static final Log INSTANCE = new Log();
    }
    
    public void writeLogFile(String info){
        
    }
    
    /**
     * Create a log file with user name and hour
     * @param user Use the user name to create a file name
     */
    public void createLogFile(String user){
        // Locals
        buildFileName(user);
        buildFilePath();
        //
        try {
            File file = new File(path + filename);
            file.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    /**
     * Build the file name with format date_hour.txt
     * @param user User that does the login
     * @return the file name to create a new document
     */
    private void buildFileName(String user){
        // Locals
        final LocalDateTime LDT = LocalDateTime.now();
        final String R = " " + LDT.getYear() + "-" + LDT.getMonthValue() + 
            "-" + LDT.getDayOfMonth() + " " + LDT.getHour() + 
            ":" + LDT.getMinute() + ":" + LDT.getSecond();
        setFilename(user + R + ".txt");
    }
    
    /**
     * Build the file string path
     * @return the string path
     */
    private void buildFilePath(){
        // Locals
        final String OS = System.getProperty("os.name");
        final File ROOT = new File("");
        String relPath;
            // Write on Windows or Unix
            if (OS.startsWith("Windows")) {
                relPath = "\\log\\";
            } else {
                relPath = "/log/";}
        setPath(ROOT.getAbsolutePath() + relPath);
    }
    
    // to test
    private void test(String s){
        System.out.println(s);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
}
