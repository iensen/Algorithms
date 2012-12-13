/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 10/29/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
package iensen.IO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 10/29/12
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */

public class InputReader {
    StringTokenizer st;
    BufferedReader in;
    public InputReader(InputStream ins)
    {
        in = new BufferedReader(new InputStreamReader(ins));
    }

    public String nextToken()
    {
        while(st==null || !st.hasMoreTokens())
        {
            try {
                st=new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return st.nextToken();
    }
    public int nextInt()
    {

        return Integer.parseInt(nextToken());
    }

    public double nextDouble()
    {
        return Double.parseDouble(nextToken());
    }
    public long nextLong()
    {
       return  Long.parseLong(nextToken());
    }
    public String nextLine()  {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "";
    }
    public char nextChar()  {
        try {
            return (char)in.read();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return 0;
    }

}