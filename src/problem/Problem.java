package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import reference.UserConfiguration;

abstract class Problem {
    private final static String TOKEN = "asdkjfnsadnfjla923kjnf9201njf0923";
    
    protected final void submit(String problemName, UserConfiguration config, int score) {
        try {
            URL submitUrl = new URL(config.host + "/submit.php?problem=" + problemName + "&id=" + config.studentId + "&password=" + config.password + "&score=" + score + "&token=" + TOKEN);
            URLConnection connector = submitUrl.openConnection();

            System.out.println("Trying to submit your solution...");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connector.getInputStream()));
            String result = reader.readLine();

            // If submit was successful, the page will give an int 0.
            switch (Integer.parseInt(result)) {
                case 0:
                    System.out.println("Success submitting your solution.");
                    break;
                case 1:
                    System.out.println("Internal server error has occurred. Please contact your lecturer.");
                    break;
                case -1:
                    System.out.println("Can't submit your solution. Please check your submit data.");
                    break;
                case -2:
                    System.out.println("Library error. (Suspicious)");
                    break;
                case 2:
                    System.out.println("Your grade has been submitted, but it's lower than your previous point. It's not saved.");
                    break;
                default:
                    break;
            }
            
            reader.close();
        }
        catch (Exception ex) {
            System.out.println("Submit failed! Error: " + ex.getMessage());
        }

        System.out.println();
    }
    
    protected final void printResults(String problem, int score, int success, int fail) {
        System.out.println(problem + " Solution Evaluator");
        System.out.println("Implemented for Mid-Semester Test");
        System.out.println("Algorithms & Programming II Practice Session");
        System.out.println("Informatics Engineering, Universitas Paramadina");
        System.out.println("Result -> Success: " + success +"; Fail: " + fail + "; Score: " + score);
        if (score == 100) {
            System.out.println("Congratulations!");
        }

        System.out.println();
    }
}
