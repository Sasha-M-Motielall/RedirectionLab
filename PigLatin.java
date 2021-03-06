import java.util.*;
public class PigLatin{

  public static boolean weird(char[] sample, String term){
    char lookfor = term.charAt(0);
    boolean answer = false;
    for(int i=0;i<sample.length;i++){
      if(lookfor==sample[i]){answer=true;}
    }
    return answer;
  }

  public static boolean weirder(String[] digraphs, String check){
    String lookerfor = check.substring(0,2);
    boolean statement = false;
    for(int i=0;i<digraphs.length;i++){
      if(lookerfor.equals(digraphs[i])){statement=true;}
    }
    return statement;
  }

  public static String pigLatinSimple(String s){
   String fix = s.toLowerCase();
   char[] a = new char[]{'a','e','i','o','u'};
   if(weird(a, fix)){return fix + "hay";}
   return fix.substring(1) + fix.charAt(0) + "ay";
  }

  public static String pigLatin(String st){
    st = st.toLowerCase();
    char[] b = new char[]{'a','e','i','o','u'};
    String[] c = new String[]{"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl",
                              "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr",
                              "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp",
                              "st", "sw", "th", "tr", "tw", "wh", "wr"};
    if(st.length()<=1){return st + "ay";}
    if(weirder(c, st)){return st.substring(2) + st.substring(0,2) + "ay";}
    if(weird(b, st)){return st + "hay";}
    return st.substring(1) + st.charAt(0) + "ay";
  }

  public static String pigLatinBest(String str){
    str = str.toLowerCase();
    String punc = "";
    if(!Character.isLetter((Character)str.charAt(str.length()-1)) && !Character.isDigit((Character)str.charAt(str.length()-1)))
      {punc=str.charAt(str.length()-1)+""; str=str.substring(0,str.length()-1);}
    if(!Character.isLetter(str.charAt(0))){return str + punc;}
    char[] d = new char[]{'a','e','i','o','u'};
    String[] e = new String[]{"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl",
                              "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr",
                              "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp",
                              "st", "sw", "th", "tr", "tw", "wh", "wr"};
    if(str.length()<=1){return str + "ay" + punc;}
    if(weirder(e, str)){return str.substring(2) + str.substring(0,2) + "ay" + punc;}
    if(weird(d, str)){return str + "hay" + punc;}
    return str.substring(1) + str.charAt(0) + "ay" + punc;
  }

  public static void main(String[] args){
    System.out.println(pigLatinSimple("mock"));
    System.out.println(pigLatinSimple("pie"));
    System.out.println(pigLatinSimple("david"));
    System.out.println(pigLatinSimple("aaron"));

    System.out.println(pigLatin("the"));
    System.out.println(pigLatin("check"));
    System.out.println(pigLatin("skee"));
    System.out.println(pigLatin("emu"));
    System.out.println(pigLatin("grade"));

    System.out.println(pigLatinBest("*emu"));
    System.out.println(pigLatinBest("4chan"));
    System.out.println(pigLatinBest("fish!"));
    System.out.println(pigLatinBest("fish"));
    System.out.println(pigLatinBest("the."));
    System.out.println(pigLatinBest("cat!"));
    System.out.println(pigLatinBest("amazing?"));
    System.out.println(pigLatinBest("apple%"));
  }
}
