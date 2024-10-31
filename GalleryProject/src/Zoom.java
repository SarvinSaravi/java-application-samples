import java.awt.*;
import javax.swing.*;

public class Zoom
{
    public ImageIcon first = null;

    public Zoom(ImageIcon img){
        this.first = img;
    }

    public static ImageIcon zoomIn(ImageIcon image1){
        Image newImage = null;
        Image image = image1.getImage();
        int width = image.getWidth(null);
        int heigth = image.getHeight(null);
        System.out.println(width);
        System.out.println(heigth);
        try {
            newImage = image.getScaledInstance(width*2,heigth*2,Image.SCALE_SMOOTH);
        }catch (Exception e){
            e.printStackTrace();
        }
        ImageIcon myNew = new ImageIcon(newImage);
        return myNew;
    }

    public static ImageIcon zoomOut(ImageIcon image2){
        Image newImage = null;
        Image image = image2.getImage();
        int width = image.getWidth(null);
        int heigth = image.getHeight(null);
        try {
            newImage = image.getScaledInstance(width/2,heigth/2,Image.SCALE_SMOOTH);
        }catch (Exception e){
            e.printStackTrace();
        }
        ImageIcon myNew = new ImageIcon(newImage);
        return myNew;
    }

    public static ImageIcon minimize(ImageIcon image2,int n){
        Image newImage = null;
        Image image = image2.getImage();
        int width = image.getWidth(null);
        int heigth = image.getHeight(null);
        try {
            newImage = image.getScaledInstance(width/n,heigth/n,Image.SCALE_SMOOTH);
        }catch (Exception e){
            e.printStackTrace();
        }
        ImageIcon myNew = new ImageIcon(newImage);
        return myNew;
    }

    public void zoomOut2(){
        ImageIcon image2 = first;
        Image newImage = null;
        Image image = image2.getImage();
        int width = image.getWidth(null);
        int heigth = image.getHeight(null);
        try {
            newImage = image.getScaledInstance(width/2,heigth/2,Image.SCALE_SMOOTH);
        }catch (Exception e){
            e.printStackTrace();
        }
        ImageIcon myNew = new ImageIcon(newImage);
        this.first = myNew ;
    }

    public void  zoomIn2(){
        ImageIcon image1 = first;
        Image newImage = null;
        Image image = image1.getImage();
        int width = image.getWidth(null);
        int heigth = image.getHeight(null);
        try {
            newImage = image.getScaledInstance(width*2,heigth*2,Image.SCALE_SMOOTH);
        }catch (Exception e){
            e.printStackTrace();
        }
        ImageIcon myNew = new ImageIcon(newImage);
        this.first = myNew;
    }


}
