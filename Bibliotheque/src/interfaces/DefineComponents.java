
package interfaces;

/**
 *
 * @author sire_marcos
 */
public interface DefineComponents {
    // Main Bounds
    final int WL_FRAME = 1200;
    final int HL_FRAME = 800;
    final int WS_FRAME = 400;
    final int HS_FRAME = 300;
    final int ORIGIN = 30; 
    final int SPACE = 5;
    // Elements bounds
    final int H_COMP = 30;
    // Methods to override
    /**
     * 
     */
    public void initialiserComposants();
    /**
     * 
     */
    public void layouts();
    /**
     * 
     */
    public void styles();
    /**
     * 
     */
    public void polices();
    
}
