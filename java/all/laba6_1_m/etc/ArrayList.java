package all.laba6_1_m.etc;

import all.laba6_1_m.primitives.TFigure;

import java.util.Arrays;

public class ArrayList {

        private TFigure[] elements;
        private int size = 10;
        private double ratio = 1.5;
        private int pointer = 0;

        public ArrayList() {
            elements = new TFigure[size];
        }

        public void add(TFigure figure) {
            if(size <= pointer){
                int newSize = (int) (size * ratio);
                TFigure[] temp = Arrays.copyOf(elements, newSize);
                this.size = newSize;
                this.elements = Arrays.copyOf(temp, newSize);
            }
            elements[pointer] = figure;
            pointer++;
        }

        public void forEach(Process processClass) { //итератор
            for (int i = 0; i < pointer; i++) {
                processClass.process(elements[i]);
            }
        }

        public int size() {
            return pointer;
        }
    }
