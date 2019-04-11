package Lesson_5.Homework;


import Lesson_5.Homework.Main;
import Lesson_5.Homework.Race;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }



    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");

            Main.START.countDown();
            Main.START.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (Main.FINISH.getCount() == Main.CARS_COUNT)
            System.out.println(name + " - Win");
        try {
            Main.FINISH.countDown();
            Main.FINISH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
