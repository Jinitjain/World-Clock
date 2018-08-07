import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Conversion {

    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss ";

    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(System.in);
            Date now = new Date();
            SimpleDateFormat formator = new SimpleDateFormat(DATE_FORMAT);
            String s2 = formator.format(now);

            LocalDateTime ldt;
            ldt = LocalDateTime.parse(s2, DateTimeFormatter.ofPattern(DATE_FORMAT));

            String loc;
            loc = scan.nextLine();
            //Locale currentloc = Locale.getDefault();
            //String loc = currentloc.getDisplayCountry();

            //Since my pc has location in United States although i'm in India.
            //if (loc == "United States")
                //loc = "Asia";



            while (true) {
                try {

                    System.out.println("Enter gmt city located near you");
                    String y;
                    y = (scan.nextLine());
                    char[] a = y.toCharArray();
                    for (int i = 0; i < y.length(); i++) {
                        if (a[i] == ' ') {
                            a[i] = '_';
                        }
                    }
                    y = new String(a);
                    //System.out.println(loc);

                    y = loc + "/" + y;

                    ZoneId Id = ZoneId.of(y);
                    //LocalDateTime + ZoneId = ZonedDateTime
                    ZonedDateTime myZonedDateTime = ldt.atZone(Id);



                    System.out.println("Enter required Continent.");
                    System.out.println("Enter 1 for Asia");
                    System.out.println("Enter 2 for America");
                    System.out.println("Enter 3 for Europe");
                    System.out.println("Enter 4 for Pacific region");
                    System.out.println("Enter 5 for Australia");
                    System.out.println("Enter 6 for Africa");
                    System.out.println("Enter 7 for Atlantic");
                    System.out.println("Enter 8 for Antarctica");
                    int ch=scan.nextInt();
                    String x = null;
                    switch(ch)
                    {
                        case 1:{x="Asia";}break;
                        case 2:{x="America";}break;
                        case 3:{x="Europe";}break;
                        case 4:{x="Pacific";}break;
                        case 5:{x="Australia";}break;
                        case 6:{x="Africa";}break;
                        case 7:{x="Atlantic";}break;
                        case 8:{x="Antarctica";}break;

                    }

                    System.out.println("Enter required gmt city.");
                    scan.nextLine();
                    x = x + "/" + (scan.nextLine());

                    char[] b = x.toCharArray();
                    for (int i = 0; i < x.length(); i++) {
                        if (b[i] == ' ') {
                            b[i] = '_';
                        }
                    }
                    x = new String(b);

                    ZoneId requiredId = ZoneId.of(x);
                    System.out.println("TimeZone : " + requiredId);
                    ZonedDateTime reqDateTime = myZonedDateTime.withZoneSameInstant(requiredId);

                    DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
                    System.out.println("\n---DateTimeFormatter---");
                    System.out.println("Date (Current) : " + format.format(myZonedDateTime));
                    System.out.println("Date (Required) : " + format.format(reqDateTime));
                    break;

                } catch (Exception e) {
                    System.out.println("Check the spellings.Make sure only first letter is capital.");
                }
            }
        }catch(Exception e)
        {
            System.out.println("Sorry for the inconvenience caused.Try again later");
        }
    }

}
