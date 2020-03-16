public class Main {

    /*
    Question:
    Determine whether a one-to-one character mapping exists from one string, s1, to another string,
    s2.
    For example, given ​ s1 = abc ​ and ​ s2 = bcd , ​ print "​ true" into stdout ​ since we can map each
    character in "abc" to a character in "bcd".
    Given ​ s1 = foo ​ and ​ s2 = bar ​ , print "​ false" ​ since the character ‘o’ cannot map to two characters.
    But given ​ s1 = bar
     */
    public static void main(String[] args){

        String s1 = args[0];
        String s2 = args[1];

        System.out.println(isOneToOne(s1,s2));


    }


    /*
    one-to-one character mapping exists if a character in s1 is assigned to exactly 1 character in s2
    */

    public static boolean isOneToOne(String s1, String s2){
        //remove the repeated characters from the string to get its actual size
        //since each letter can be mapped a single time, repeated characters can be ignored.
        int s1_size = s1.length() - numOfRepeatedLetters(s1);
        int s2_size = s2.length() - numOfRepeatedLetters(s2);

        // if the size of s1 is smaller than the size of s2 then it is on one to one
        //because there will be characters in s1 that is going to be assigned to
        // multiple characters in s2

        if(s1_size < s2_size){
            return false;
        }

        return true;
    }
    public static int numOfRepeatedLetters(String sx) {
        //convert it to a char array to make it easier to compare the characters in the string
        char word[] = sx.toCharArray();
        //counter to track how many repeated letters there are
        int counter = 0;
        for (int i = 0; i < word.length; i++) {
            for (int j = i + 1; j < word.length; j++) {
                if (word[i] == word[j] && word[j] != '~') {
                    counter++;
                    //Set word[j] to ~ to avoid visited characters
                    word[j] = '~';
                }
            }
        }
        return counter;
    }


}
