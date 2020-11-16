import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element{
    Monster(int x, int y){
        super(x,y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "M");
    }

    public Position moveTowards(Position posi){
        Position pos = this.pos;
        if(this.pos.getX() >= posi.getX() && this.pos.getY() >= posi.getY()) {
            pos.setX(pos.getX() - 1);
            pos.setY(pos.getY() - 1);
        }
        else if(this.pos.getX() > posi.getX() && this.pos.getY() < posi.getY()) {
            pos.setX(pos.getX() - 1);
            pos.setY(pos.getY() + 1);
        }
        else if(this.pos.getX() < posi.getX() && this.pos.getY() > posi.getY()) {
            pos.setX(pos.getX() + 1);
            pos.setY(pos.getY() - 1);
        }
        else if(this.pos.getX() <= posi.getX() && this.pos.getY() <= posi.getY()) {
            pos.setX(pos.getX() + 1);
            pos.setY(pos.getY() + 1);
        }

        return pos;
    }
}
