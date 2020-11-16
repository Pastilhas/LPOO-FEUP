import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{
    Hero(int x, int y){
        super(x,y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#101010"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "X");
    }

    public Position moveUp(){ return new Position(pos.getX(), pos.getY() - 1); }
    public Position moveDown(){ return new Position(pos.getX(), pos.getY() + 1); }
    public Position moveLeft(){ return new Position(pos.getX() - 2, pos.getY()); }
    public Position moveRight(){ return new Position(pos.getX() + 2, pos.getY()); }
}
