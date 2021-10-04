package WordNum;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WordNum {
    public static void main(String[] args)throws IOException
    {
        List<Integer> list=new ArrayList<>();
        DecimalFormat df=new DecimalFormat("######0.00");    //格式化
        FileInputStream fip = new FileInputStream("D:\\单词统计\\飘.txt");
        InputStreamReader reader = new InputStreamReader(fip, "gbk");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
        fip.close();

        int i;
        String A=sb.toString();
        String M="abcdefghijklmnopqrstuvwxyz";
        String temp = "";
        char NUM[]=new char[A.length()];
        char Z[]=new char[26];
        int X[]=new int[26];
        int MAX=0;
        Z=M.toCharArray();
        for(int k=0;k<26;k++)
        {
            X[k]=0;
            for(i=0;i<A.length();i++)
            {
                NUM[i]=A.charAt(i);
                if(Z[k]==NUM[i]||Z[k]==ch(NUM[i]))
                {
                    X[k]++;
                }
            }
        }
        System.out.println("这篇文章中英文字母个数分别为:");

        double sum=0;
        System.out.println("排序如下:");
        for(i=0;i<25;i++)
            for(int k=0;k<25-i;k++)
            {
                if(X[k]<X[k+1])
                {
                    int temp2=X[k];
                    X[k]=X[k+1];
                    X[k+1]=temp2;
                    char temp3=Z[k];
                    Z[k]=Z[k+1];
                    Z[k+1]=temp3;
                }
            }
        for(i=0;i<26;i++)
        {
            System.out.println(Z[i]+"字母个数为:"+X[i]);
            sum=sum+X[i];
        }
        for(i=0;i<26;i++)
        {
            double jkl=(X[i])/sum*100;
            System.out.println(Z[i]+"字母频率为:"+df.format(jkl)+"%");
        }
    }
    static char ch(char c)
    {
        if(!(c>=97&&c<=122))
            c+=32;
        return c;
    }
}
