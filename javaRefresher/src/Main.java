import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.plugin.dom.css.Counter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        System.out.println(reverseString("hello World!"));
    }



    public static List<Integer> kLargestNumber(int[] arr, int k){
        TreeSet<Integer> sorted = new TreeSet<>();
        for(int num : arr){
            sorted.add(num);
            if (sorted.size() > k){
                sorted.pollFirst();
            }
        }
        return sorted.stream().collect(Collectors.toList());
    }

    public static String reverseString(String s) {
        char[] sArr = s.toCharArray();
        int end = sArr.length;
        int middle = (int) Math.ceil(end/2);
        for(int i = 0; i < middle; i++){
            if (end-1 > i){
                char temp = sArr[end-1-i];
                sArr[end-1-i] = sArr[i];
                sArr[i] = temp;
            }
        }
        return String.valueOf(sArr);
    }

    public static boolean twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static int findDuplicate(String input) {
        char[] cs = input.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for(int i = 0; i<cs.length; i++){
            int count =  counter.getOrDefault(cs[i], 0);
            if (count > 0 ){
                return i;
            }
            counter.put(cs[i], count+1);

        }
//        for(int i = 0; i <cs.length; i++){
//            for(int j  = 0; j < cs.length; j++){
//                if(i!=j){
//                    if (cs[i] == cs[j]){
//                        return j;
//                    }
//                }
//            }
//        }
        return -1;
    }

    public static Map<String, Integer> count(String[] words){
        Map<String, Integer> counter = new HashMap<>();
        for(String word : words){
            int count = counter.getOrDefault(word, 0);
            counter.put(word, count+1);
        }
        return counter;
    }

    public static int calculate(String s) {
        //System.out.println(Arrays.toString("11*5+20-11/6".split("[+*-//]+")));
        //System.out.println(Arrays.toString("11*5+20-11/6".split("[0-9]+")));

        String highestPrecedent = "*";
        String lowestPrecedent = "+-";
        Stack<String> data = new Stack<>();
        String[] splited = s.split("");
        for(int i = 0; i <splited.length;i++){
            String num = splited[i];
            if (highestPrecedent.contains(num)){
                String previous = data.pop();
                String next = splited[i+1];
                int result = 0;
                if(num.equals("*")){
                    result = Integer.valueOf(previous) * Integer.valueOf(next);
                }
                data.push(String.valueOf(result));
                i++;
            }else{
                data.push(num);
            }
        }

        String previous = "";

        for(int i = 0; i<data.size(); i++){
            String temp = data.pop();
            if (lowestPrecedent.contains(temp)){
                String next = data.pop();
                int result = 0;
                if(temp.equals("+")){
                     result = Integer.valueOf(previous) + Integer.valueOf(next);
                }else if(temp.equals("-")){
                    result = Integer.valueOf(previous) - Integer.valueOf(next);
                }
                data.push(String.valueOf(result));
            }else{
                previous = temp;
            }
        }



        return Integer.valueOf(data.pop());
    }

    public static List<String>[] groupString(List<String> input) {
        List<String>[] types = new List[3];
        for(int i =0; i < types.length; i++){
            types[i] = new ArrayList<>();
        }

        for(String word : input){

            char firstChar = word.charAt(0);
            if (firstChar == 'a'){

                types[0].add(word);

            }else if (firstChar == 'b'){

                types[1].add(word);

            }else{
                types[2].add(word);
            }

        }

        return types;
    }


    public static String vowelOnly(String input) {
        String vowels = "AEIOU";
        String inputVowels = "";
        for(char c : input.toCharArray()){
            if(vowels.contains(String.valueOf(Character.toUpperCase(c)))){
                inputVowels+=String.valueOf(c);
            }
        }
        return inputVowels;
    }

}
