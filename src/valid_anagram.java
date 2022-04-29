import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class valid_anagram {

    // This is just extra code that I used to enforce myself to work with all Java features
    private String s1;
    private String s2;

    public valid_anagram(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public valid_anagram(){
    }

    public String getS1() {
        return s1;
    }
    public void setS1(String s1) {
        this.s1 = s1;
    }
    public String getS2() {
        return s2;
    }
    public void setS2(String s2) {
        this.s2 = s2;
    }

    public static void main(String [] args) {
        System.out.println("Done checking project");
        valid_anagram myValidAnagram = new valid_anagram();
        myValidAnagram.receiveStrings();
        myValidAnagram.processStrings();
    }

    public void receiveStrings(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please insert the first string");
        String s1 = in.nextLine();
        System.out.println("Received String: "+ s1);
        this.setS1(s1);
        System.out.println("Please insert the second string");
        String s2 = in.nextLine();
        System.out.println("Received String: "+ s2);
        this.setS2(s2);
    }

    public void processStrings(){
        if ((this.s1== null) || (this.s2==null)){
            System.out.println("No Strings given");
            return;
        }

        if (this.s1.length()!=this.s2.length()){
            System.out.println("FALSE");
            return;
        }

        // Get the char array version of each string
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        // **** **** **** **** SOLUTION 1 **** **** **** **** **** **** ****
        //
        // Order both character arrays, and compare them
        //
        // The Arrays.sort uses a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch
        // Which has a complexity of O(n log(n))
        // https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#sort-char:A-

        Arrays.sort(ch1);
        Arrays.sort(ch2);
        System.out.println(this.s1 + " --> " +new String(ch1));
        System.out.println(this.s2 + " --> " +new String(ch2));

        // Using Arrays.equals(ch1,ch2)
        // https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#equals-char:A-char:A-

        boolean result1 = Arrays.equals(ch1,ch2);
        System.out.println("Method 1: Are they anagrams? " +result1);

        // **** **** **** **** SOLUTION 2 **** **** **** **** **** **** ****
        //
        // Use HashMaps: The time complexity is O(n) since we'll only need to traverse the arrays
        //
        HashMap<Character, Integer> myHash1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> myHash2 = new HashMap<Character, Integer>();
        for (int i =0; i<ch1.length;i++){
            char myChar1=ch1[i];
            if(myHash1.get(myChar1)== null){
                myHash1.put(myChar1,1);
            } else{
                myHash1.put(myChar1,myHash1.get(myChar1)+1);
            }
            char myChar=ch2[i];
            if(myHash2.get(myChar)== null){
                myHash2.put(myChar,1);
            } else{
                myHash2.put(myChar,myHash2.get(myChar)+1);
            }
        }

        boolean result2 = myHash1.equals(myHash2);
        System.out.println("Method 2: Are they anagrams? " +result2);

        //
    }
}
