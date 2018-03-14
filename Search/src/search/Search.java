
package search;

import java.util.HashMap;

/**
 * Class of operations on ordered lists of strings.
 * You should fill in the bodies of these methods.
 */
public class Search {
    
    /**
     * Returns the index of the longest string in the list.
     * If there are several string of this length, the 
     * indexed returned is the that of the first.
     * @param a list of strings, in ascending order
     * @return position of an entry with the longest string in the list
     */
    public int longestWord(StringList a) {
        
        int longest = 0;
 
        // replace the following line with your implementation
        for (int i = 0; i < a.size()-1; i++) {
        
            if (a.get(i).length() > a.get(longest).length()){
                longest = i;
            }
        
        }
        return longest;
    }
        //throw new UnsupportedOperationException("Not supported yet.");
    
    
    /**
     * Returns the number of unique elements in the list
     * @param a list of strings, in ascending order
     * @return number of unique elements in the list.
     */
    public int countUnique(StringList a) {
        // replace the following line with your implementation
        int uniqueCount = 1;
        
        for (int i = 0; i < a.size()-1; i++){
            if (a.get(i).equals(a.get(i+1))){
                
            } else {
                uniqueCount++;
            }
        }
        
        return uniqueCount;
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Returns the most commonly occurring string in the list.
     * If two or more are equally common, return the one that comes earliest.
     * @param a collection of strings, in ascending order
     * @return most frequently occurring string
     */
    public String mostFrequent(StringList a) {
        String mostFrequent = null;
        int frequency = 0;
        HashMap<String, Integer> hashMap;
        hashMap = new HashMap<String, Integer>();
        // replace the following line with your implementation
        for (int i = 0; i < a.size()-1; i++){
            if (hashMap.containsKey(a.get(i))){
                hashMap.put(a.get(i), hashMap.get(a.get(i)) + 1);
            } else {
                hashMap.put(a.get(i), 1);
            }
        }
        for (int i = 0; i < a.size()-1; i++){
            if (hashMap.get(a.get(i)) > frequency){
                frequency = hashMap.get(a.get(i));
                mostFrequent = a.get(i);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet.");
        return mostFrequent;
    }  

    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return position of an element equal to k, if any, otherwise -1
     */
    public int findElement(StringList a, String k) {
        
        int lo = 0;
        int hi = a.size()-1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(a.get(mid).equals(k)){
                return mid;
            }
            if(a.get(mid).compareTo(k) < 0) {
                lo = mid+1;
            } else {
                hi = mid - 1;
            }
            
        }
        return -1;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Position of a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return number of strings in the collection a greater than or equal to k
     */
    public int countGreaterOrEqual(StringList a, String k) {
        
        int lo = 0;
        int hi = a.size()-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if (a.get(mid).compareTo(k) < 0){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }  
        }
        return a.size() - lo;
        
//        int position = 0;
//        int count = 0;
//        for (int i = 0; i < a.size(); i++){
//            if(a.get(i).compareTo(k) >= 0){
//                count++;
//            }
//        }
//        return count;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Position after a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return number of strings in the collection strictly greater than k
     */
    public int countGreater(StringList a, String k) {
        int lo = 0;
        int hi = a.size()-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if (a.get(mid).compareTo(k) <= 0){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }  
        }
        return a.size() - lo;
        // replace the following line with your implementation
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Determine the size of a range in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k1 first string to search for
     * @param k2 second string to search for (greater than or equal to k1)
     * @return number of strings between k1 and k2 (inclusive)
     */
    public int countBetween(StringList a, String k1, String k2) {
        // replace the following line with your implementation
        int lo1 = 0;
        int hi1 = a.size()-1;
        int lo2 = 0;
        int hi2 = a.size()-1;
        int pos1 = 0;
        int pos2 = 0;
        while(lo1 <= hi1){
            int mid = (lo1 + hi1) / 2;
            if(a.get(mid).equals(k1)){
                pos1 = mid;
                break;
            }
            if(a.get(mid).compareTo(k1) < 0) {
                lo1 = mid+1;
            } else {
                hi1 = mid - 1;
            }  
        }
        while(lo2 <= hi2){
            int mid = (lo2 + hi2) /2;
            if(a.get(mid).equals(k2)){
                pos2 = mid;
                break;
            }
            if (a.get(mid).compareTo(k2) < 0){
                lo2 = mid + 1;
            } else {
                hi2 = mid - 1;
            }
        }
        
        return Math.abs(pos1 - pos2) + 1;
        
       
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Count partial matches in an ordered collection
     * @param a collection of strings, in ascending order
     * @param prefix first string to search for
     * @param substring second string to search for
     * @return number of strings with both the prefix and the substring
     */
    public int countMatches(StringList a, String prefix, String substring) {
        // replace the following line with your implementation
        int count = 0;
        for (int i = 0; i < a.size(); i++){
            if(a.get(i).startsWith(prefix)){
                if(a.get(i).contains(substring)){
                    count++;
                }
            }
        }
        return count;
        //throw new UnsupportedOperationException("Not supported yet.");
    }    
     
}