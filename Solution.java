import java.util.ArrayList;

public class Solution {
    public static String main(String string) {
       string = Evrica(string);
        System.out.println(string);
      string = commaToDot(string);
        System.out.println(string);
       string = trigonometricalCrasher(string);
        System.out.println(string);
       string = poweredNumbers(string);
        System.out.println(string);
       string = borderOpener(string);
        System.out.println(string);
       string = solution(string);
        System.out.println(string);
       return string;


        /*System.out.println(trigonometricalCrasher("1 + sin(90) + cos(180) + ctg(45) + tg(45) + e + \u03c0"));
        System.out.println(poweredNumbers("1 + -2^(5) + e + \u03c0"));
        String s = " (-1) + 5 - 4 + sin(-45)";
        System.out.println(Evrica(s));*/
    }

    public static String Evrica (String string){
        String newString = string.replace(" - "," _ ");
        return newString;
    } //меняет - на _ )))

    public static String commaToDot (String string){
        String newString = string.replace(',','.');
        return newString;
    }

    public static String trigonometricalCrasher (String string){ //разбираемся с тригонометрией
        String newString = string;
        boolean iter = true;
        int leftBound = 0;
        int rightBound = 0;
        while (iter) {
            iter = false;

            for (int i = 0; i < newString.length(); i++) {
                if (newString.charAt(i) == 's') {               //синус
                    double corner;
                    leftBound = i+3;
                    for (int j = 2; j < Math.min(newString.length()-i+5,11);j++){
                        if (newString.charAt(leftBound+j) == ')'){
                            rightBound = leftBound+j;
                            break;
                        }
                    }
                    if(rightBound == 0){
                        return "ERROR4";
                    }
                    iter = true;
                    corner = Double.parseDouble(newString.substring(leftBound+1,rightBound));
                    newString = trigonometricFree(newString, Math.sin(Math.toRadians(corner)),leftBound-3,rightBound);
                }
                if (newString.charAt(i) == 'c' && newString.charAt(i+1) == 'o') {               //косинус
                    double corner;
                    leftBound = i+3;
                    for (int j = 2; j < Math.min(newString.length()-i+5,11);j++){
                        if (newString.charAt(leftBound+j) == ')'){
                            rightBound = leftBound+j;
                            break;
                        }
                    }
                    if(rightBound == 0){
                        return "ERROR5";
                    }
                    iter = true;
                    corner = Double.parseDouble(newString.substring(leftBound+1,rightBound));
                    newString = trigonometricFree(newString, Math.cos(Math.toRadians(corner)),leftBound-3,rightBound);
                }
                if (newString.charAt(i) == 'c' && newString.charAt(i+1) == 't') {               //котангенс
                    double corner;
                    leftBound = i+3;
                    for (int j = 2; j < Math.min(newString.length()-i+5,11);j++){
                        if (newString.charAt(leftBound+j) == ')'){
                            rightBound = leftBound+j;
                            break;
                        }
                    }
                    if(rightBound == 0){
                        return "ERROR6";
                    }
                    iter = true;
                    corner = Double.parseDouble(newString.substring(leftBound+1,rightBound));
                    newString = trigonometricFree( newString, (1.0 / Math.tan(Math.toRadians(corner))),leftBound-3, rightBound);
                }
                if (newString.charAt(i) == 't') {                         //тангенс
                    double corner;
                    leftBound = i+2;
                    for (int j = 2; j < Math.min(newString.length()-i+4,11);j++){
                        if (newString.charAt(leftBound+j) == ')'){
                            rightBound = leftBound+j;
                            break;
                        }
                    }
                    if(rightBound == 0){
                        return "ERROR7";
                    }
                    iter = true;
                    corner = Double.parseDouble(newString.substring(leftBound+1,rightBound));
                    newString = trigonometricFree( newString,  Math.tan(Math.toRadians(corner)),leftBound-3, rightBound);
                }
                if (newString.charAt(i) == 'e') {                         //экспонентас
                    leftBound = i;
                    rightBound = i;
                    iter = true;
                    double scale = Math.pow(10, 7);
                    double result = Math.round(Math.E * scale) / scale;
                    newString = trigonometricFree( newString,  result, leftBound, rightBound);
                }
                if (newString.charAt(i) == '\u03c0') {                         //экспонентас
                    leftBound = i;
                    rightBound = i;
                    iter = true;
                    double scale = Math.pow(10, 7);
                    double result = Math.round(Math.PI * scale) / scale;
                    newString = trigonometricFree( newString,  result,leftBound, rightBound);
                }

            }
            leftBound = 0;
            rightBound = 0;
        }
        return newString;
    }

    public static String poweredNumbers (String string) {                   //разбираемся со степенями
        String newString = string;
        boolean iter = true;
        int leftBound = 0;
        int rightBound = 0;
        while (iter) {
            iter = false;

            for (int i = 0; i < newString.length(); i++) {
                if (newString.charAt(i) == '^') {
                    double a;
                    double b;

                    for (int j = 2; j < Math.min(newString.length() - i + 2, 11); j++) {
                        if (newString.charAt(i + j) == ')') {
                            rightBound = i + j;
                            break;
                        }
                    }
                    for(int j = i; j >= 0; j-- ){
                        if (Character.isWhitespace(newString.charAt(j)) || newString.charAt(j) == '-'){
                            leftBound = j;
                            System.out.println(j);
                            break;
                        }
                    }
                    if (rightBound == 0) {
                        return "ERROR8";
                    }

                    a = Double.parseDouble(newString.substring(leftBound+1,i));
                    b = Double.parseDouble(newString.substring(i+2,rightBound));

                    iter = true;

                    newString = trigonometricFree(newString, Math.pow(a,b), leftBound+1, rightBound);
                }
            }
            leftBound = 0;
            rightBound = 0;
        }
        return newString;
    }

    public static String trigonometricFree (String string, double result, int leftbound, int rightbound){ //перерисовываем тригонометрию
        String stringWithoutTrigonometry;
        String str1 = string.substring(0,leftbound);
        //String cutStr = solution(string.substring(leftbound+1,rightbound));
        String str2 = string.substring(rightbound+1);
        stringWithoutTrigonometry = str1 + result + str2;
        /*if(result < 0) {
            stringWithoutTrigonometry = str1 + "(" + result + ")" + str2;
        }else{
            stringWithoutTrigonometry = str1 + result + str2;
        }*/
         return stringWithoutTrigonometry;
    }

    public static String borderOpener(String string){  //разбираемся со скобками
        String string1 = string;
        boolean iter = true;
        int differ = 0;
        //ArrayList<Integer> leftBounds = new ArrayList<>();
        //ArrayList<Integer> rightBounds = new ArrayList<>();
        int leftBound = 0;
        int rightBound = 0;
        boolean l = true;
        boolean r = true;

        while (iter) {
            iter = false;

            for (int i = 1; i < string1.length(); i++) {
                if (string1.charAt(i) == '(') {
                    differ++;
                    leftBound = i;

                }
                if (string1.charAt(i) == ')') {
                    differ--;
                    rightBound = i;

                }
                if (leftBound > 0 && rightBound > leftBound) {
                    string1 = boundFree(string1, leftBound, rightBound);
                    iter = true;
                    //System.out.println(leftBound);
                    //System.out.println(rightBound);
                    //System.out.println(string1);
                    break;
                }

            }
            leftBound = 0;
            rightBound = 0;
        }


        return string1;
    }

    public static String boundFree (String string, int leftbound, int rightbound){ //удалятель скобок
        String str1 = string.substring(0,leftbound-1);
        String cutStr = solution(string.substring(leftbound+1,rightbound));
        String str2 = string.substring(rightbound+2);
        //System.out.println(string.substring(leftbound+1,rightbound));
        String boundFreeString = str1 + cutStr + str2;
    return boundFreeString;
    }

    public static String solution(String string){       //пытаемся складывать, вычитать, умножать и делить положительные числа
        String answer;
        String digitString = "";
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        for (int i = 0; i < string.length(); i++){
            if (Character.isDigit(string.charAt(i)) || string.charAt(i) =='-'){
                digitString += string.charAt(i);
            }else{
                if (!digitString.isEmpty()){
                    if(string.charAt(i) == '.'){
                        digitString +='.';
                    }else {
                        if(digitString.length()>9){
                            return "ERROR1";
                        }else {
                            numbers.add(Double.parseDouble(digitString));
                        }
                        digitString = "";
                    }
                }else {
                    if(string.charAt(i) == '+'||
                            string.charAt(i) == '/'||
                            string.charAt(i) == '*'||
                            string.charAt(i) == '_') {
                        operators.add(string.charAt(i));
                    }
                }
            }
        }
        if(!digitString.isEmpty()){
            if(digitString.length()>9){
                return "ERROR2";
            }else {
                numbers.add(Double.parseDouble(digitString));
            }
        }
        if(!(numbers.size() -1 == operators.size())){
            System.out.println(numbers.toString()+operators.toString());
            return "ERROR3";
        }

        ArrayList<Double> toSumNumbers = new ArrayList<>();
        ArrayList<Character> sumOperators = new ArrayList<>();
        double tmp = numbers.get(0);
        for (int i = 0; i < operators.size(); i++){
            if(operators.get(i) == '+' || operators.get(i) == '_'){
                sumOperators.add(operators.get(i));
                toSumNumbers.add(tmp);
                tmp = numbers.get(i+1);
            }
            if(operators.get(i) == '*'){
                tmp = tmp * numbers.get(i+1);
            }
            if(operators.get(i) == '/'){
                tmp = tmp / numbers.get(i+1);
            }
        }
        toSumNumbers.add(tmp);

        double resoult = toSumNumbers.get(0);
        for (int i = 0; i < sumOperators.size(); i++){
            if (sumOperators.get(i)=='+'){
                resoult += toSumNumbers.get(i+1);
            }else{
                resoult -= toSumNumbers.get(i+1);
            }
        }

        String exit = "" + resoult;

        return exit;
    }
}
