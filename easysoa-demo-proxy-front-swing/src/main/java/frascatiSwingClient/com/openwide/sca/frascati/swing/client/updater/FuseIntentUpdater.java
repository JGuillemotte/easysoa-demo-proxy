package frascatiSwingClient.com.openwide.sca.frascati.swing.client.updater;

import javax.script.ScriptException;

public interface FuseIntentUpdater {
    /** 
     * Update the maxRequestsNumber of the fuse intent with the help of fscript.
     * @param newValue The new max request number value.
     * @throws ScriptException 
     */
    void updateMaxRequestsNumber(int newValue) throws ScriptException;
    
    /**
     * Rearm the fuse
     * @throws ScriptException 
     */
    String rearmFuse() throws ScriptException;
    
    
}
