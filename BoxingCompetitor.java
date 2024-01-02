
// Model Class in MVC Design Pattern
public class BoxingCompetitor extends Competitor {

    private int[] Scores = new int[5];
    private String Gametype;

    BoxingCompetitor(String Email, String Password, String Country, int Age, String F_name, String L_name,
            String Level, String Gender, int[] Scores) {

        // Calling the Constructor of the Superclass (Competitor)
        super(Email, Password, Country, Age, F_name, L_name, Level, Gender);
        this.Scores = Scores;
        this.Gametype = "Boxing";
    }

    // to get all scores as String
    public String getScoreArray() {
        String AllScore = "";
        for (int Score : Scores) {
            AllScore += Score + " ";
        }
        return AllScore;

    }

    public int[] getScores() {
        return Scores;
    }

    public void setScores(int[] scores) {
        Scores = scores;
    }

    public String getGametype() {
        return Gametype;
    }

    @Override
    public double getOverAllScore() {
        double average = (Scores[1] + Scores[2] + Scores[3]) / 3;
        return average;
    }

    // // to print the competitor details
    // public static void main(String[] args) {
    // int [] Scores = {1,2,3,4,6};
    // BoxingCompetitor S = new BoxingCompetitor( "Mark@gmail", "5555", "Egypt", 22,
    // "Mark", "ELissa", "Beginner", "Male", Scores);
    // System.out.println(S.getFullDetails());

    // BoxingCompetitor S4 = new BoxingCompetitor( "Mark@gmail", "5555", "Egypt",
    // 22, "Mark", "ELissa", "Beginner", "Male", Scores);
    // System.out.println(S4.getShortDetails()); //could be changed get.....
    // }
}

// View Class In MVC Design Pattern
class BoxingCompetitorView extends Competitorview {

    // Returning Full Details of the competitor
    public String getFullDetails(int IDnumber, String Email, String Country, int Age, String F_name, String L_name,
            String Level, String Gender, String ScoreArray, float OverAllScore, String GameTtype) {
        return " Competitor number " + IDnumber + "\n" + "Name : " + F_name + " " + L_name + " is " + Gender
                + "Game Type : " + GameTtype +
                "\n" + "Email : " + Email + "\n" + "Country : " + Country + "\n" + F_name + " is a " + Level
                + " Aged " + Age + " and recived scores : " + ScoreArray + " \n" + "Has an OverAllScore : "
                + OverAllScore;
    }
}

// Controller Class in MVC Design
class BoxingCompetitorController extends CompetitorController {
    BoxingCompetitor Model;
    BoxingCompetitorView View;

    public BoxingCompetitorController(BoxingCompetitor Model, BoxingCompetitorView View) {
        this.Model = Model;
        this.View = View;
    }

    public int[] getScores() {
        return Model.getScores();
    }

    public void setScores(int[] scores) {
        Model.setScores(scores);
    }

    public String getGametype() {
        return Model.getGametype();
    }

    public String getScoreArray() {

        String AllScore = "";
        for (int Score : Model.getScores()) {
            AllScore += Score + " ";
        }
        return AllScore;

    }

    // Full DetailsView

    // Short DetailsView

}
