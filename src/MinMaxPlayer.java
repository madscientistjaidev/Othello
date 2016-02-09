import java.util.List;

public class MinMaxPlayer extends OthelloPlayer
{
    int depth;
    
    MinMaxPlayer(int depth)
    {
        this.depth = depth;
    }
    
    /**Returns best move.
     * @param state
     */
    @Override
    public OthelloMove getMove(OthelloState state)
    {
        //Generates list of moves.
        List<OthelloMove> moves = state.generateMoves();
        
        //If there are no possible moves, return null.
        if(moves.isEmpty()) return null;
        
        if(state.nextPlayerToMove==0) return maxMove(state, moves);
        return minMove(state, moves);
    }
    
    /**Returns the move with the maximum score.
     * @param state
     * @param moves
     */
    private OthelloMove maxMove(OthelloState state, List<OthelloMove> moves)
    {
        OthelloMove maxMove = moves.get(0);
        OthelloState tempState;
        
        for(OthelloMove m : moves)
        {
            tempState = state.applyMoveCloning(m);
            if(tempState.score()>state.applyMoveCloning(maxMove).score())
                maxMove=m;
        }
        
        return maxMove;
    }
    
    /**Returns the move with the minimum score.
     * @param state
     * @param moves
     */
    private OthelloMove minMove(OthelloState state, List<OthelloMove> moves)
    {
        OthelloMove maxMove = moves.get(0);
        OthelloState tempState;
        
        for(OthelloMove m : moves)
        {
            tempState = state.applyMoveCloning(m);
            if(tempState.score()<state.applyMoveCloning(maxMove).score())
                maxMove=m;
        }
        
        return maxMove;
    }
}