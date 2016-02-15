import java.util.InputMismatchException;
import java.util.Scanner;

public class Test
{    
    /**
     *
     * @param args
     */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        Test t = new Test();
        
        System.out.println("Playing a MiniMax vs Random game");
        
        System.out.println("Enter board size. Default is 8");
        int boardSize = 8;
        try {boardSize = sc.nextInt();}
        catch(NumberFormatException | InputMismatchException e) {}
        
        System.out.println("Enter depth. Default is 5.");
        int maxDepth = 5;
        try {maxDepth = sc.nextInt();}
        catch(NumberFormatException | InputMismatchException e) {}

        System.out.println(t.MinMaxPlay(boardSize, maxDepth));
        
    }
    
    /**Plays a game with 2 random players.
     * @param boardSize*/
    String RandomPlay(int boardSize)
    {
        // Create the game state with the initial position for an 8x8 board:
        OthelloState state = new OthelloState(boardSize);
        OthelloPlayer players[] = {new OthelloRandomPlayer(), new OthelloRandomPlayer()};
        
        do
        {
            // Display the current state in the console:
            System.out.println("\nCurrent state, " + OthelloState.PLAYER_NAMES[state.nextPlayerToMove] + " to move:");
            System.out.print(state);
            
            // Get the move from the player:
            OthelloMove move = players[state.nextPlayerToMove].getMove(state);
            System.out.println(move);
            state = state.applyMoveCloning(move);            
        }
        while(!state.gameOver());

        //Returns the result of the game.
        String result = "Score = " + state.score() + "\n" + state;
        return result;
    }
    
    /**Plays a game with a MinMax player versus a random player.
     * @param boardSize*/
    String MinMaxPlay(int boardSize, int maxDepth)
    {
        // Create the game state with the initial position for an 8x8 board:
        OthelloState state = new OthelloState(boardSize);
        OthelloPlayer players[] = {new MiniMaxPlayer(maxDepth), new OthelloRandomPlayer()};
        
        do
        {
            // Display the current state in the console:
            System.out.println("\nCurrent state, " + OthelloState.PLAYER_NAMES[state.nextPlayerToMove] + " to move:");
            System.out.print(state);
            
            // Get the move from the player:
            OthelloMove move = players[state.nextPlayerToMove].getMove(state);
            System.out.println(move);
            state = state.applyMoveCloning(move);            
        }
        while(!state.gameOver());

        // Return the result of the game:
        String result = "Score = " + state.score() + "\n" + state;
        return result;
    }
}