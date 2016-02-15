import java.util.List;
import java.util.Random;

public class MonteCarloPlayer
{
    int iterations;
    
    MonteCarloPlayer(int maxIterations)
    {
        this.iterations = iterations;
    }
    
    public OthelloMove getMove(OthelloState state, int maxIterations, int iterations)
    {
        Random r = new Random();
        
        OthelloState root = state;
        OthelloState node = state;
        
        // generate the list of moves:
        List<OthelloMove> moves = state.generateMoves();
        
        if(iterations==maxIterations)
        {
            //Random move
            if (!moves.isEmpty())
            {
                if(state.nextPlayerToMove==0)
                {
                    int bestCost = -2147483648;
                    
                    OthelloMove childMove = moves.get(r.nextInt(moves.size()));
                    
                    if(state.score()>=state.applyMoveCloning(childMove).score());
                }
            }
        }
        
        
        
        return action(bestChild(root));
        
    }
    
    public OthelloMove getRandomMove(OthelloState state)
    {
        Random r = new Random();

        // generate the list of moves:
        List<OthelloMove> moves = state.generateMoves();           
        
        // return one at random:
        if (!moves.isEmpty()) return moves.get(r.nextInt(moves.size()));
        
        // If there are no possible moves, just return "pass":
        return null;
    }
}