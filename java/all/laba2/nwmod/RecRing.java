package all.laba2.nwmod;
import all.laba2.primitives.Rectangle;

import java.awt.*;

public class RecRing {
        private Rectangle inrec;
        private Rectangle outrec;

        private int thickness;

        public RecRing(int centerX, int centerY, int width, int high, int thickness, Color color) {
            Point center = new Point(centerX, centerY);
            this.outrec = new Rectangle(centerX, centerY, width, high, color);
            this.inrec = new Rectangle(centerX, centerY, this.outrec.getWidth() - thickness, this.outrec.getHigh() - thickness, Color.WHITE);
            this.thickness = thickness;

            System.out.println("RecRing created at " + center);
        }

        public RecRing(int centerX, int centerY, int width, int high, int thickness) {
            Point center = new Point(centerX, centerY);
            this.outrec = new Rectangle(centerX, centerY, width, high, Color.BLACK);
            this.inrec = new Rectangle(centerX, centerY, this.outrec.getWidth() - thickness, this.outrec.getHigh() - thickness, Color.WHITE);
            this.thickness = thickness;

            System.out.println("RecRing created at " + center);
        }


        public void moveTo(int diffX, int diffY){
            this.outrec.moveTo(diffX, diffY);
            this.inrec.moveTo(diffX, diffY);

            System.out.println("RecRing moved at " + this.outrec);
        }

        public void changeForm(int newWidth, int newHeight){
            this.outrec.changeForm(newWidth, newHeight);
            this.inrec.changeForm(newWidth - thickness, newHeight - thickness);

            System.out.println("RecRing changed at " + this.outrec);
        }

        public void erase(){
            this.outrec.erase();
            this.inrec.erase();

            System.out.println("RecRing erased at " + this.outrec);
        }

        public void show(Graphics graphics){
            this.outrec.show(graphics);
            this.inrec.show(graphics);
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            this.inrec = null;
            this.outrec = null;
            System.out.println("RecRing finalized at " + this.outrec);
        }
    }
