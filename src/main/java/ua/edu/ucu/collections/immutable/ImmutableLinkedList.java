package ua.edu.ucu.collections.immutable;



public class ImmutableLinkedList implements ImmutableList {
    final Node head;
    private ImmutableLinkedList(){
        this.head = new Node(null);
    }
    ImmutableLinkedList(Node g){
        this.head = g;
    }
@Override
public ImmutableList add(Object e){
    ImmutableLinkedList a = this.clone();
    if (a.head.data == null){
        a.head.data = e;
    }
    else{
        Node first = a.head;
        while(first.next!= null){
            first = first.next;
        }
        first.next = new Node(e);
    }
return a;
}
    @Override
public int size(){
    int lenght = 1;
    if(this.head.data == null){
        lenght = 0;
    }
    else{
    for (Node first = this.head; first.next != null ; first = first.next){
        lenght++;
    }
    }
    return lenght;
}

    @Override

    public ImmutableList add(int index, Object e){
    ImmutableLinkedList a = this.clone();
    if(index >= a.size()){
        throw new IndexOutOfBoundsException();
    }
    if(index == 0){
        Node tmp1 = new Node(a.head.data);
        tmp1.next = a.head.next;
        a.head.data = e;
        a.head.next = tmp1;
        return a;
    }

    if(index == 1){
        Node tmp2 = new Node(a.head.next.data);
        tmp2.next = a.head.next.next;
        a.head.next.data = e;
        a.head.next.next = tmp2;
        return a;
    }
    int i = 0;
    Node first = a.head;
    while(first.next!= null){
        i++;
        first = first.next;
        if(i == index - 1){
            Node tmp = new Node(first.next.data);
            tmp.next = first.next.next;
            first.next.data = e;
            first.next.next = tmp;
    }
        }
    return a;
}
    @Override
public ImmutableList addAll(Object[] c){
    ImmutableLinkedList a = this.clone();
    for(Object i :c){
        Node first = a.head;
        while(first.next!= null){
            first = first.next;
        }
        first.next = new Node(i);
    }
    return a;

}
    @Override
public ImmutableList addAll(int index, Object[] c){
    ImmutableLinkedList a = this.clone();
    if(index >= a.size()){
        throw new IndexOutOfBoundsException();

    }
    int newIndex = index;
    for(Object j : c){
   Node tmpNew = new Node(j);
        if(newIndex == 0){

            Node tmp1 = new Node(a.head.data);
            tmp1.next = a.head.next;
            a.head.data = tmpNew.data;
            a.head.next = tmp1;
            newIndex++;

        }

        if(newIndex == 1){
            Node tmp2 = new Node(a.head.next.data);
            tmp2.next = a.head.next.next;
            a.head.next.data = tmpNew.data;
            a.head.next.next = tmp2;
        }
        newIndex++;
    int i = 0;
    Node first = a.head;
    while(i == newIndex - 1) {
        i++;
        first = first.next;
    }
            Node tmp = new Node(first.next.data);
            tmp.next = first.next.next;
        first.next = tmpNew;
            first.next.next = tmp;

        newIndex++;
    }



return a;
}
    @Override
public Object get(int index){
    if (index >= this.size()){
        throw new IndexOutOfBoundsException();
    }
    int i = 0;
    Node first = this.head;
     while( i < index){
         first = first.next;
         i++;
    }
    return first.data;
}
    @Override
public ImmutableList remove(int index){
    ImmutableLinkedList a = this.clone();
    if(index >= a.size()){
        throw new IndexOutOfBoundsException();
    }
    if(index == a.size() - 1){

        int k= 0;
        Node first = a.head;
        while(k != a.size() - 2){
            k++;
            first = first.next;

        }
        first.next = null;
        return a;
    }
    int i = 0;
    Node first = a.head;
    while (first.next != null) {

        if (i == index - 1) {
            Node tmp = new Node(first.next.next.data);
            tmp.next = first.next.next.next;

            first.next = tmp;
        }
        first = first.next;
        i++;
    }
    return a;
}
    @Override
public ImmutableList set(int index, Object e){
    ImmutableLinkedList a = this.clone();
    if(index >= a.size()){
        throw new IndexOutOfBoundsException();
    }
    int i = 0;
    Node first = a.head;
    while( i < index){
        first = first.next;
        i++;
    }
    first.data = e;
    return a;
}
    @Override
public int indexOf(Object e){
    ImmutableLinkedList a = this.clone();
    int i = 0;
    Node first = a.head;
    while (first.next != null){
        if(e == first.data){
            return i;}
        i++;
        first = first.next;


        }
    return -1;
}
    @Override
public ImmutableList clear(){
    return new ImmutableLinkedList();


}
    @Override
public  boolean isEmpty(){
    ImmutableLinkedList a = this.clone();
    Node first = a.head;
        if(first.data == null){
            if(first.next == null){

            return true;
        }}
    return false;
}

    @Override
public Object[] toArray(){
    Object[] a = new Object[this.size()];
    int i = 0;
    Node first = this.head;
    while(first.next != null){
        a[i] = first.data;
        first = first.next;
        i++;
    }
a[i] = first.data;
    return a;
}

    @Override
public String toString(){
    String s = "";
    Node first = this.head;
    s+=first.data;

    while(first.next != null){
        first = first.next;
        s += ", "  + first.data;
    }
    return s;
}

    @Override
public ImmutableLinkedList clone(){
    if (head.next == null){
        return new ImmutableLinkedList(new Node(this.head.data));
    }

    Node first = this.head;
        Node new_node = new Node(null);
        new_node.data = first.data;
        Node leva_node = new Node(null);
        new_node.next = leva_node;

        while(first.next!= null){
        first = first.next;
        leva_node.data = first.data;
            if(first.next != null){
                leva_node.next = new Node(null);
                leva_node = leva_node.next;
            }
    }
return new ImmutableLinkedList(new_node);

    }
public static void main(String[] args){
    ImmutableList b = new ImmutableLinkedList();
    ImmutableList a_1 = b.add(3);
    ImmutableList a_2 = a_1.add(4);
    ImmutableList a_3 = a_2.add(5);
 //   ImmutableList a_4 = a_3.add(7);
   // System.out.println(a_4);
//    ImmutableList a_5 = a_4.set(1, 8);
//    System.out.println(a_4.indexOf(8));
//    ImmutableList a_5 = a_4.remove(0);
//    System.out.println(a_5);
 //   System.out.println(a_3.get(0));
//    System.out.println(b.size());
//    ImmutableList a_4 = a_3.add(2, 7);
//    System.out.println(a_4);
    ImmutableList a_4 = a_3.addAll(0, new Object[]{8,10,9});
    System.out.println(a_4);
//    System.out.println(a_4);
//    System.out.println(a_5);
//    ImmutableList a_5 = a_4.set(0,null);
//    System.out.println(a_5);
//    System.out.println(a_5.isEmpty());
//    System.out.println(a_4.isEmpty());
//    System.out.println(b.isEmpty());
//    System.out.println(Arrays.toString(a_4.toArray()));

//    System.out.println(b.isEmpty());
//    System.out.println(a_1);
//    System.out.println(a_1.isEmpty());
    System.out.println(b.size());
    System.out.println(a_1.size());
}
}
