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
        refreshAllCellsAliveNeighbourAmount();
    }

    public Cell getCellAt(Point point) {
        return isWithinEdge(point) ? cells[point.x - 1][point.y - 1] : new Cell(DEAD);
    }

    public int countAliveNeighbourAmount(Point point) {
        if (!isWithinEdge(point)) {
            return 0;
        }
        int amount = 0;
        for (int ptX = point.x - 1; ptX <= point.x + 1; ++ptX) {
            for (int ptY = point.y - 1; ptY <= point.y + 1; ++ptY) {
                Point currPoint = new Point(ptX, ptY);
                if (isWithinEdge(currPoint) && isNotSelf(point, currPoint) && isCellAlive(currPoint)) {
                    ++amount;
                }
            }
        }
        return amount;
    }

    public void goNextGeneration() {
        pushAllCellsToNextGeneration();
        refreshAllCellsAliveNeighbourAmount();
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


    private void refreshAllCellsAliveNeighbourAmount() {
        for (int x = 0; x < row; ++x) {
            for (int y = 0; y < column; ++y) {
                cells[x][y].setAliveNeighbourAmount(countAliveNeighbourAmount(new Point(x + 1, y + 1)));
            }
        }
    }

    private boolean isCellAlive(Point point) {
        return ALIVE.equals(cells[point.x - 1][point.y - 1].getStatus());
    }

    private boolean isNotSelf(Point point, Point currPoint) {
        return point.x != currPoint.x || point.y != currPoint.y;
    }

    private void pushAllCellsToNextGeneration() {
        for (int x = 0; x < row; ++x) {
            for (int y = 0; y < column; ++y) {
                cells[x][y] = cells[x][y].generateNext();
            }
        }
    }
}
