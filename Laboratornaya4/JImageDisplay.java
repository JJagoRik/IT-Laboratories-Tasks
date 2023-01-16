package Laboratornaya4;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

class JImageDisplay extends JComponent{
    /** Экземпляр класса BufferedImage **/
    private BufferedImage controlledImage;

    /** Установка размера изображения **/
    public JImageDisplay(int width, int height){
        controlledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
    }

    public BufferedImage getBufferedImage(){
        return controlledImage;
    }

    /** Переопределение метода вывода изображения **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage (controlledImage, 0, 0, controlledImage.getWidth(), controlledImage.getHeight(),
                null);
    }

    /** Метод для перекрашивания всего полотна в чёрный **/
    public void clearImage(){
        int[][] nums = new int[getWidth()][getHeight()];
        for (int i = 0; i < nums.length; i++){
            for(int j=0; j < nums[i].length; j++) {
                controlledImage.setRGB(i, j, 0);
            }
        }
        controlledImage.setRGB(getWidth(), getHeight(), 0);
    }

    /** Метод закрашивания пикселя **/
    public void drawPixel(int x, int y, int rgbColor){
        controlledImage.setRGB(x, y, rgbColor);
    }
}

