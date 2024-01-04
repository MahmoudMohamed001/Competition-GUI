import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompetitorList {
    ArrayList <AthleticsCompetitor> APlayers = new ArrayList<>();
    ArrayList <BoxingCompetitor> BPlayers = new ArrayList<>();
    String csvFile = "C:\\Users\\Rabbit\\OneDrive\\Desktop\\RunCompetitor.csv"; // Saving Location of csv file.
    public void readCompetitorsFromFile() {
        
        String line; // reading single line
        BufferedReader Br = null; // reading line by line from the csv file 

        try { // try and catch for any error happening when reading csv file
            
                    // Reading the csv file 
            Br = new BufferedReader(new FileReader(csvFile)); 
                   // Reading line by line until getting null (Lines Finished)
            while ((line = Br.readLine()) != null) {

                String[] data = line.split(","); // Splitting each row into columns 
                
                if(data[7].equals("Athletics"))   // data[7] is the game type index in the file 
                {     
                    // Reading data of one athletics player then adding it to array of list of athletics players 
                    double [] Scores = new double[6];
                    int count = 0;
                    for(int i = 9 ; i <= 14 ; i++)
                    {
                        Scores[count] = Double.parseDouble(data[i]);
                        count++;
                    }
                    AthleticsCompetitor Acompatitor = new AthleticsCompetitor(data[3] , data[6] , Integer.parseInt(data[4]), data[1], data[2], data[8], data[5], Scores );
                    APlayers.add(Acompatitor);
                }
                else if (data[7].equals("Boxing")) {
                    // Reading data of one Boxing player then adding it to array of list of Boxing players 
                    double [] Scores = new double[5];
                    int count = 0;
                    for(int i = 9 ; i <= 13 ; i++)
                    {
                        Scores[count] = Double.parseDouble(data[i]);
                        count++;
                    }
                    BoxingCompetitor Bcompetitor = new BoxingCompetitor(data[3] , data[6] , Integer.parseInt(data[4]), data[1], data[2], data[8], data[5], Scores);
                    BPlayers.add(Bcompetitor);
                }
                //Competitor competitor = new Competitor(data[0], data[1], /* add other fields as needed */);
                
              //  Players.add(competitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { // try and catch for any error happening when closing csv file

                if (Br != null) {
                    Br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        // this function get Athletics competitor return a string of its full details 
    public String PrintAthleiticPlayerDetails(AthleticsCompetitor Acompetitor)
    {
        AthleticsCompetitorView AView = new AthleticsCompetitorView();
        AthleticsCompetitorController AController = new AthleticsCompetitorController(Acompetitor, AView);
        String Fresults = AController.FullView();
        return Fresults;

    }
         // this function get Boxing competitor and return a string of its full details
    public String PrintBoxingPlayerDetails(BoxingCompetitor Bcompetitor)
    {
        BoxingCompetitorView BView = new BoxingCompetitorView();
        BoxingCompetitorController BController = new BoxingCompetitorController(Bcompetitor, BView);
        String Fresults = BController.FullView();
        return Fresults;

    }
         // printing the player summary statistics ( total, average, max, min)
    public String PlayerSummaryStatictics(String name ,double[] scores){

        String Message = "Printing " + name +" Summary Statistics : ";
        System.out.println(Message);
        double total = 0;
        for(double score : scores){
            total += score ; 
        }
         
        double average = total / scores.length;
        Arrays.sort(scores);
        double max = scores[scores.length-1];
        double min = scores[0]; 
     

        String result = "Total Score = " + total + "\n" + "Average = " + average + "\n" + "Maximum Score = " + max + "\n" + "Minimum Score = " + min ;
        return result;

    }


    public String PlayerFrequencyStatistics( String name ,double[] scores){
        String Message = "Printing " + name +" Frequency Statistics : ";
        System.out.println(Message);
        String result ="";
        int[] ArrayofFrequencies = new int[6];
        for (double score : scores) {
            int index = (int)score;
            ArrayofFrequencies[index]++;
        }
        for(int i = 0 ; i <= 5; i++)
        {
            result += "Frequency of Score " + i + " = " + ArrayofFrequencies[i] + "\n";
         }
        return result ;

    }
    
    



    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        competitorList.readCompetitorsFromFile();
        

        for (AthleticsCompetitor A : competitorList.APlayers) {
        String Fresults = competitorList.PrintAthleiticPlayerDetails(A);
        System.out.println(Fresults);

        String PlayerSummaryStatictics = competitorList.PlayerSummaryStatictics(A.getFirstName(),A.getScores()) ; 
        System.out.println(PlayerSummaryStatictics);

        String PlayerFrequencyStatistics = competitorList.PlayerFrequencyStatistics(A.getFirstName() , A.getScores());
        System.out.println(PlayerFrequencyStatistics);

        }

        for (BoxingCompetitor B : competitorList.BPlayers) {
        String Fresults = competitorList.PrintBoxingPlayerDetails(B);
        System.out.println(Fresults);

        String PlayerSummaryStatictics = competitorList.PlayerSummaryStatictics(B.getFirstName(),B.getScores()) ; 
        System.out.println(PlayerSummaryStatictics);

        String PlayerFrequencyStatistics = competitorList.PlayerFrequencyStatistics(B.getFirstName() , B.getScores());
        System.out.println(PlayerFrequencyStatistics);

        }
       
    }
  
 }


