import java.util.*;
/**
 * Write a description of class GorgoneaQuarta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GQ_Decimal_Converter
{
    public static int toDecimal(String str)
    {
       int multiplier=1;
       int ans=0;
       for(int x=str.length()-1; x>=0; x--)
       {
            String temp=str.substring(x,x+1);
            if(temp.equals("0"))
                ans+=0*multiplier;
            else if(temp.equals("1"))
                ans+=1*multiplier;
            else if(temp.equals("-"))
                ans+=(-1)*multiplier;
            multiplier*=3;
       }
       return ans;
    }

    public static String toGQ(int num)
    {
       String current="";
       Set<String> s=new TreeSet<String>();
       ArrayList<String> arr=new ArrayList<String>();
       int count=0;
       if(num==0)
           return "0";
       else if(num==1)
           return "1";
       else if(num==(-1))
           return "-";
       else if(num>0)
           s.add("1");
       else if(num<0)
           s.add("-");
       while(true)
       {
           if(count==1000)
               return "";
           count++;
           Iterator<String> it=s.iterator();
           while(it.hasNext())
           {
               current=it.next();
               arr.add(current+"1");
               if(toDecimal(current+"1")==num)
                   return current+"1";
               arr.add(current+"0");
               if(toDecimal(current+"0")==num)
                   return current+"0";
               arr.add(current+"-");
               if(toDecimal(current+"-")==num)
                   return current+"-";
           }
           s.clear();
           for(int x=0; x<arr.size(); x++)
               s.add(arr.get(x));
       }
    }
}