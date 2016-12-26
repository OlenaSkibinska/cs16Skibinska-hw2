package ua.edu.ucu.collections.immutable;



public class ImmutableArrayList implements ImmutableList{
    Object[] aList;
    ImmutableArrayList(){
        this.aList = new Object[1];
    }
    private ImmutableArrayList(int size){
        this.aList = new Object[size];
    }
    ImmutableArrayList(Object[] data){
        this.aList = data;
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
        finalArray.aList[index] = e;
        for(int j = index + 1; j < finalArray.size(); j++){
            finalArray.aList[j] = this.aList[j - 1];
            
        }

return finalArray;
    }

    @Override
    public ImmutableList addAll(Object[] c){
        ImmutableArrayList finalArray = new ImmutableArrayList(this.size() + c.length);
        int counter = 0;
        for (int i = 0; i<this.size(); i++){
            counter++;
            finalArray.aList[i] = this.aList[i];
        }
        int count = 0;
        for (int j = this.size(); j < finalArray.size(); j++) {
            finalArray.aList[j] = c[count];
            count++;
        }
        return finalArray;

    }

    @Override
    public ImmutableList addAll(int index, Object[] c){
        ImmutableArrayList finalArray = new ImmutableArrayList(this.size() + c.length);
        int counter = 0;
        for (int i = 0; i<this.size(); i++){
            counter++;
            finalArray.aList[i] = this.aList[i];
        }
        if(index >= finalArray.size()){
            throw new IndexOutOfBoundsException();
        }
        int count  = 0;
        for (int ind = index; ind < index + c.length; ind++) {
            finalArray.aList[ind] = c[count];
            count++;
        }
        for (int ind = index + c.length; ind < this.size() + c.length; ind++) {
            finalArray.aList[ind] = this.aList[index];
            index++;
        }
        return finalArray;



    }
    @Override
    public Object get(int index) {
        return this.aList[index];
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableArrayList finalArray = new ImmutableArrayList(this.size());
        int counter = 0;
        for (int i = 0; i<this.size(); i++){
            counter++;
            finalArray.aList[i] = this.aList[i];
        }
        finalArray.aList[index] = e;
        for (int j = index + 1; j < finalArray.size(); j++) {
            finalArray.aList[j] = this.aList[j];
        }
        return finalArray;
    }
    @Override
    public ImmutableList remove(int index) {
        ImmutableArrayList finalArray = new ImmutableArrayList(this.size() - 1);
        for (int i = 0; i < index; i++) {
            finalArray.aList[i] = this.aList[i];
        }
        for (int j = index + 1; j < this.size() ; j++) {
            finalArray.aList[j - 1] = this.aList[j];
        }
        return finalArray;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++){
            if (this.aList[i] == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ImmutableList clear() {

        return new ImmutableArrayList(new Object[]{null});
    }

    @Override
    public Object[] toArray() {
        Object[] finalArray = new Object[this.size()];
        for (int i = 0; i < this.size(); i ++) {
            finalArray[i] = this.aList[i];
        }

        return finalArray;
    }
    public static void main(String[] args){
        ImmutableList b = new ImmutableArrayList();
        ImmutableList a_1 = b.add(1);
        ImmutableList a_2 = a_1.add(2);
        ImmutableList a_3 = a_2.add(3);
        ImmutableList a_4 = a_2.addAll(new Object[]{5, 6, 7, 8});
        ImmutableList a_5 = a_3.addAll(1, new Object[]{5, 6});
        System.out.println(b);
        System.out.println(a_3);
        System.out.println(a_3.size());
        System.out.println(b.isEmpty());
        System.out.println(a_3.isEmpty());
        System.out.println(a_3.add(0,45));
        System.out.println(a_4);
        System.out.println(a_5);
        System.out.println(a_5.remove(0));
     }
    
}
