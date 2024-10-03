import java.util.Scanner;

/**
 * Project01 -- Hockey Scores
 * <p>
 * Prompts the user for the name of two hockey teams, the scores of their seven games, and the power play goals for
 * each team each game. The program will output the winning team, final score, total goals by each team, power play
 * goals by each team, standard goals by each team, shutouts by each team, and the maximum number of points
 * scored by a team in a single game.
 *
 * @author Dylan Miller
 * @version 09/25/2022
 */

public class HockeyScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter the name of team 1.");
        String teamOne = scanner.nextLine();
        System.out.println("Enter the name of team 2.");
        String teamTwo = scanner.nextLine();
        System.out.println("Enter hockey scores for seven games.");
        String scores = scanner.nextLine();
        System.out.println("Enter the number of power play goals for both teams in each game.");
        String powerPlay = scanner.nextLine();
        scanner.close();

        // The values of each of the scores are defined below, you should use these int variables
        /* The string has 7 scores so the format of the string is
         * scoreOneTeamOne-scoreOneTeamTwo,scoreTwoTeamOne-scoreTwoTeamTwo,scoreThreeTeamOne-scoreThreeTeamTwo,
         * ...
         */

        int currentScoreIndex = 0;
        int scoreOneTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreOneTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreTwoTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreTwoTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreThreeTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreThreeTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFourTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFourTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFiveTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFiveTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSixTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSixTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSevenTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSevenTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        // The values of each of the power play goals are defined below, you should use these int variables
        /* The string has the number of power play goals listed for both teams in each of the seven games so
         * the format of the string is
         * powerPlayOneTeamOne-powerPlayOneTeamTwo,powerPlayTwoTeamOne-powerPlayTwoTeamTwo,powerPlayThreeTeamOne-powerPlayThreeTeamTwo,
         * ...
         */

        int currentPowerPlayIndex = 0;
        int powerPlayOneTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayOneTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayTwoTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayTwoTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayThreeTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayThreeTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFourTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFourTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFiveTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFiveTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySixTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySixTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySevenTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySevenTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));

        //sums team1 and team2 wins
        int win1 = 0;
        int win2 = 0;
        if (scoreOneTeamOne > scoreOneTeamTwo) win1++;
        else win2++;
        if (scoreTwoTeamOne > scoreTwoTeamTwo) win1++;
        else win2++;
        if (scoreThreeTeamOne > scoreThreeTeamTwo) win1++;
        else win2++;
        if (scoreFourTeamOne > scoreFourTeamTwo) win1++;
        else win2++;
        if (scoreFiveTeamOne > scoreFiveTeamTwo) win1++;
        else win2++;
        if (scoreSixTeamOne > scoreSixTeamTwo) win1++;
        else win2++;
        if (scoreSevenTeamOne > scoreSevenTeamTwo) win1++;
        else win2++;

        //prints winning team and the game score
        if (win1 > win2) System.out.printf("The " + teamOne + " won the series by a score of %d-%d%n", win1, win2);
        else System.out.printf("The " + teamTwo + " won the series by a score of %d-%d%n", win2, win1);

        int goals1 = scoreOneTeamOne + scoreTwoTeamOne + scoreThreeTeamOne + scoreFourTeamOne + scoreFiveTeamOne +
                scoreSixTeamOne + scoreSevenTeamOne; //sums team1 total goals
        int goals2 = scoreOneTeamTwo + scoreTwoTeamTwo + scoreThreeTeamTwo + scoreFourTeamTwo + scoreFiveTeamTwo +
                scoreSixTeamTwo + scoreSevenTeamTwo; //sums team2 total goals
        if (goals1 == 1) System.out.printf("The " + teamOne + " scored " + goals1 + " total goal%n");
        else System.out.printf("The " + teamOne + " scored " + goals1 + " total goals%n");
        if (goals2 == 1) System.out.printf("The " + teamTwo + " scored " + goals2 + " total goal%n");
        else System.out.printf("The " + teamTwo + " scored " + goals2 + " total goals%n");

        int power1 = powerPlayOneTeamOne + powerPlayTwoTeamOne + powerPlayThreeTeamOne + powerPlayFourTeamOne +
                powerPlayFiveTeamOne + powerPlaySixTeamOne + powerPlaySevenTeamOne; //sums team1 power play goals
        int power2 = powerPlayOneTeamTwo + powerPlayTwoTeamTwo + powerPlayThreeTeamTwo + powerPlayFourTeamTwo +
                powerPlayFiveTeamTwo + powerPlaySixTeamTwo + powerPlaySevenTeamTwo; //sums team2 power play goals
        if (power1 == 1) System.out.printf("The " + teamOne + " scored " + power1 + " power play goal%n");
        else System.out.printf("The " + teamOne + " scored " + power1 + " power play goals%n");
        if (power2 == 1) System.out.printf("The " + teamTwo + " scored " + power2 + " power play goal%n");
        System.out.printf("The " + teamTwo + " scored " + power2 + " power play goals%n");

        if ((goals1 - power1) == 1) System.out.printf("The " + teamOne + " scored " + (goals1 - power1) +
                " standard goals%n");
        else System.out.printf("The " + teamOne + " scored " + (goals1 - power1) + " standard goals%n");
        if ((goals2 - power2) == 1) System.out.printf("The " + teamTwo + " scored " + (goals2 - power2) +
                " standard goal%n");
        else System.out.printf("The " + teamTwo + " scored " + (goals2 - power2) + " standard goals%n");

        int shutouts1 = 0; //sums team1 shutouts
        if (scoreOneTeamTwo == 0) shutouts1++;
        if (scoreTwoTeamTwo == 0) shutouts1++;
        if (scoreThreeTeamTwo == 0) shutouts1++;
        if (scoreFourTeamTwo == 0) shutouts1++;
        if (scoreFiveTeamTwo == 0) shutouts1++;
        if (scoreSixTeamTwo == 0) shutouts1++;
        if (scoreSevenTeamTwo == 0) shutouts1++;

        int shutouts2 = 0; //sums team2 shutouts
        if (scoreOneTeamOne == 0) shutouts2++;
        if (scoreOneTeamOne == 0) shutouts2++;
        if (scoreThreeTeamOne == 0) shutouts2++;
        if (scoreFourTeamOne == 0) shutouts2++;
        if (scoreFiveTeamOne == 0) shutouts2++;
        if (scoreSixTeamOne == 0) shutouts2++;
        if (scoreSevenTeamOne == 0) shutouts2++;

        if (shutouts1 == 1) System.out.printf("The " + teamOne + " recorded " + shutouts1 + " shutout%n");
        else System.out.printf("The " + teamOne + " recorded " + shutouts1 + " shutouts%n");
        if (shutouts2 == 1) System.out.printf("The " + teamTwo + " recorded " + shutouts2 + " shutout%n");
        System.out.printf("The " + teamTwo + " recorded " + shutouts2 + " shutouts%n");

        int maxGoals = 0; //max goals scored in a single game
        int gameNum = 0; //game number associated with maxGoals
        String teamName = ""; //name of the team associated with maxGoals
        if (scoreOneTeamOne > maxGoals || scoreOneTeamTwo > maxGoals) {
            if (scoreOneTeamOne > scoreOneTeamTwo) {
                maxGoals = scoreOneTeamOne;
                teamName = teamOne;
            } else {
                maxGoals = scoreOneTeamTwo;
                teamName = teamTwo;
            }
            gameNum = 1;
        }

        if (scoreTwoTeamOne > maxGoals || scoreTwoTeamTwo > maxGoals) {
            if (scoreTwoTeamOne > scoreTwoTeamTwo) {
                maxGoals = scoreTwoTeamOne;
                teamName = teamOne;
            } else {
                maxGoals = scoreTwoTeamTwo;
                teamName = teamTwo;
            }
            gameNum = 2;
        }

        if (scoreThreeTeamOne > maxGoals || scoreThreeTeamTwo > maxGoals) {
            if (scoreThreeTeamOne > scoreThreeTeamTwo) {
                maxGoals = scoreThreeTeamOne;
                teamName = teamOne;
            } else {
                maxGoals = scoreThreeTeamTwo;
                teamName = teamTwo;
            }
            gameNum = 3;
        }

        if (scoreFourTeamOne > maxGoals || scoreFourTeamTwo > maxGoals) {
            if (scoreFourTeamOne > scoreFourTeamTwo) {
                maxGoals = scoreFourTeamOne;
                teamName = teamOne;
            } else {
                maxGoals = scoreFourTeamTwo;
                teamName = teamTwo;
            }
            gameNum = 4;
        }

        if (scoreFiveTeamOne > maxGoals || scoreFiveTeamTwo > maxGoals) {
            if (scoreFiveTeamOne > scoreFiveTeamTwo) {
                maxGoals = scoreFiveTeamOne;
                teamName = teamOne;
            } else {
                maxGoals = scoreFiveTeamTwo;
                teamName = teamTwo;
            }
            gameNum = 5;
        }

        if (scoreSixTeamOne > maxGoals || scoreSixTeamTwo > maxGoals) {
            if (scoreSixTeamOne > scoreSixTeamTwo) {
                maxGoals = scoreSixTeamOne;
                teamName = teamOne;
            } else {
                maxGoals = scoreSixTeamTwo;
                teamName = teamTwo;
            }
            gameNum = 6;
        }

        if (scoreSevenTeamOne > maxGoals || scoreSevenTeamTwo > maxGoals) {
            if (scoreSevenTeamOne > scoreSevenTeamTwo) {
                maxGoals = scoreSevenTeamOne;
                teamName = teamOne;
            } else {
                maxGoals = scoreSevenTeamTwo;
                teamName = teamTwo;
            }
            gameNum = 7;
        }

        System.out.println("The maximum number of goals scored was " + maxGoals + " by the " + teamName + " in game " +
                gameNum);
    }
}