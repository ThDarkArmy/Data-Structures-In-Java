import java.util.*;
import java.lang.*;
import java.io.*;

/*Heap Class*/
class Heap<T extends Comparable<T>>{
  private ArrayList<T> list;
  Heap(){
    list=new ArrayList<T>();
  }

/*siftUp Operation*/
  public void siftUp(){
    int k=list.size()-1;
    while(k>0){
      int p=(k-1)/2;
      T child = list.get(k);
      T parent = list.get(p);
      if(child.compareTo(parent)>0){
        list.set(k, parent);
        list.set(p,child);
        k=p;
      }else{
        break;
      }
    }
  }

/*siftDown Operation*/
  public void siftDown(){
    int k=0;
    int l=1;
    while(l<list.size()){
      int max=l;
      int r=l+1;
      if(r< list.size() && list.get(r).compareTo(list.get(l))>0){
        max++;
      }

      if(list.get(max).compareTo(list.get(k))>0){
        T temp=list.get(k);
        list.set(k, list.get(max));
        list.set(max,temp);
        k=max;
        l=2*k+1;
      }else{
        break;
      }
    }
  }

/*Insert Operation*/
  public void insert(T element){
    list.add(element);
    siftUp();
  }

/*Delete Operation*/
  public T delete(){
    if(list.size()==0){
      throw new NoSuchElementException();
    }else if(list.size()==1){
      T tmp  = list.get(0);
      list.remove(0);
      return tmp;
    }
      T temp=list.get(0);
      list.set(0,list.remove(list.size()-1));
      siftDown();
      return temp;
  }

/*Check for Empty*/
  public boolean isEmpty(){
    return list.size()>0;
  }

/*Checking for size*/
  public int size(){
    return list.size();
  }

/*To String Method*/
  public String toString(){
    return list.toString();
  }
}

/* Main or Driver Class*/
class HeapMain{
  public static void main(String[] args){
    Heap <Integer> heap = new Heap<Integer>();
    Scanner scan = new Scanner(System.in);
    PrintStream ps = new PrintStream(System.out);
    while(true){
      ps.println("Enter the operations!\n 1. Insert \n 2. Display \n 3. Delete \n 4. Size \n 5. CheckForEmpty \n 6.Exit");
      int T=scan.nextInt();
      switch(T){
        case 1: ps.println("Enter the no. of elements you want to insert in the heap!");
                int n = scan.nextInt();
                while(n-->0){
                  heap.insert(scan.nextInt());
                }
                break;
        case 2: ps.println(heap.toString());
                break;
        case 3: heap.delete();
                break;
        case 4: ps.println("Size of the heap is "+ heap.size());
                break;
        case 5: if(!heap.isEmpty()){
                  ps.println("Heap is Empty!");
                }else{
                  ps.println("Heap is not Empty!");
                }
                break;
        case 6: System.exit(0);
        default: ps.println("Enter the valid options!");
      }
    }
  }
}
