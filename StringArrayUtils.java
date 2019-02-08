import java.util.ArrayList;
/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return (array.length > 0) ? array[0] : "";
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return (array.length > 1) ? array[1] : "";
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return (array.length > 0) ? array[array.length - 1] : "";
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return (array.length > 1) ? array[array.length - 2] : "";
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean found = false;
        for(int idx = 0; idx < array.length; idx ++)
        {
            if(array[idx].equals(value))
            {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        /************ NOT Effective *****************************/
        /*
        String[] outArr = new String[array.length];
        
        for(int inIdx = array.length-1, outIdx = 0; inIdx >= 0; 
                                                inIdx--, outIdx++)
        {
            outArr[outIdx] = array[inIdx];
        }
        return outArr;
        */
       
        String temp = null;
        for(int startIdx = 0, endIdx = array.length-1; startIdx <= array.length / 2; 
                                                endIdx--, startIdx++)
        {
            temp = array[startIdx];
            array[startIdx] = array[endIdx];
            array[endIdx] = temp;
        }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        boolean isPalindrom = true;
        
        for(int inIdx = array.length-1, outIdx = 0; inIdx >= array.length/2; 
                                                inIdx--, outIdx++)
        {
            if(!array[outIdx].equals(array[inIdx]))
            {
                isPalindrom = false;
                break;
            }
        }

        return isPalindrom;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean isPresent = false;
        char startChar = 'a';
        int charIdx = 0;
        for(charIdx = startChar; charIdx < startChar + 26; charIdx++)
        {
            isPresent = false;
            for(int arrayIdx = 0 ; arrayIdx < array.length; arrayIdx ++)
            {
                if(array[arrayIdx].toLowerCase().
                                contains(String.valueOf((char)charIdx)))
                {
                    isPresent = true;
                    break;
                }
            }
            if(isPresent == false)
                break;
        }
        

        return (charIdx == startChar + 26);
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int numberOfOccurrences = 0;
        for(int idx = 0; idx < array.length; idx ++)
        {
            if(array[idx].equals(value))
            {
                numberOfOccurrences ++ ;
            }
        }
        return numberOfOccurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) 
    {
        //**************************** Without ArrayList**************//
        /*
        int noOfOccurrences = getNumberOfOccurrences(array, valueToRemove);
        String[] outArray = new String[array.length - noOfOccurrences];
        for(int idx = 0, outIdx = 0; idx < array.length; idx ++)
        {
            if(!array[idx].equals(valueToRemove))
            {
                outArray[outIdx] = array[idx];
                outIdx++;
            }
        }
        return outArray;
        */
       
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int idx = 0; idx < array.length; idx ++)
        {
        if(!array[idx].equals(valueToRemove))
            {
                arrayList.add(array[idx]);
            }
        }
        String[] outArray = new String[arrayList.size()];
        arrayList.toArray(outArray);
        return outArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        //**************************** Without ArrayList**************//
        /*
        int sizeOfOutArray = 1;
        String strToCheck = array[0];
        int outIdx = 1;
        for(int idx = 1; idx < array.length; idx ++)
        {
            if(!array[idx].equals(strToCheck))
            {
                sizeOfOutArray++;
                strToCheck = array[idx];
            }
        }
        String[] outArray = new String[sizeOfOutArray];
        strToCheck = array[0];
        outArray[0] = array[0];
        for(int idx = 1; idx < array.length; idx ++)
        {
            if(!array[idx].equals(strToCheck))
            {
                outArray[outIdx] = array[idx];
                outIdx++;
                strToCheck = array[idx];
            }
        }
        return outArray;*/
       
        String strToCheck = array[0];
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(strToCheck);
        for(int idx = 1; idx < array.length; idx ++)
        {
            if(!array[idx].equals(strToCheck))
            {
                arrayList.add(array[idx]);
                strToCheck = array[idx];
            }
        }
        String[] outArray = new String[arrayList.size()];
        arrayList.toArray(outArray);
        return outArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
       String strToCheck = array[0];
       ArrayList<String> arrayList = new ArrayList<String>();
       String packedStr = strToCheck;
       for(int idx = 1; idx < array.length; idx ++)
       {
            if(array[idx].equals(strToCheck))
            {
                packedStr += strToCheck;
            }
            else
            {
                strToCheck = array[idx];
                arrayList.add(packedStr);
                packedStr = strToCheck;
            }
       }
       arrayList.add(packedStr);
       String[] outArray = new String[arrayList.size()];
       arrayList.toArray(outArray);
       return outArray;
    }


}
