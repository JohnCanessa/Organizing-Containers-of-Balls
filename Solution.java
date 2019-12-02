import java.util.HashMap;
import java.util.Scanner;

/*
*
*/
class Solution {

  /*
   * David wants to perform some number of swap operations such that: - Each
   * container contains only balls of the same type. - No two balls of the same
   * type are located in different containers.
   *
   * In a single operation, David can swap two balls located in different
   * containers.
   * 
   * Approach: Check if there are any type of balls with the same quantity of that
   * of each box.
   */
  static String organizingContainers(int[][] container) {

    // **** for starters ****
    String result = "Possible";

    // **** populate hash map of ball counts per type (i.e., '0', '1', ... 'n - 1')
    // ****
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int col = 0; col < container.length; col++) {
      int sum = 0;
      for (int row = 0; row < container.length; row++) {
        sum += container[row][col];
      }

      // **** add the type and count to the hashmap ****
      hm.put(col, sum);

      // ???? ????
      System.out.println("organizingContainers <<< hm: " + hm.toString());
    }

    // **** loop computing the initial number of balls per container ****
    for (int row = 0; row < container.length; row++) {

      // **** compute number of balls per container (i.e., 0, 1, 2, n - 1) ****
      int sum = 0;
      for (int col = 0; col < container.length; col++)
        sum += container[row][col];

      // // ??? ????
      // System.out.println("organizingContainers <<< sum: " + sum);

      // **** get associated sum (value) ****
      if (hm.containsValue(sum)) {

        // **** remove key with specified value ****
        hm.values().remove(sum);

        // ???? ????
        System.out.println("organizingContainers <<< hm: " + hm.toString());
      } else {
        result = "Impossible";
        break;
      }
    }

    // **** return result ****
    return result;
  }

  /*
   * Test scaffolding.
   */
  public static void main(String[] args) {

    // **** open scanner ****
    Scanner sc = new Scanner(System.in);

    // **** read the number of queries ****
    int q = sc.nextInt();

    // // ???? ????
    // System.out.println("main <<< q: " + q);

    // **** loop once per query ****
    for (int i = 0; i < q; i++) {

      // **** read the number of containers ****
      int n = sc.nextInt();
      sc.nextLine();

      // // ???? ????
      // System.out.println("main <<< n: " + n);

      // **** define the containers ****
      int[][] containers = new int[n][n];

      // **** loop once per container ****
      for (int j = 0; j < n; j++) {

        // **** read the contents of this container ****
        String str = sc.nextLine();

        // // ???? ????
        // System.out.println("main <<< str ==>" + str + "<==");

        // **** split the string of values ****
        String[] subStr = str.split(" ");

        // **** load the container ****
        for (int k = 0; k < subStr.length; k++)
          containers[j][k] = Integer.parseInt(subStr[k]);
      }

      // **** process these containers****
      System.out.println(organizingContainers(containers));
    }

    // **** close scanner ****
    sc.close();
  }
}