import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.management.loading.PrivateClassLoader;
import javax.naming.spi.DirStateFactory.Result;

public class Staff {
    private String FirstName;
    private String SecondName;
    private String Email;
    private String Password;
    private int ID;
    private static CompetitorList competitorlist; 
    private static  String AcsvFile = "Athletics.csv";
    public static String BcsvFile = "Boxing.csv";
    private static int IDcounter = 0;

    public Staff(String FirstName , String SecondName , String Email , String Password){

        this.ID = IDcounter;
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.Email = Email;
        this.Password = Password;
        IDcounter ++;
        competitorlist.readCompetitorsFromFile(AcsvFile);
        competitorlist.readCompetitorsFromFile(BcsvFile);

    }

    public String SearchCompetitorFullDetails(int ID , Boolean report)
    {

        
        for(AthleticsCompetitor AC : competitorlist.APlayers){
            if (AC.getIDnumber() == ID)
            {
                AthleticsCompetitorView View = new AthleticsCompetitorView();
                AthleticsCompetitorController ACTRL = new AthleticsCompetitorController(AC, View);
                return ACTRL.FullView();
            }
        }

        for(BoxingCompetitor BC : competitorlist.BPlayers){
            if (BC.getIDnumber() == ID)
            {
                BoxingCompetitorView View = new BoxingCompetitorView();
                BoxingCompetitorController BCTRL = new BoxingCompetitorController(BC, View);
                return BCTRL.FullView();
            }
 
        }

        return "This Competitor Is Not Found !";
   } 





    public String SearchCompetitorShortDetails(int ID , Boolean Report)
    {

        
        for(AthleticsCompetitor AC : competitorlist.APlayers){
            if (AC.getIDnumber() == ID)
            {
                AthleticsCompetitorView View = new AthleticsCompetitorView();
                AthleticsCompetitorController ACTRL = new AthleticsCompetitorController(AC, View);
                if(Report == false)
                {
                    PrintReport(AC, null);
                }
                return ACTRL.ShortView();
            }
        }

        for(BoxingCompetitor BC : competitorlist.BPlayers){
            if (BC.getIDnumber() == ID)
            {
                BoxingCompetitorView View = new BoxingCompetitorView();
                BoxingCompetitorController BCTRL = new BoxingCompetitorController(BC, View);
                if (Report == true)
                {
                    PrintReport(null, BC);
                }
                return BCTRL.ShortView();
            }
        } 

        return "This Competitor Is Not Found !";

   } 



   public void PrintReport(AthleticsCompetitor AC, BoxingCompetitor BC)
   {
    String [] Results ;
    String File = "Competitor.txt";

    if(AC != null)
    {
        ArrayList<AthleticsCompetitor> AAC = new ArrayList<>();
        AAC.add(AC);
        Results = competitorlist.FinalReport(AAC , null);
    }
    else 
    {
        ArrayList<BoxingCompetitor> ABC = new ArrayList<>();
        ABC.add(BC);
        Results = competitorlist.FinalReport(null , ABC);
    }

    try {
        BufferedWriter Writer = new BufferedWriter(new FileWriter(File));
        for (String playerresult : Results) 
        {
            Writer.write(playerresult);
            Writer.newLine();
        }
        Writer.close();
        System.out.println("Data of competitor has been written to the file ");
    } catch (IOException e)
    {
        e.printStackTrace();
    }

   }

   public void FillScores(AthleticsCompetitor AC , BoxingCompetitor BC)
   {
        if(AC != null)
        {
            String csvFile = "Athletics.csv";
            {}
        }
   }
   public void EditCsvFile(String csvfile, double[] Scores , int ID)
   {
        try{
            BufferedReader Reader = new BufferedReader(new FileReader(csvfile));
            PrintWriter Writer = new PrintWriter(new FileWriter(csvfile));
            String line;
            while ((line = Reader.readLine()) != null)
            {
                String[] values = line.split(",");

                if(values[0].equals(ID))
                {
                    int count = 9;
                    for(double Score :Scores)
                    {
                        values[count] = Double.toString(Score);
                        count++;
                    }   
                    for(int i = 0 ; i<values.length;i++)
                    {
                        Writer.print(values[i]);
                        if(i<values.length -1 )
                        {
                            Writer.print(",");
                        }
                    }

                }
                

            }
            Writer.close();
            Reader.close();
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }

   }
  
}




