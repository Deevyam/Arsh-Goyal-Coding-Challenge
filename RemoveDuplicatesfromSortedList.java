/*
83. Remove Duplicates from Sorted List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
*/
Soln :
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head ,prev = head;
        while(temp!=null){
            if(prev.val==temp.val){
                prev.next=temp.next;
            }
            else{
                prev=temp;
            }
            temp=temp.next;
        }
        return head;
    }
}
