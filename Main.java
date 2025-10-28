mport java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class main {
    public static void main(String[] args)  {


        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmtime = null;
        String Filepath = "src\\Aathma rama.wav";


        while (alarmtime == null) {
            try{
                System.out.print("Enter an alarm time(HH:MM:SS): ");
                String inputTime  = scanner.nextLine();

                alarmtime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmtime);


            }
            catch(DateTimeParseException e){
                System.out.println("Invalid Format.Use HH:MM:SS");
            }

        }
        AlarmClock alarmclock =  new AlarmClock(alarmtime,Filepath,scanner);
        Thread alaramThread = new Thread(alarmclock);
        alaramThread.start();




    }
}
