import java.util.List;

public class MinMaxPlayer extends OthelloPlayer
{
    int depth;
    
    MinMaxPlayer(int depth)
    {
        this.depth = depth;
    }
    
    @Override
    public OthelloMove getMove(OthelloState state)
    {
        // generate the list of moves:
        List<OthelloMove> moves = state.generateMoves();
        if(moves.isEmpty()) return null;
        
        //Find Max move
        OthelloMove maxMove = moves.get(0);
        OthelloState tempState = null;
        
        for(OthelloMove m : moves)
        {
            tempState = state.applyMoveCloning(m);
            if(tempState.score()>state.applyMoveCloning(maxMove).score())
                maxMove=m;
        }
        
        // If there are no possible moves, just return "pass":
        return maxMove;
    }
}