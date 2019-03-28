package Lesson_1.Generics.Fruits;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeElm {

    static <T> void change(T[] array, int firstIndex, int secondIndex) {
        T oneVal = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = oneVal;
    }

    static <T> ArrayList<T> convertToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
