package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;

public class Anagram extends abstractAlgo {
    public static int NUMBER_LETTER = 26;

    @Override
    public void setUpDefault() {

    }

    @Override
    public void run() {

    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }

    /**
     * Return the number of characters we need to remove to make anagram from 2 strings given
     * @param s1
     * @param s2
     * @return
     */
    public int makeAnagram(String s1, String s2) {
        int[] charCount1 = getCharCount(s1);
        int[] charCount2 = getCharCount(s2);
        return getDelta(charCount1, charCount2);
    }

    /**
     *  get the number of different characters between 2 arrays of characters
     * @param charCount1
     * @param charCount2
     * @return
     */
    private int getDelta(int[] charCount1, int[] charCount2) {
        int sum=0;
        for (int i = 0; i < charCount1.length; i++) {
            sum += Math.abs(charCount1[i] - charCount2[i]);
        }
        return sum;
    }

    /**
     *  Count the number of characters in a string
     * @param s1
     * @return
     */
    private int[] getCharCount(String s1) {
        int[] result = new int[NUMBER_LETTER];
        for (int i = 0; i < s1.length(); i++) {
            char c= s1.charAt(i);
            int offset = c - 'a';
            result[offset]++;

        }
        return result;

    }


}
