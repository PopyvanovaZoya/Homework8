package ru.geekbrains.Homework8;

public class Sample01 {
    public static void main(String[] args) {

        Participant[] participants = new Participant[3];
        Obstacle[] obstacles = new Obstacle[5];
        participants[0] = new Human("Ян", 10, 20);
        participants[1] = new Cat("Котангенс", 30, 30);
        participants[2] = new Robot("Зоя", 5, 10);
        obstacles[0] = new Wall(15);
        obstacles[1] = new Treadmill(10);
        obstacles[2] = new Treadmill(5);
        obstacles[3] = new Treadmill(30);
        obstacles[4] = new Wall(20);

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (participants[i].goThrough(obstacles[j])){
                    System.out.println(participants[i].GetName()+ " преодолел препятствие");
                }
                else {
                    System.out.println(participants[i].GetName()+ " не преодолел препятствие");
                    break;
                }
            }
        }
    }
}

    interface Participant {
        String GetName();
        int GetJumpAbility();
        int GetRunAbility();
        boolean goThrough(Obstacle obstacle);
    }

    class Human implements Participant {
        public Human(String name, int jumpAbility, int runAbility) {
            this.name = name;
            this.jumpAbility = jumpAbility;
            this.runAbility = runAbility;
        }

        private String name;
        private int jumpAbility;
        private int runAbility ;

        @Override
        public String GetName() {
            return name;
        }

        @Override
        public int GetJumpAbility() {
            return jumpAbility;
        }

        @Override
        public int GetRunAbility() {
            return runAbility;
        }

        @Override
        public boolean goThrough(Obstacle obstacle) {
            return obstacle.CompareDifficulty(this);

        }
    }

    class Cat implements Participant {
        public Cat(String name, int jumpAbility, int runAbility) {
            this.name = name;
            this.jumpAbility = jumpAbility;
            this.runAbility = runAbility;
        }

        private String name;
        private int jumpAbility;
        private int runAbility ;


        @Override
        public String GetName() {
            return name;
        }

        @Override
        public int GetJumpAbility() {
            return jumpAbility;
        }

        @Override
        public int GetRunAbility() {
            return runAbility;
        }

        @Override
        public boolean goThrough(Obstacle obstacle) {
            return obstacle.CompareDifficulty(this);
            }
        }

    class Robot implements Participant {
        public Robot(String name, int jumpAbility, int runAbility) {
            this.name = name;
            this.jumpAbility = jumpAbility;
            this.runAbility = runAbility;
        }

        private String name;
        private int jumpAbility;
        private int runAbility ;

        @Override
        public String GetName() {
            return name;
        }

        @Override
        public int GetJumpAbility() {
            return jumpAbility;
        }

        @Override
        public int GetRunAbility() {
            return runAbility;
        }

        @Override
        public boolean goThrough(Obstacle obstacle) {
            return obstacle.CompareDifficulty(this);
        }

    }

    interface Obstacle {
        public boolean CompareDifficulty (Participant participant);

    }

    class Treadmill implements Obstacle {
        public int length;

        public Treadmill(int length) {
            this.length = length;
        }

        @Override
        public boolean CompareDifficulty(Participant participant) {
            return participant.GetRunAbility() >= length;
        }
    }

    class Wall implements Obstacle {
        public int height;

        public Wall(int height) {
            this.height = height;
        }

        @Override
        public boolean CompareDifficulty(Participant participant) {
            return participant.GetJumpAbility() >= height;
        }
    }

