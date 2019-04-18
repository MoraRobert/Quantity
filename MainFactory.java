package com.Robert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MazeGame ordinaryGame = new OrdinaryMazeGame();
        MazeGame magicGame = new MagicMazeGame();
    }

    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("akármi"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("valami_más")));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
    }

    static abstract class Room {

    }

    static class MagicRoom extends Room {

    }

    static class OrdinaryRoom extends Room {

    }

    static abstract class MazeGame {
        private final List<Room> rooms = new ArrayList<>();

        public MazeGame() {
            Room room1 = makeRoom();
            Room room2 = makeRoom();
            //room1.connect(room2);
            rooms.add(room1);
            rooms.add(room2);
        }

        abstract protected Room makeRoom();
    }

    static class MagicMazeGame extends MazeGame {
        @Override
        protected Room makeRoom() {
            return new MagicRoom();
        }
    }

    static class OrdinaryMazeGame extends MazeGame {
        @Override
        protected Room makeRoom() {
            return new OrdinaryRoom();
        }
    }


}
