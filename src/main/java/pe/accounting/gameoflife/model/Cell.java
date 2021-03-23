package pe.accounting.gameoflife.model;

public class Cell {
    private CellStatus status;

    public Cell() {
        this.status = CellStatus.DEAD;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }
}
