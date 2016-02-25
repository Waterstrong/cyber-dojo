package kata.conway;

import static kata.conway.CellStatus.*;

public class Cell {
    private CellStatus status;
    private int aliveNeighbourCount;

    public Cell(CellStatus status) {
        this.status = status;
    }

    public Cell generateNext() {
        return ((status == ALIVE && aliveNeighbourCount == 2) || aliveNeighbourCount == 3) ?
                new Cell(ALIVE) : new Cell(DEAD);
    }

    public void setAliveNeighbourCount(int aliveNeighbourCount) {
        this.aliveNeighbourCount = aliveNeighbourCount;
    }

    public CellStatus getStatus() {
        return status;
    }
}
