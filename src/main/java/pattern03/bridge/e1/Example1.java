package pattern03.bridge.e1;

import java.util.Scanner;

interface PhotoFile {
    void open(String fname);
    void save(String fname);
    void drawLine(int x1, int y1, int x2, int y2);
    void drawText(int x, int y, String text);
    void drawEllipse(int x1, int y1, int x2, int y2);
    int getPicWidth();
    int getPicHeight();
}

class JpegFile implements PhotoFile {
    @Override
    public void open(String fname) {
        System.out.printf("Jpeg Open(%s.jpg)\n", fname);
    }

    @Override
    public void save(String fname) {
        System.out.printf("Jpeg Save(%s.jpg)\n", fname);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        System.out.printf("Jpeg DrawLine(%d, %d, %d, %d)\n", x1, y1, x2, y2);
    }

    @Override
    public void drawText(int x, int y, String text) {
        System.out.printf("Jpeg DrawText(%d, %d, %s)\n", x, y, text);
    }

    @Override
    public void drawEllipse(int x1, int y1, int x2, int y2) {
        System.out.printf("Jpeg DrawEllipse(%d, %d, %d, %d)\n", x1, y1, x2, y2);
    }

    @Override
    public int getPicWidth() {
        return 100;
    }

    @Override
    public int getPicHeight() {
        return 150;
    }
};

class GifFile implements PhotoFile {
    @Override
    public void open(String fname) {
        System.out.printf("Gif Open(%s.gif)\n", fname);
    }

    @Override
    public void save(String fname) {
        System.out.printf("Gif Save(%s.gif)\n", fname);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        System.out.printf("Gif DrawLine(%d, %d, %d, %d)\n", x1, y1, x2, y2);
    }

    @Override
    public void drawText(int x, int y, String text) {
        System.out.printf("Gif DrawText(%d, %d, %s)\n", x, y, text);
    }

    @Override
    public void drawEllipse(int x1, int y1, int x2, int y2) {
        System.out.printf("Gif DrawEllipse(%d, %d, %d, %d)\n", x1, y1, x2, y2);
    }

    @Override
    public int getPicWidth() {
        return 200;
    }

    @Override
    public int getPicHeight() {
        return 250;
    }
};

class BmpFile implements PhotoFile {
    @Override
    public void open(String fname) {
        System.out.printf("Bmp Open(%s.bmp)\n", fname);
    }

    @Override
    public void save(String fname) {
        System.out.printf("Bmp Save(%s.bmp)\n", fname);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        System.out.printf("Bmp DrawLine(%d, %d, %d, %d)\n", x1, y1, x2, y2);
    }

    @Override
    public void drawText(int x, int y, String text) {
        System.out.printf("Bmp DrawText(%d, %d, %s)\n", x, y, text);
    }

    @Override
    public void drawEllipse(int x1, int y1, int x2, int y2) {
        System.out.printf("Bmp DrawEllipse(%d, %d, %d, %d)\n", x1, y1, x2, y2);
    }

    @Override
    public int getPicWidth() {
        return 300;
    }

    @Override
    public int getPicHeight() {
        return 350;
    }
};

////////

abstract class PhotoEffect {
    protected PhotoFile photoFile;

    public void setPhotoFile(PhotoFile p) {
        photoFile = p;
    }

    public void open(String fname) {
        photoFile.open(fname);
    }

    public void save(String fname) {
        photoFile.save(fname);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        photoFile.drawLine(x1, y1, x2, y2);
    }

    public void drawText(int x, int y, String text) {
        photoFile.drawText(x, y, text);
    }

    public void drawEllipse(int x1, int y1, int x2, int y2) {
        photoFile.drawEllipse(x1, y1, x2, y2);
    }

    public int getPicWidth() {
        return photoFile.getPicWidth();
    }

    public int getPicHeight() {
        return photoFile.getPicHeight();
    }

    public abstract void applyEffect(String fname);
};

class BorderEffect extends PhotoEffect {
    @Override
    public void applyEffect(String fname) {
        open(fname);
        int w = getPicWidth();
        int h = getPicHeight();
        drawLine(0, 0, w, 0);
        drawLine(w, 0, w, h);
        drawLine(w, h, 0, h);
        drawLine(0, h, 0, 0);
        save(fname);
    }
};

class BallonEffect extends PhotoEffect {
    String text;

    public BallonEffect(String s) {
        text = s;
    }

    @Override
    public void applyEffect(String fname) {
        open(fname);
        drawEllipse(100, 100, 300, 200);
        drawText(150, 140, text);
        save(fname);
    }
};

////////

public class Example1 {

    public static void main(String[] args) {
        PhotoFile imp;
        PhotoEffect effect = null;

        for (;;) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("\nPic 1)Jpeg  2)Gif  3)Bmp  0)Quit: ");
            switch (scanner.next().charAt(0)) {
            case '1':
                imp = new JpegFile();
                break;
            case '2':
                imp = new GifFile();
                break;
            case '3':
                imp = new BmpFile();
                break;
            default:
                return;
            }
            System.out.printf("Effect 1)Border  2)Ballon  0)Quit: ");
            switch (scanner.next().charAt(0)) {
            case '1':
                effect = new BorderEffect();
                break;
            case '2':
                effect = new BallonEffect("hello");
                break;
            }

            effect.setPhotoFile(imp);
            effect.applyEffect("picfile");

        }
    }
}
