package cn.wjs;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 4};
        List<Integer> list = Arrays.asList(arr);
        //返回值叠加到 identity
        Integer aBoolean = list.stream().reduce(1, (one, two) -> {
            System.out.println(one);
            System.out.println(two);
            return one + two;
        });
        System.out.println("final -> " + aBoolean);
        List<A> orginal = new ArrayList<>();
        A a = new A();
        a.setName("aaa");
        orginal.add(a);
        List aaa = filterUsingPredicate(orginal, aaa(a));
        System.out.println(aaa.size());

    }
    public static List<Predicate<A>> aaa(A a) {
        List<Predicate<A>> list = new ArrayList<>();
        Predicate<A> rule = ele -> Objects.equals(ele.getName(),  a.getName());
        Predicate<A> rule2 = ele -> Objects.equals(ele.getName(),  a.getName());
        list.add(rule);
        list.add(rule2);
        return list;
    }
    public static <I> List<I> filterUsingPredicate(Collection<I> persons, List<Predicate<I>> mappers) {
        System.out.println("===: " + persons.size() +" :aaa: "+ mappers.size());
        return persons.stream()
                .filter(ele -> mappers.stream().reduce(t -> true, Predicate::and).test(ele))
                .collect(Collectors.toList());
    }

}



class A {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
