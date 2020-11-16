import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    private Screen screen;
    private Arena arena;

    Game() throws IOException{
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        arena = new Arena(40,20, screen);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public void run() throws IOException{
        KeyStroke key;
        boolean eof = true;

        while(eof) {
            draw();
            key = screen.readInput();
            eof = arena.processKey(key);
            arena.verifyCollisions();
            arena.moveMonsters();
            arena.verifyCollisions();
        }
    }

    private void draw() throws IOException{
        screen.clear();
        arena.draw();
        screen.refresh();
    }
}
