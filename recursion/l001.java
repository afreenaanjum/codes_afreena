public class l001{

    public static void printDecreasing(int n){
        if(n < 1) return;
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n < 1) return;
        printIncreasing(n-1);
        System.out.println(n);
    }


    public static void evenDecreasingOddIncreasing(int n){
        
        if(n < 1) return;
        if(n % 2 == 0) {
            System.out.println(n);
        }
            evenDecreasingOddIncreasing(n-1);
            
        if(n % 2 != 0 ) {
            System.out.println(n);
        }
    }

    public static int factorial(int n){
        return n == 0 ?  1 : n * factorial(n-1);
    }
    
    public static int power(int a , int b){
        return b == 0 ? 1 : a * power(a, b-1);  
    }

    public static int powerLogn(int a , int b){
        if(b == 0 ) return 1;
        int smallAns = powerLogn(a, b/2);
        smallAns *= smallAns
        return b % 2 == 0 ?  smallAns : a * smallAns;
    } 

    public static void display(int []arr, int idx){
        if(idx == arr.length()){
            return;
        }
        System.out.println(arr[idx]);
        display(arr, idx + 1);
    }

    public static void findMaxEle(int []arr,int idx) {
        if(idx == arr.length()){
            return -(int)1e9;
        }
        return Math.max(arr[idx],findMaxEle(arr, idx+1));
    }

    public static int firstIndex(int [] arr, int idx, int data){
        if(idx == arr.length) {
            return -1;
        }
        if(arr[idx] == data){
            return idx;

        }
        return firstIndex(arr, idx + 1, data);
    }


    public static int lastIndex(int []arr, int idx, int data){
        if(idx == arr.length) return -1;
        int smallAns = lastIndex(arr, idx + 1, data);
        if(smallAns != -1) return smallAns;
        return arr[idx] == data ? idx : -1;
    }

    public static int[] allIndexes(int [] arr, int index, int count, int data){
        if(idx == arr.length) {
            return new int[count];
        }
        if(arr[idx] == data) ++count;
        int [] smallAns = allIndexes(arr, idx+1, count, data);
        if(arr[idx] == data){
            smallAns[count -1] = idx;
        }
        return smallAns;
    } 

    public static ArrayList<String> subSequences(String str, int idx){
        if(str.length() == idx) {
            ArrayList<String> base = new ArrayList<String>();
            base.add("");

            return base;
        }
        char ch = str.charAt(idx);
        ArrayList<String> returnedList = subSequences(str, idx + 1); // Length is 2^(length of string -1)
        ArrayList<String> finalList = new ArrayList<String>();

        for(Str s : returnedList) {
            finalList.add(s+ch);
            finalList.add("" +s);
        }
        return finalList;
    } 
    public static ArrayList<String> getKPC(String str, int idx){
        if(str.length() == idx) {
            ArrayList<String> base = new ArrayList<String>();
            base.add("");

            return base;
        }
         
        int i = str.charAt(idx) - '0';
        ArrayList<String> smallAns = getKPC(str, idx +1);
        static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

        String code = codes[i];
        ArrayList<String> finalList = new ArrayList<String>();

        for(String s : code){
            for(String a : smallAns){
                finalList.add(s +a);
            }
        }

        return finalList;

    }  

    //LC 91
    public static int decodeWays(int idx, String str, String ans){
        
        if(str.length() == idx){
            System.out.println(ans);
            return 1;
        }
        if(str.charAt(idx) == '0'){
            return 0;
        }
        int count = 0;
        count += decodeWays(idx + 1, str, ans + (char)(str.charAt(idx) - '1' + 'a')); //Starts from only 1

        if(idx < str.length() - 1) {
            int num = (str.charAt(idx) - '0') * 10 + (str.charAt(idx + 1) - '0');
            if(num <= 26) {
                count += decodeWays(idx + 2, str , ans + (char)(num - 1 + 'a')); // MInus 1 is done to correct the mapping here
            }
        }
        return count;
    }   

     public static int getKPCVariant(int idx, String str, String ans){
        if(str.length() == idx) {
            System.out.println(ans);
            return 1;
        }

        int ii = str.charAt(idx) - '0';
        int count = 0;
        String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz", "+-*", "/%^" };

        String code = codes[ii];

        for(int i = 0; i < code.length(); ++i) {
            count += getKPCVariant(idx + 1, str, ans + code.charAt(i) );
        }

        if( idx < str.length() -1) {
            int num = (str.charAt(
                
            ) - '0') * 10 +( str.charAt(idx + 1) - '0');
            // System.out.println(num);

            if(num == 10 || num == 11) { // 10 and 11 needs to be handled here
                code = codes[num];   
        for(int j = 0; j < code.length(); ++j) {
                    count += getKPCVariant(idx + 2, str, ans + code.charAt(j) );
                }
            }

        }
        return count;
    }


    public static void permutations(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i < str.length(); ++i){
            permutations(str.substring(0, idx) + str.substring(idx +1), idx + 1 , ans + str.charAt(idx));
        }
    }



    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDecreasing(n);
    }
}