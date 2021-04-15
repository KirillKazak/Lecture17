package com.example.lecture17;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    int[] array = {5, 7, 6, 5, 5, 12, 5, 17, 5, 9};
    int num = 5;
    List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        array = deleteFromArray2(array, num);
        for (int i = 0; i < array.length; i++) {
            Log.d("TAG", String.valueOf(array[i]));
            list.add(array[i]);
        }
        list = deleteFromList(list);
        for (int i = 0; i < list.size(); i++) {
            Log.i("TAG2", String.valueOf(list.get(i)));
        }
    }

    public void deleteFromArray (int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                array[i] = 0;

                for (int j = i+1; j < array.length; j++) {
                    int number = array[j-1];
                    array[j-1] = array [j];
                    array[j] = number;
                }
            }
        }
    }

    public int[] deleteFromArray2 (int[] array, int num) {
        LinkedList <Integer> list = new LinkedList<>();
        for (int element : array) {
            list.add(element);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(num)) {
                iterator.remove();
            }
        }
        int[] finalArray = new int[list.size()];
        for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = list.get(i);
        }
        return finalArray;
    }

    public List <Integer> deleteFromList (List list) {
        TreeSet<Integer> newList = new TreeSet<>(list);
        return new ArrayList<>(newList);
    }
}