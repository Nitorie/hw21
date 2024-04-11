import javax.swing.*;
import java.awt.*;

public class CostomButton extends JButton {
    private int stepX;
    private int stepY;

    public CostomButton(int stepX, int stepY) {
        this.stepX = stepX;
        this.stepY = stepY;
    }

    public int getStepX() {
        return stepX;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
    }
}