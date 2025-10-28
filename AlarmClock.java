import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;
    private final String  Filepath;
    private Scanner scanner ;

    AlarmClock(LocalTime alarmTime, String Filepath, Scanner scanner){
        this.alarmTime = alarmTime;
        this.Filepath = Filepath;
        this.scanner = scanner;
    }

    @Override
    public void run(){



while(LocalTime.now().isBefore(alarmTime)){
    try {
        Thread.sleep(1000);

        LocalTime now = LocalTime.now();

        System.out.printf("\r%02d:%02d:%02d",
                           now.getHour(),
                           now.getMinute(),
                           now.getSecond() );
    }
    catch (InterruptedException e) {
        System.out.println("Thread was interrupted");
    }

}
        System.out.println("\nAlarm noise");
        playSound(Filepath);

    }
    private void playSound(String filepath) {

        File audiofile = new File(Filepath);



        try( AudioInputStream audiostream = AudioSystem.getAudioInputStream(audiofile)){
            Clip clip = AudioSystem.getClip();
            clip.open(audiostream);
            clip.start();
            System.out.print("Press *Enter* to stop:");
          scanner.nextLine();
          clip.stop();
            scanner.close();

        }
        catch (UnsupportedAudioFileException e){
            System.out.println("Unsupported audiofile ");

        }
        catch(LineUnavailableException e) {
            System.out.println("Audio is Unavailable");
        }
         catch(IOException e) {
             System.out.println("Error reading audio file");
         }

        }

    }
