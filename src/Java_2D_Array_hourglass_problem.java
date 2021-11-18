
/*
Question:

You are given a  2D array. An hourglass in an array is a portion shaped like this:
a b c
  d
e f g

For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:
1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0

The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.
In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format:
There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and  inclusive.

Output Format:
Print the answer to this problem on a single line.

Sample Input1:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output1:
19

Explanation:
The hourglass which has the largest sum is:
2 4 4
  2
1 2 4

Sample Input2:
-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5
Sample Output2:
-6

*/

//Solution:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Java_2D_Array_hourglass_problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();

        int maxSum = -63;
        /*Line elements*/
        int Current1stLine = 0;
        int Current2ndLine = 1;
        int Current3rdLine = 2;
        for(int i = 0; i < 4; i++){
            /*1st Line elements.*/
            int FlELE1I = 0;
            int FlELE2I = 1;
            int FlELE3I = 2;
            /*2nd Line elements.*/
            int SlELE1I = 1;
            /*3nd Line elements.*/
            int TlELE1I = 0;
            int TlELE2I = 1;
            int TlELE3I = 2;
            for(int j = 0 ; j<4; j++){
                int tempSum = arr.get(Current1stLine).get(FlELE1I) + arr.get(Current1stLine).get(FlELE2I) + arr.get(Current1stLine).get(FlELE3I)+
                        arr.get(Current2ndLine).get(SlELE1I) +
                        arr.get(Current3rdLine).get(TlELE1I) + arr.get(Current3rdLine).get(TlELE2I) + arr.get(Current3rdLine).get(TlELE3I);
                if(tempSum>maxSum){
                    maxSum = tempSum;
                }
                FlELE1I++;
                FlELE2I++;
                FlELE3I++;
                SlELE1I++;
                TlELE1I++;
                TlELE2I++;
                TlELE3I++;
            }
            Current1stLine++;
            Current2ndLine++;
            Current3rdLine++;
        }
        System.out.println(maxSum);
    }
}
