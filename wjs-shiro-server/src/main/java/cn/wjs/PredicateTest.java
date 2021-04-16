package cn.wjs;

import java.util.ArrayList;
import java.util.List;

public class PredicateTest {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<Apple>();

        Apple redApple = new Apple();
        redApple.setColor("red");
        redApple.setWeight(180);
        appleList.add(redApple);

        Apple greenApple = new Apple();
        greenApple.setColor("green");
        greenApple.setWeight(120);
        appleList.add(greenApple);

        List<Apple> greenAppleSet = AppleFilter(appleList, Apple::isGreenApple);
        List<Apple> heavyAppleSet = AppleFilter(appleList, Apple::isHeavyApple);

        System.out.println("=======绿苹果=======");
        for (Apple apple : greenAppleSet) {
            System.out.println(apple.getColor());
        }

        System.out.println("=======大苹果=======");
        for (Apple apple : heavyAppleSet) {
            System.out.println(apple.getWeight());
        }

    }

    static List<Apple> AppleFilter(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> resultApples = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                resultApples.add(apple);
            }
        }
        return resultApples;
    }
}

class Apple {
    private String color;
    private Integer weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

interface Predicate<T> {
    boolean test(T t);
}
