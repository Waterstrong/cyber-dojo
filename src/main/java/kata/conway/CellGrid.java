package kata.conway;

import static java.util.Arrays.asList;
import static kata.conway.CellStatus.ALIVE;
import static kata.conway.CellStatus.DEAD;

import java.awt.*;
import java.util.List;

public class CellGrid {
    private int row;
    private int column;
    private Cell[][] cells;

    public CellGrid(int row, int column, Point... alivePoints) {
        this.row = row;
        this.column = column;
        cells = new Cell[row][column];
        setCellsAliveAt(alivePoints);
    }

    public Cell getCell(Point point) {
        return isWithinEdge(point) ? cells[point.x - 1][point.y - 1] : new Cell(DEAD);
    }

    private void setCellsAliveAt(Point... alivePoints) {
        List<Point> points = asList(alivePoints);
        for (int x = 0; x < row; ++x) {
            for (int y = 0; y < column; ++y) {
                cells[x][y] = points.contains(new Point(x + 1, y + 1)) ? new Cell(ALIVE) : new Cell(DEAD);
            }
        }
    }

    private boolean isWithinEdge(Point point) {
        return point.x > 0 && point.x <= row && point.y > 0 && point.y <= column;
    }
}
