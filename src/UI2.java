import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class UI2 extends JFrame implements MouseListener {
    private Random random = new Random();
    private Random randomR = new Random();
    private Random randomG = new Random();
    private Random randomB = new Random();
    ArrayList<CostomButton> buttons = new ArrayList<>();

    UI2() {
        setSize(800, 600);
        setLayout(null);

        setVisible(true);
        addMouseListener(this);

    }



    private void moveButton(CostomButton button) {
        int x = button.getX();
        int y = button.getY();
        int width = button.getWidth();
        int height = button.getHeight();

        int stepX = button.getStepX();
        int stepY = button.getStepY();

        while (true) {
            if (x < 10 || x > 785 - width) {
                stepX *= -1;
                button.setBackground(generateRandomColor());
            }

            if (y < 10 || y > 560 - height) {
                stepY *= -1;
                button.setBackground(generateRandomColor());
            }

            for (CostomButton otherButton : buttons) {
                button.getBounds().grow(20, 20);
                if (button != otherButton && button.getBounds().intersects(otherButton.getBounds())) {
                    int otherStepX = otherButton.getStepX();
                    int otherStepY = otherButton.getStepY();

                    stepX *= -1;
                    stepY *= -1;
                    button.setBackground(generateRandomColor());

                    otherButton.setStepX(otherStepX * -1);
                    otherButton.setStepY(otherStepY * -1);

                    break;
                }
            }

            x += stepX;
            y += stepY;

            button.setLocation(x, y);

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Color generateRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        buttons.add(new CostomButton(random.nextInt(9) - 4,random.nextInt(9) - 4));
        buttons.getLast().setBounds(e.getX(),e.getY(),50,50);
        add(buttons.getLast());
        Thread thread = new Thread(() ->

                moveButton(buttons.getLast()));
        thread.start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}