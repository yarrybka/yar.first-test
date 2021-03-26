public class App {
        public static void main(String[] args) {
            String braces = "[({[{{(({}))}}]})][{{(({[({[{{(({}))}}]})()]}))}}]{[(())[]()]}";



            boolean result = false;

            //CHECK AMOUNT OF OPEN&CLOSE BRACES
            int countOpenB1 = 0;
            int countOpenB2 = 0;
            int countOpenB3 = 0;
            int countCloseB1 = 0;
            int countCloseB2 = 0;
            int countCloseB3 = 0;
            boolean isTrueB1 = false;
            boolean isTrueB2 = false;
            boolean isTrueB3 = false;

            char[] bracesArray = braces.toCharArray();
            for(int i = 0; i < bracesArray.length; i++) {
                if(bracesArray[i] == '(') {countOpenB1 += 1;}
                if(bracesArray[i] == '{') {countOpenB2 += 1;}
                if(bracesArray[i] == '[') {countOpenB3 += 1;}
                if(bracesArray[i] == ')') {countCloseB1 += 1;}
                if(bracesArray[i] == '}') {countCloseB2 += 1;}
                if(bracesArray[i] == ']') {countCloseB3 += 1;}
            }
            if(countOpenB1 == countCloseB1) { isTrueB1 = true;}
            if(countOpenB2 == countCloseB2) { isTrueB2 = true;}
            if(countOpenB3 == countCloseB3) { isTrueB3 = true;}

            //LOOP FOR NEAREST BRACES
            if(isTrueB1 == true && isTrueB2 == true && isTrueB3 == true) {
                StringBuilder bracesFor = new StringBuilder(braces);
                int j = 0;
                while(bracesFor.toString().equals("") != true){
                    j += 1;
                    bracesArray = bracesFor.toString().toCharArray();
                    bracesFor = new StringBuilder();
                    for(int i = 0; i < bracesArray.length; i++) {
                        if(bracesArray[i] == '(' && bracesArray[i+1] == ')') {bracesArray[i] = 0; bracesArray[i+1] = 0;}
                        if(bracesArray[i] == '{' && bracesArray[i+1] == '}') {bracesArray[i] = 0; bracesArray[i+1] = 0;}
                        if(bracesArray[i] == '[' && bracesArray[i+1] == ']') {bracesArray[i] = 0; bracesArray[i+1] = 0;}
                        if(bracesArray[i] != 0) {bracesFor.append(bracesArray[i]);}
                    }
                    System.out.println(j+"-"+bracesFor.toString());
                    if(bracesFor.toString().length() == bracesArray.length) { break; }
                }
                if(bracesFor.toString().equals("")) { result = true; }
            }
            System.out.println(result);

        }


    }

