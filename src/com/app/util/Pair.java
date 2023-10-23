package com.app.util;

public class Pair {
        public int ceil;
        public int floor;

        public Pair() {
        }

        public Pair(int ceil, int floor) {
            this.ceil = ceil;
            this.floor = floor;
        }

        public int getCeil() {
            return ceil;
        }

        public void setCeil(int ceil) {
            this.ceil = ceil;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }
    }
