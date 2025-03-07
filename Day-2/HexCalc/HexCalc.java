import java.util.HashMap;

public class HexCalc {
    HashMap<Character,Integer> hashmap=new HashMap<Character,Integer>();

    // Mapped the hexadecimal number with decimal Number
    HexCalc(){
        hashmap.put('0',0);
        hashmap.put('1',1);
        hashmap.put('2',2);
        hashmap.put('3',3);
        hashmap.put('4',4);
        hashmap.put('5',5);
        hashmap.put('6',6);
        hashmap.put('7',7);
        hashmap.put('8',8);
        hashmap.put('9',9);
        hashmap.put('A',10);
        hashmap.put('B',11);
        hashmap.put('C',12);
        hashmap.put('D',13);
        hashmap.put('E',14);
        hashmap.put('F',15);

    }
    
    // Method to convert hexa decimal number to decimal number 
    public int hexToDec(String number){
        int num=0;
        for(int i=number.length()-1;i>=0;i--){
            int n=hashmap.get(number.charAt(i))*(int)Math.pow(16, (number.length()-1)-i);
            num+=n;
        }
        return num;
    }

    // Method to convert decimal number to hexa decimal number
    public String decToHex(int number){
        String hexNumber="";
        while(number>=15){
            hexNumber=(Integer.toHexString(number%16))+hexNumber;
            number/=16;
        }
        if(number!=0){
            hexNumber=Integer.toHexString(number)+hexNumber;
        }
        return hexNumber;
    }

    // Method to convert to add two hexa decimal number
    public String hexAddition(String num1, String num2){
        int n1=hexToDec(num1);
        int n2=hexToDec(num2);
        int sum=n1+n2;
        String HexSum=decToHex(sum);
        return HexSum;
    }

    // Method to convert to subtract two hexa decimal number
    public String hexSubtraction(String num1, String num2){
        int n1=hexToDec(num1);
        int n2=hexToDec(num2);
        String HexSub=decToHex(n1-n2);
        if(n1<n2){
            HexSub='-'+HexSub;
        }
        return HexSub;
    }

    // Method to convert to multiply two hexa decimal number
    public String hexMultiply(String num1, String num2){
        int n1=hexToDec(num1);
        int n2=hexToDec(num2);
        int sum=n1*n2;
        String HexSum=decToHex(sum);
        return HexSum;
    }

    // Method to convert to divide two hexa decimal number
    public String hexDivide(String num1, String num2){
        int n1=hexToDec(num1);
        int n2=hexToDec(num2);
        int sum=n1/n2;
        String HexSum=decToHex(sum);
        return HexSum;
    }

    // Method to check two hexa decimal numbers are equal
    public Boolean isEqual(String num1, String num2){
        if(num1.equals(num2)){
            return true;
        }
        return false;
    }

    // Method to check first hexa decimal number is greater than second
    public Boolean isGreater(String num1, String num2){
        int comparisionResult=num1.compareTo(num2);
        if(comparisionResult>0){
            return true;
        }
        return false;
    }

    // Method to check first hexa decimal number is smaller than second
    public Boolean isSmaller(String num1, String num2){
        int comparisionResult=num1.compareTo(num2);
        if(comparisionResult<0){
            return true;
        }
        return false;
    }

}