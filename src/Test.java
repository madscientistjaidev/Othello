public class Test
{    
    public static void main(String args[])
    {
        Test t = new Test();
        
        
        
        System.out.println(t.MinMaxPlay(8));
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

        // Return the result of the game:
        String result = "Score = " + state.score() + "\n" + state;
        return result;
    }
    
    /**Plays a game with a MinMax player versus a random player.
     * @param boardSize*/
    String MinMaxPlay(int boardSize)
    {
        // Create the game state with the initial position for an 8x8 board:
        OthelloState state = new OthelloState(boardSize);
        OthelloPlayer players[] = {new MinMaxPlayer(5), new OthelloRandomPlayer()};
        
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