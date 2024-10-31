import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

public class Gallery
{
    public JFrame frame = new JFrame("My Gallery");
    private static int current=0;
    protected ArrayList<ImageIcon> gallery = new ArrayList<ImageIcon>();
    private JPanel buttons = new JPanel();
    private JPanel picture = new JPanel();
    private JPanel preview = new JPanel();
    private boolean flag=false;
    private float aFloat = 2 ;
    public Zoom zoom ;

    JButton previous = new JButton ("PREVIOUS");
    JButton next = new JButton ("NEXT");
    JButton play = new JButton ("PLAY");
    JButton stop = new JButton ("STOP");
    JButton zoomIn = new JButton("ZOOM IN");
    JButton zoomOut = new JButton("ZOOM OUT");
    JButton add = new JButton("Add Picture");
    JButton rotate = new JButton("Filipped Vertical");

    public void icon() throws Exception{
        Image image= ImageIO.read(new File("src\\gallery\\images\\Icon.jpg"));
        frame.setIconImage(image);
    }

    public void view() {
        picture.setBackground(Color.blue);
        buttons.setBackground(Color.blue);
        add.setBackground(Color.yellow);
        add.setVisible(true);

        ImageIcon first = new ImageIcon("D:\\JAVA\\Picture\\2014-05-18 21.19.22.png");
        JLabel label = new JLabel(first);
        gallery.add(first);
        picture.add(label);
        frame.add(picture, BorderLayout.CENTER);

        zoom = new Zoom(gallery.get(current));

        ImageIcon image1 = Zoom.minimize(first, 5);
        JButton preButton1 = new JButton(image1);
        preButton1.setBackground(Color.BLUE);
        preview.add(preButton1);
        preview.setBackground(Color.blue);
        frame.add(preview, BorderLayout.NORTH);
        preButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                picture.remove(0);
                picture.add(new JLabel(first));
                current = 0;
                picture.validate();
                picture.repaint();
                zoom = new Zoom(gallery.get(current));
            }
        });

        previous.setBackground(Color.magenta);
        next.setBackground(Color.magenta);
        play.setBackground(Color.GREEN);
        stop.setBackground(Color.pink);
        zoomIn.setBackground(Color.cyan);
        zoomOut.setBackground(Color.cyan);
        rotate.setBackground(Color.green);

        previous.setToolTipText("Go Back");
        next.setToolTipText("Go Next");
        play.setToolTipText("SlideShow");
        buttons.setBounds(0, 500, 600, 60);
        buttons.add(previous);
        buttons.add(play);
        buttons.add(stop);
        buttons.add(add);
        buttons.add(zoomIn);
        buttons.add(zoomOut);
        buttons.add(rotate);
        buttons.add(next);
        play.setVisible(true);
        previous.setVisible(true);
        next.setVisible(true);
        stop.setVisible(true);
        zoomIn.setVisible(true);
        zoomOut.setVisible(true);
        frame.add(buttons, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(preview);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0,0,800,20);
        scroll.setBackground(Color.blue);
        scroll.setVisible(true);
        frame.add(scroll, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(picture);
        scrollPane.setBackground(Color.blue);
        scrollPane.setVisible(true);
        frame.add(scrollPane, BorderLayout.CENTER);
//        frame.validate();
//        frame.repaint();
    }

    public void action() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:\\JAVA\\Picture"));
                FileNameExtensionFilter imageFiles = new FileNameExtensionFilter("Picture files", "jpg", "jpeg", "png");
                fileChooser.setFileFilter(imageFiles);
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    ImageIcon image = new ImageIcon(file.getPath());
                    gallery.add(image);
//                    System.out.println(gallery.size());
                    int photoNum = gallery.indexOf(image);
//                    System.out.println(photoNum);
                    setPreview(image,photoNum);
                    /*picture.remove(0);
                    picture.add(new JLabel(image));
                    preview.add(new JLabel(image));
                    preview.validate();
                    preview.repaint();*/
                } else if (returnVal == JFileChooser.CANCEL_OPTION) {
                    System.out.println("!!!!!!!!!");
                } else if (returnVal == JFileChooser.ERROR_OPTION) {
                    System.out.println("?????????????????");
                }
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNext();
                zoom = new Zoom(gallery.get(current));
            }
        });

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrevious();
                zoom = new Zoom(gallery.get(current));
            }
        });

        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag=true;
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=false;
                Timer time = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        if (flag){
                            time.cancel();
                            setPrevious();
                        }
                        setNext();
                        if (current==gallery.size()-1){
                            time.cancel();
                            JOptionPane.showMessageDialog(null, "End Of Pictures !", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                };
                time.schedule(task, 3000, 5000);
            }
        });

        zoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*ImageIcon first = gallery.get(current);
                ImageIcon resize = Zoom.zoomIn(first);*/
                zoom.zoomIn2();
                ImageIcon resize = zoom.first;
                picture.remove(0);
                picture.add(new JLabel(resize));
                picture.validate();
                picture.repaint();
            }
        });

        zoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*ImageIcon first = gallery.get(current);
                ImageIcon resized = Zoom.zoomOut(first);*/
                zoom.zoomOut2();
                ImageIcon resized = zoom.first ;
                picture.remove(0);
                picture.add(new JLabel(resized));
                picture.validate();
                picture.repaint();
            }
        });

        rotate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon curImage = gallery.get(current);
                Image theImage = curImage.getImage();
                JPanel rotated = null;
                if (aFloat == 2){
                    rotated = Rotate.rotatin(theImage);
                    aFloat = 1;
                }else if (aFloat==1){
                    rotated = Rotate.rotatin2(theImage);
                    aFloat=2;
                }
                picture.remove(0);
                picture.add(rotated);
                picture.validate();
                picture.repaint();
            }
        });
    }

    private void setNext(){
        if (current>=0 && current<(gallery.size()-1) ){
            picture.remove(0);
            current++;
            ImageIcon theImage = gallery.get(current);
            picture.add(new JLabel(theImage));
            picture.validate();
            picture.repaint();
        }else if (current==gallery.size()-1){
            JOptionPane.showMessageDialog(null, "End Of Pictures !", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        aFloat = 2;
    }

    private void setPrevious(){
        if (current<gallery.size() && current>0){
            picture.remove(0);
            current--;
            ImageIcon theImage = gallery.get(current);
            picture.add(new JLabel(theImage));
            picture.validate();
            picture.repaint();
        }else if (current==0){
            JOptionPane.showMessageDialog(null,"No Previous Picture !","Message",JOptionPane.INFORMATION_MESSAGE);
        }
        aFloat = 2;
    }

    private void setPreview(ImageIcon firstview,int index){
        ImageIcon view = Zoom.minimize(firstview, 5);
        JButton preButton = new JButton(view);
        preButton.setBackground(Color.BLUE);
        preview.add(preButton);
        preview.validate();
        preview.repaint();
        preButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                picture.remove(0);
//                picture.add(new JLabel(gallery.get(index)));
                picture.add(new JLabel(firstview));
                current = index;
                picture.validate();
                picture.repaint();
                aFloat = 2;
                zoom = new Zoom(gallery.get(current));
            }
        });
    }
}
