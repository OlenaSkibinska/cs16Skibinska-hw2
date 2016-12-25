package ua.edu.ucu.collections.immutable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ImmutableArrayList implements ImmutableList{
    Object[] aList;
    private ImmutableArrayList(){
        this.aList = new Object[1];
    }
    private ImmutableArrayList(int size){
        this.aList = new Object[size];
    }

@Override
public int size(){
    int lenght = 0;
    for(Object i : this.aList){
        lenght++;
    }
    return lenght;
}

    @Override
    public ImmutableList add(Object e){
        if(this.isEmpty()){
            ImmutableArrayList a = new ImmutableArrayList(1);
            a.aList[0] = e;
            return a;
    }
        ImmutableArrayList finalArray = new ImmutableArrayList(this.size() + 1);
        int counter = 0;
        for (int i = 0; i<this.size(); i++){
            counter++;
            finalArray.aList[i] = this.aList[i];
        }
        finalArray.aList[counter] = e;
        return finalArray;
    }

    @Override
    public boolean isEmpty(){
        for(Object i : this.aList){
            if(i == null){
                return true;

            }
        }
        return false;
    }
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < this.size() - 1; i++){
            s += this.aList[i] + ", ";
        }
        s += this.aList[this.size() - 1];
        return s;
    }
    @Override
    public ImmutableList add(int index, Object e){
        ImmutableArrayList finalArray = new ImmutableArrayList(this.size() + 1);
        int counter = 0;
        for (int i = 0; i<this.size(); i++){
            counter++;
            finalArray.aList[i] = this.aList[i];
        }
        if(index >= finalArray.size()){
            throw new IndexOutOfBoundsException();}
        for(int j = 0; j < index; j++){
            
        }

return null;
    }

    public static void main(String[] args){
        ImmutableList b = new ImmutableArrayList();
        ImmutableList a_1 = b.add(1);
        ImmutableList a_2 = a_1.add(2);
        ImmutableList a_3 = a_2.add(3);
        System.out.println(b);
        System.out.println(a_3);
        System.out.println(a_3.size());
        System.out.println(b.isEmpty());
        System.out.println(a_3.isEmpty());
     }
    
}
