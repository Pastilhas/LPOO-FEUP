import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position pos;

    protected Element(int x, int y) {
        this.pos = new Position(x,y);
    }

    public abstract void draw(TextGraphics graphics);

    public void setPos(Position pos) {
        this.pos = pos;
    }
    public Position getPos() {
        return this.pos;
    }
}
