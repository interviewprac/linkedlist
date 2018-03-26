package com.current;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    static int max(int a, int b) { return (a > b)? a : b; }

    static int findWeight(int W, int wt[], int data[], int n)
    {
        if (n == 0 || W == 0)
            return 0;

       if (wt[n-1] > W)
            return findWeight(W, wt, data, n-1);


        else return max( data[n-1] + findWeight(W-wt[n-1], wt, data, n-1),
               findWeight(W, wt, data, n-1)
        );
    }

    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {

        return findWeight(n,bundleQuantities,bundleCosts,bundleQuantities.length);
    }


    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        Solution s = new Solution();
        filename = scan.nextLine();

        int count = 0;
        long county = 0;
        long sum =0;

         if (filename != null) {
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {

                System.out.println(st);

                String[] splitted = st.trim().split(" ");
                int bytes = Integer.parseInt(splitted[splitted.length - 1]);

                if (bytes > 5000) {
                    count++;
                    sum += bytes;
                }
            }
            s.writeFile(filename,count,sum);
        }
    }

    public void writeFile(String filename, int count, long sum) {
        BufferedWriter out=null;
        try {
             out = new BufferedWriter(new FileWriter("bytes_"+ filename));
            out.write(count + "\n" + sum);
        } catch (IOException e) {
            System.out.println("Exception ");

        } finally {
            try {
                if(out!=null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
