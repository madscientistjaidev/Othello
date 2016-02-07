public class Player extends OthelloPlayer
{
    int depth;
    
    Player(int depth)
    {
        this.depth = depth;
    }
    
    @Override
    public OthelloMove getMove(OthelloState state)
    {
        return null;
    }
}