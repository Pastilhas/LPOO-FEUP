import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Screen screen;
    private Hero hero;
    private TextGraphics graphics;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    private int points;

    public Arena(int width, int height, Screen screen){
        this.width = width;
        this.height = height;
        this.screen = screen;
        this.hero = new Hero(10,10);
        this.graphics = screen.newTextGraphics();
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c <= width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height));
        }

        for (int r = 1; r < height; r++) {
            walls.add(new Wall(1, r));
            walls.add(new Wall(width - 1, r));
        }
        for (int r = 1; r < height; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        ArrayList<Position> poss = new ArrayList<>();
        Position pos;

        for (int i = 0; i < 5; i++){
            pos = new Position(random.nextInt(width - 4) + 2, random.nextInt(height - 2) + 1);
            if((pos.getX() % 2) != 0 && pos.getX() < width - 2) {
                pos.setX(pos.getX() + 1);
            }
            if((pos.getX() % 2) != 0 && pos.getX() > 2) {
                pos.setX(pos.getX() - 1);
            }
            if(!poss.contains(pos))
                coins.add(new Coin(pos.getX(),pos.getY()));
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        Position pos;

        for (int i = 0; i < 2; i++){
            pos = new Position(random.nextInt(width - 4) + 2, random.nextInt(height - 2) + 1);
            if((pos.getX() % 2) == 0 && pos.getX() < width - 2) {
                pos.setX(pos.getX() + 1);
            }
            if((pos.getX() % 2) == 0 && pos.getX() > 2) {
                pos.setX(pos.getX() - 1);
            }
            if(!hasElement(pos))
                monsters.add(new Monster(pos.getX(),pos.getY()));
        }
        return monsters;
    }

    public void draw() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(2, 1), new TerminalSize(width-3, height-1), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
        hero.draw(graphics);

    }

    public boolean processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()){
            case Character:
                if(key.getCharacter() == 'q' || key.getCharacter() == 'Q')
                    screen.close();
                break;
            case Escape:
                screen.close();
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case EOF:
                return false;
        }
        return true;
    }

    private void moveHero(Position pos){
        if(canHeroMove(pos)) {
            hero.setPos(pos);
            if(hasCoin(pos)){
                points++;
            }
        }
    }

    public void moveMonsters(){
        for (Monster monster : monsters){
            monster.setPos(monster.moveTowards(hero.getPos()));
        }
    }

    public boolean verifyCollisions() throws IOException{
        if(!monsters.isEmpty())
        for(Monster mon : monsters){
            if(mon.getPos().equals(hero.getPos())){
                screen.close();
            }
        }

        return false;
    }

    private boolean canHeroMove(Position pos){
        for (Wall wall : this.walls) {
            if(wall.getPos().equals(pos)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasElement(Position pos){
        if(hero.getPos().equals(pos))
            return true;

        if(!walls.isEmpty()) {
            for (Wall wall : this.walls) {
                if (wall.getPos().equals(pos)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCoin(Position pos){
        Coin c = null;
        boolean found = false;
        for (Coin coin : this.coins) {
            if(coin.getPos().equals(pos)) {
                c = coin;
                found = true;
                break;
            }
        }
        if(found)
            this.coins.remove(c);
        
        return found;
    }
}
