// (c) 2004-2011 Uri Wilensky. See README.md for terms of use.

package org.nlogo.extensions.speech;

import java.util.Enumeration;
import java.util.ArrayList;
import org.nlogo.api.Syntax;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.DefaultReporter;
import org.nlogo.api.Argument; 
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;

public class SpeechExtension extends org.nlogo.api.DefaultClassManager {

  private static glguerin.narrator.Narrator narrator; // the synthesizer
  private static java.util.List<String> voices; // list of available voices

  // Loads the primitives
  public void load(org.nlogo.api.PrimitiveManager primManager) {
    primManager.addPrimitive("speak", new Speak());
    primManager.addPrimitive("voices", new ListVoices());
  }
  
  // Initializes the narrator and the list of voices
  public void runOnce(org.nlogo.api.ExtensionManager em) 
  throws ExtensionException {
    // make sure we're running on a mac
    if(!System.getProperty("os.name").startsWith("Mac")) {
      //throw new ExtensionException("This extension only works on OS X");
      return;
    }
    // initialize the narrator
    narrator = new glguerin.narrator.HumbleNarrator();
    // initialize the list of voices
    voices = new ArrayList<String>();
    Enumeration e = narrator.voiceNames();
    while (e.hasMoreElements()) { 
      voices.add((String)e.nextElement());
    }
  }
  
  // Deinitializes the extension by getting rid of the instance of Narrator
  public void unload() {
    narrator = null;
    voices = null;
  }
  
  // NetLogo reporter reports a list of the available voices
  public static class ListVoices extends DefaultReporter {
    public Syntax getSyntax() {
      // this reporter takes no arguments and returns a list
      return Syntax.reporterSyntax(Syntax.TYPE_LIST);
    }
    public Object report(Argument args[] , Context context)
    throws ExtensionException {
    
      if(! System.getProperty("os.name").startsWith("Mac")) { 
        return new org.nlogo.api.LogoList();
      }
      return new org.nlogo.api.LogoList(voices);
    }
  }
  
  // NetLogo command generates speech.
  public static class Speak extends DefaultCommand {
    public org.nlogo.api.Syntax getSyntax() {
      // this reporter takes two arguments: a string and a wildcard
      int[] right = { Syntax.TYPE_STRING, Syntax.TYPE_WILDCARD };
      return Syntax.commandSyntax(right);
    }
    public void perform(Argument args[], Context context)
    throws ExtensionException , org.nlogo.api.LogoException {
      if(!System.getProperty("os.name").startsWith("Mac")) return;
      try {
        String voice = args[0].getString();
        String text = args[1].getString();
        narrator.speak(voice, text);
      } 
      catch (java.io.IOException ex) {
        throw new ExtensionException("Can't speak: " + ex.toString());
      }
    }
  }

}
