// (c) 2004-2011 Uri Wilensky. See README.md for terms of use.

package org.nlogo.extensions.speech;

import java.util.Enumeration;
import java.util.ArrayList;
import org.nlogo.api.Syntax;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.DefaultReporter;
import org.nlogo.api.Argument; 
import org.nlogo.api.Context;
import org.nlogo.api.LogoList;
import org.nlogo.api.LogoException;
import org.nlogo.api.PrimitiveManager;
import org.nlogo.api.ExtensionManager;
import org.nlogo.api.Syntax;
import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.ExtensionException;

public class SpeechExtension extends DefaultClassManager {

  private static glguerin.narrator.Narrator narrator; // the synthesizer
  private static java.util.List<String> voices; // list of available voices

  // Loads the primitives
  public void load(PrimitiveManager primManager) {
    primManager.addPrimitive("speak", new Speak());
    primManager.addPrimitive("voices", new ListVoices());
  }
  
  // Initializes the narrator and the list of voices
  public void runOnce(ExtensionManager em) 
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
      return Syntax.reporterSyntax(Syntax.ListType());
    }
    public Object report(Argument args[], Context context)
    throws ExtensionException {
      if(! System.getProperty("os.name").startsWith("Mac")) { 
        return LogoList.Empty();
      }
      return LogoList.fromJava(voices);
    }
  }
  
  // NetLogo command generates speech.
  public static class Speak extends DefaultCommand {
    public Syntax getSyntax() {
      // this reporter takes two arguments: a string and a wildcard
      int[] right = { Syntax.StringType(), Syntax.WildcardType() };
      return Syntax.commandSyntax(right);
    }
    public void perform(Argument args[], Context context)
    throws ExtensionException, LogoException {
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
