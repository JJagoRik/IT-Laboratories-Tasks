package Laboratornaya4;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FractalExplorer {

    private int size;
    private JImageDisplay jImageDisplay;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;

    public FractalExplorer(int size){
        this.size = size;
        fractalGenerator = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractalGenerator.getInitialRange(range);
        jImageDisplay = new JImageDisplay(size, size);
    }

    public void createAndShowGUI(){
        jImageDisplay.setLayout(new BorderLayout());
        JFrame jFrame = new JFrame("Fractal Explorer");
        jFrame.add(jImageDisplay, BorderLayout.CENTER);

        JButton resButton = new JButton("Reset");
        JButton saveButton = new JButton("Save Image");

        JComboBox jComboBox = new JComboBox();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JLabel jLabel = new JLabel("Fractal");
        northPanel.add(jLabel);
        northPanel.add(jComboBox);
        jFrame.add(northPanel, BorderLayout.NORTH);
        southPanel.add(resButton);
        southPanel.add(saveButton);


        jFrame.add(southPanel, BorderLayout.SOUTH);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);

        FractalGenerator mandelbrot = new Mandelbrot();
        FractalGenerator tricorn = new Tricorn();
        FractalGenerator burningShip = new BurningShip();
        jComboBox.addItem(mandelbrot);;
        jComboBox.addItem(tricorn);
        jComboBox.addItem(burningShip);

        ButtonHandler fractalChooser = new ButtonHandler();
        jComboBox.addActionListener(fractalChooser);
        saveButton.addActionListener(fractalChooser);
        resButton.addActionListener(fractalChooser);


        MouseMoves click = new MouseMoves();
        jImageDisplay.addMouseListener(click);
    }

    public void drawFractal(){
        for (int x = 0; x < jImageDisplay.getWidth(); x++){
            for (int y = 0; y < jImageDisplay.getHeight(); y++){
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, size, x);
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, size, y);
                int numIters = fractalGenerator.numIterations(xCoord, yCoord);
                if (numIters == -1){
                    jImageDisplay.drawPixel(x, y, 0);
                } else {
                    float hue = 0.7f + (float) numIters / 200f;
                    jImageDisplay.drawPixel(x, y, Color.HSBtoRGB(hue, 1f, 1f));
                }
            }
        }
        jImageDisplay.repaint();
    }


    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action.equals("Reset")) {
                fractalGenerator.getInitialRange(range);
                drawFractal();
            } else if (action.equals("comboBoxChanged")) {
                JComboBox source = (JComboBox) e.getSource();
                fractalGenerator = (FractalGenerator) source.getSelectedItem();
                fractalGenerator.getInitialRange(range);
                drawFractal();
            } else if (action.equals("Save Image")){
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                int result = chooser.showSaveDialog(jImageDisplay);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    BufferedImage image = jImageDisplay.getBufferedImage();
                    try {
                        ImageIO.write(image, "png", file);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(jImageDisplay,
                                ex.getMessage(), "Cannot Save Image",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    private class MouseMoves extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, size, x);
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, size, y);
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    public static void main(String[] args){
        FractalExplorer displaySize = new FractalExplorer(800);
        displaySize.createAndShowGUI();
        displaySize.drawFractal();
    }
}