package TP.cs.cs05.model;

public class RecursiveFunctions {
    public static int sumIntArray(int[] intArray){
        return sumIntArrayToWrapper(intArray, intArray.length);
    }

    public static String stringInverter(String string){
        return stringInverterToWrapper(string, string.length());
    }

    public static int findLargestElement(int[] intArray){
        return findLargestElementToWrapper(intArray, intArray.length);
    }

    public static int sumIntElements(int value){
        if(value > 0){
            return value % 10 + sumIntElements(value / 10);
        }
        return 0;
    }


    //Funções para encapsular
    private static int sumIntArrayToWrapper(int[] intArray, int length){
        if(intArray.length > 0 && length > 0){
            return intArray[length - 1] + sumIntArrayToWrapper(intArray, length - 1);
        }
        return 0;
    }

    private static String stringInverterToWrapper(String string, int length){
        if(!string.isEmpty() && length > 0){
            return string.charAt(length - 1) + stringInverterToWrapper(string, length - 1);
        }
        return "";
    }

    private static int findLargestElementToWrapper(int[] intArray, int length){
        if(intArray.length > 0 && length > 0){
            int elementA = intArray[length - 1];
            int elementB = findLargestElementToWrapper(intArray, length - 1);
            return elementA > elementB ? elementA : elementB;
        }
        return intArray.length > 0 ? intArray[0] : 0;
    }
}
