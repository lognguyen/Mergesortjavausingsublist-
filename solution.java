import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*; 

public class solution{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        input.nextLine();
        int count =0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i= 0; i<a;i++){
            list.add(i, input.nextInt());
        }
        list = mergesort(list);
        System.out.println(list.toString());
        int index = 0;
        int tmp =b-1;
        while (index<list.size() && index>-1){
            if (index+tmp>list.size()-1){
                tmp = list.size()-1-index;
            }
            if((list.get(index).intValue() + c > list.get(index+tmp).intValue()-1)){
                count++;
                index = index + tmp+1;
                tmp = b-1;
            } else {
                tmp--;
            }
        }
        System.out.println(count);
        input.close();
    
    }
        
    
    public static List<Integer> mergesort(List<Integer> s){
        if (s.size() < 2){
            return s;
        }
        List<Integer> s1 = new ArrayList<Integer>();
        s1 = s.subList(0, s.size()/2);
        List<Integer> s2 = new ArrayList<Integer>();
        s2 = s.subList((s.size()/2)+1,s.size());
        s1 = mergesort(s1);
        s2 = mergesort(s2);
        merge(s, s1, s2);
        return s;

        
    }
    public static void merge(List<Integer> s,List<Integer> s1,List<Integer> s2){
        int i =1;
        int j =1;
        while (i<s1.size() && j<s2.size()){
            if (s1.get(i).intValue() <= s2.get(j).intValue()){
                s.set(i+j-1,s1.get(i));
                i++;
            } else {
                s.set(i+j-1,s2.get(j));
                j++;
            }
        }
        while (i<s1.size()){
            s.set(i+j-1,s1.get(i));
            i++;
        }
        while (j<s2.size()){
            s.set(i+j-1,s2.get(j));
            j++;
        }
    }
}