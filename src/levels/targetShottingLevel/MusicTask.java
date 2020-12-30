
package levels.targetShottingLevel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class MusicTask implements Runnable{
    String route;
    public MusicTask(String route) {
        this.route = route;
    }
    
    
    
    private volatile boolean exit = false;
    @Override
    public void run() {
        try {
            onMusic("src/sonidos/Night.wav");
        } catch (IOException ex) {
            Logger.getLogger(MusicTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void onMusic(String musicLocation) throws FileNotFoundException, IOException{
       InputStream music;
       InputStream off;
       AudioStream audio;
       music= new FileInputStream(new File(musicLocation));
       audio= new AudioStream(music);
       
            
        
        AudioPlayer.player.start(audio);
        //AudioPlayer.player.stop(aud    
                                     
   }
     public void stop(){
         exit=true;
     }
}
