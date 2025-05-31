package com.mycompany.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.awt.GridLayout;
import java.awt.Component;

public class AppTest {

    @Test
    void checkState_XWinsFirstRow() {
        Game game = new Game();
        char[] board = {'X','X','X',' ',' ',' ',' ',' ',' '};
        game.symbol = 'X';
        assertEquals(State.XWIN, game.checkState(board));
    }

    @Test
    void checkState_OWinsDiagonal() {
        Game game = new Game();
        char[] board = {'O',' ',' ',' ','O',' ',' ',' ','O'};
        game.symbol = 'O';
        assertEquals(State.OWIN, game.checkState(board));
    }

    @Test
    void checkState_Draw() {
        Game game = new Game();
        char[] board = {'X','O','X','X','X','O','O','X','O'};
        game.symbol = 'X';
        assertEquals(State.DRAW, game.checkState(board));
    }

    @Test
    void checkState_Playing() {
        Game game = new Game();
        char[] board = {'X',' ',' ',' ',' ',' ',' ',' ','O'};
        game.symbol = 'X';
        assertEquals(State.PLAYING, game.checkState(board));
    }

    @Test
void generateMoves_EmptyBoard() {
    Game game = new Game();
    ArrayList<Integer> moves = new ArrayList<>();
    char[] emptyBoard = new char[9];
    Arrays.fill(emptyBoard, ' ');
    game.generateMoves(emptyBoard, moves);
    assertEquals(9, moves.size());
}
    @Test
    void generateMoves_PartialBoard() {
        Game game = new Game();
        char[] board = {'X',' ','O',' ','X',' ',' ','O',' '};
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(board, moves);
        Integer[] expected = {1, 3, 5, 6, 8};
        assertArrayEquals(expected, moves.toArray());
    }

    @Test
    void evaluatePosition_WinForPlayer() {
        Game game = new Game();
        char[] board = {'X','X','X',' ',' ',' ',' ',' ',' '};
        game.symbol = 'X';
        Player player = game.player1;
        assertEquals(Game.INF, game.evaluatePosition(board, player));
    }

    @Test
    void evaluatePosition_LossForPlayer() {
        Game game = new Game();
        char[] board = {'O','O','O',' ',' ',' ',' ',' ',' '};
        game.symbol = 'O';
        Player player = game.player1;
        assertEquals(-Game.INF, game.evaluatePosition(board, player));
    }

    @Test
    void evaluatePosition_Draw() {
        Game game = new Game();
        char[] board = {'X','O','X','X','X','O','O','X','O'};
        game.symbol = 'X';
        Player player = game.player1;
        assertEquals(0, game.evaluatePosition(board, player));
    }

  
@Test
void minimax_FindsWinningMove() {
    Game game = new Game();
    char[] board = {
        'O', 'X', 'X',
        'X', 'O', ' ',
        ' ', ' ', ' '
    };
    game.symbol = 'O';
    int bestMove = game.MiniMax(board, game.player2);
    assertEquals(9, bestMove);
}

    @Test
    void checkState_WinSecondColumn() {
        Game game = new Game();
        char[] board = {'X',' ',' ','X',' ',' ','X',' ',' '};
        game.symbol = 'X';
        assertEquals(State.XWIN, game.checkState(board));
    }

    @Test
    void checkState_WinThirdColumn() {
        Game game = new Game();
        char[] board = {' ','X',' ',' ','X',' ',' ','X',' '};
        game.symbol = 'X';
        assertEquals(State.XWIN, game.checkState(board));
    }

    @Test
    void checkState_WinReverseDiagonal() {
        Game game = new Game();
        char[] board = {' ',' ','O',' ','O',' ','O',' ',' '};
        game.symbol = 'O';
        assertEquals(State.OWIN, game.checkState(board));
    }

    @Test
    void evaluatePosition_Playing() {
        Game game = new Game();
        char[] board = {'X',' ',' ',' ',' ',' ',' ',' ','O'};
        game.symbol = 'X';
        Player player = game.player1;
        assertEquals(-1, game.evaluatePosition(board, player));
    }

    @Test
    void generateMoves_FullBoard() {
        Game game = new Game();
        char[] board = {'X','O','X','O','X','O','O','X','O'};
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(board, moves);
        assertTrue(moves.isEmpty());
    }

    @Test
    void utilityPrintCharArray() {
        Utility.print(new char[]{'X', 'O', ' ', 'X', ' ', 'O', ' ', ' ', 'X'});
        assertTrue(true);
    }

    @Test
    void utilityPrintIntArray() {
        Utility.print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertTrue(true);
    }

    @Test
    void utilityPrintArrayList() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        Utility.print(list);
        assertTrue(true);
    }

    @Test
    void minimax_RandomMoveSelection() {
        Game game = new Game();
        char[] board = {
            'X', 'O', 'X',
            'O', ' ', 'X',
            ' ', ' ', ' '
        };
        game.symbol = 'O';
        int bestMove = game.MiniMax(board, game.player2);
        assertTrue(bestMove == 5 || bestMove == 7 || bestMove == 9);
    }

    @Test
    void minMove_TerminalWin() {
        Game game = new Game();
        char[] board = {
            'X', 'X', 'X',
            ' ', ' ', ' ',
            ' ', ' ', ' '
        };
        game.symbol = 'X';
        int result = game.MinMove(board, game.player1);
        assertEquals(Game.INF, result);
    }

    @Test
    void maxMove_TerminalWin() {
        Game game = new Game();
        char[] board = {
            'O', 'O', ' ',
            ' ', 'O', ' ',
            ' ', ' ', 'O'
        };
        game.symbol = 'O';
        int result = game.MaxMove(board, game.player2);
        assertEquals(Game.INF, result);
    }

    @Test
    void minimax_SelectsFromEqualMoves() {
        Game game = new Game();
        char[] board = {
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' '
        };
        game.symbol = 'X';
        int move = game.MiniMax(board, game.player1);
        assertTrue(move >= 1 && move <= 9);
    }
      @Test
    public void testConstructorAndGetters() {
        TicTacToeCell cell = new TicTacToeCell(5,1,2);
        assertEquals(5, cell.getNum());
        assertEquals(1, cell.getCol());
        assertEquals(2, cell.getRow());
        assertEquals(' ', cell.getMarker());
        assertTrue(cell.isEnabled());
    }

    @Test
    public void testSetMarkerDisablesAndSetsText() {
        TicTacToeCell cell = new TicTacToeCell(0,0,0);
        cell.setMarker("O");
        assertEquals('O', cell.getMarker());
        assertFalse(cell.isEnabled());
        assertEquals("O", cell.getText());
    }
      @Test
    public void testPanelInitialization() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        assertEquals(9, panel.getComponentCount());
        TicTacToeCell c4 = (TicTacToeCell)panel.getComponent(4);
        assertEquals(4, c4.getNum());
        assertEquals(1, c4.getCol());
        assertEquals(1, c4.getRow());
        assertEquals(' ', c4.getMarker());
    }

    @Test
    public void testPanelClickProducesOneXOneO() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3,3));
        TicTacToeCell first = (TicTacToeCell)panel.getComponent(0);
        first.doClick();
        int xCount=0, oCount=0;
        for (Component c: panel.getComponents()) {
            if (!(c instanceof TicTacToeCell)) continue;
            char m = ((TicTacToeCell)c).getMarker();
            if (m=='X') xCount++;
            if (m=='O') oCount++;
        }
        assertEquals(1, xCount);
        assertEquals(1, oCount);
    }

}
