//HackerRank Java Contact app. My way to make trie imlementation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HackerRankTries_Contacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ContactApp ob = new ContactApp();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) ob.add(contact);
            else System.out.println(ob.find(contact));
        }
    }
}

class ContactApp {
    List<Contact> contacts = new ArrayList<>();
    
    void add(String name) {
        int pos = Collections.binarySearch(contacts,name);
        if (pos<0) contacts.add(-(pos+1),new Contact(name));
    }
    
    int find(String name) {
        int count = 0;
        int pos = Collections.binarySearch(contacts,name);
        if (pos < 0) pos = -(pos+1);
        if (pos >= contacts.size()) return count;
        for (Contact c: contacts.subList(pos,contacts.size())){
            if (c.getName().startsWith(name)) count++;
            else return count;
        }
        return count;
    }
}

class Contact implements Comparable<String> {
    private String name;
    
    Contact(String s){
        this.setName(s);
    }
    public String getName() {
        return this.name;
    }
    public void setName(String s) {
        name = s;
    }
    
    public int compareTo(String s){
        return name.compareTo(s);
    }
}