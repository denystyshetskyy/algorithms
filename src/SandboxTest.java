import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SandboxTest {
    public static List<ListNode> resultVal = new ArrayList<>();
    public static int counter = 0;
    public static ListNode resultNode = new ListNode(0);
    public static ListNode tmp = resultNode;

    public static void main(String[] args) {
        ListNode two = new ListNode(2);
        ListNode two_1 = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode four_1 = new ListNode(4);
        two.next = four;
//        ListNode three = new ListNode(3);
//        four.next = three;
//        ListNode eight = new ListNode(8);
//        three.next = eight;
//        ListNode zero = new ListNode(0);
//        eight.next = zero;
//        zero.next = two_1;
//        two_1.next = four_1;

        ListNode five = new ListNode(5);
        ListNode five_1= new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode six_1 = new ListNode(6);
        five.next = six;
        ListNode fourAgain = new ListNode(4);
        six.next = fourAgain;
        ListNode eightAgain = new ListNode(8);
        fourAgain.next = eightAgain;
        eightAgain.next = five_1;
        five_1.next = six_1;
        ListNode nine =new ListNode(9);
        six_1.next = nine;




        ListNode result = addTwoNumbers(two, new ListNode(0));
        for (int i = 0;i<resultVal.size() - 1; i++) {
            resultVal.get(i).next = resultVal.get(i + 1);

        }
        while(result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            ListNode node = new ListNode((l1.val + l2.val + counter) / 10 >=1 ? l1.val + l2.val + counter -10 :  l1.val + l2.val + counter);
            counter = (l1.val + l2.val) / 10;
            resultVal.add(node);

            tmp.next = node;
            tmp = tmp.next;
            addTwoNumbers(l1.next, l2.next);

        }
        if (l1 == null && l2 != null || l1 != null && l2 == null) {
            ListNode l = new ListNode(l1 == null ? l2.val + counter : l1.val + counter);
            tmp.next = l;
        }
        if (counter != 0) {
            tmp.next = new ListNode(counter);
        }
            return resultNode.next;
    }

}
