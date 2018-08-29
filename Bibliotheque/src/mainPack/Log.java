
package mainPack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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
    
    // Fieds
    private String path, filename;
    private File file;
    
    /**
     * Write the current action and time on log
     * @param info Information to write on log
     */
    public void writeLogFile(String info){
        // Locals
        final LocalDateTime LD = LocalDateTime.now();
        final String TIME_FORMAT = "HH:mm:ss";
        final String TIME = 
            DateTime.getInstance().setLocalDateFormat(LD, TIME_FORMAT);
        try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(file, true))) {
            // Append log line
            writer.append(info + " " + TIME);
            writer.newLine();
            // Close buffer
            writer.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    /**
     * Create a log newFile with user name and hour
     * @param user Use the user name to create a newFile name
     */
    public void createLogFile(String user){
        // Locals
        buildFileName(user);
        buildFilePath();
        //
        try {
            File newFile = new File(path + filename);
            newFile.createNewFile();
            // Set singleton file
            setFile(newFile);
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    /**
     * Build the newFile name with format (date hour.txt)
     * @param user User that does the login
     * @return the newFile name to create a new document
     */
    private void buildFileName(String user){
        // Locals
        final LocalDateTime LD = LocalDateTime.now();
        final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        final String DATE = 
            DateTime.getInstance().setLocalDateFormat(LD, DATE_FORMAT);
        // Set singleton file
        setFilename(user + " " + DATE + ".txt");
    }
   
    /**
     * Build the newFile string path
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
        // Set singleton path
        setPath(ROOT.getAbsolutePath() + relPath);
    }
    
    // to test
    private void test(String s){
        System.out.println(s);
    }

    public void setFile(File file) {this.file = file;}
    
    public void setPath(String path) {this.path = path;}

    public void setFilename(String filename) {this.filename = filename;}
    
}
