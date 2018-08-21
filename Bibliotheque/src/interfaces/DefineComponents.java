
package interfaces;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;


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
    final int LINE = 15;
    final int SPACE = 5;
    // Elements bounds
    final int H_COMP = 30;
    // Fonts
    final Map<TextAttribute, Object> FONT_HEADER =
        new HashMap<TextAttribute,Object>(){{
            put(TextAttribute.SIZE, 14);
            put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRA_LIGHT);
    }};
    Map<TextAttribute, Object> FONT_TITLE =
        new HashMap<TextAttribute,Object>(){{
            put(TextAttribute.FAMILY, Font.DIALOG);
            put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD);
            put(TextAttribute.SIZE, 16);
    }};
            
    
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
