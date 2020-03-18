package com.example.jenkinsdemo.service;

import com.example.jenkinsdemo.bean.ListNode;
import org.springframework.stereotype.Service;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-18 21:44
 */
@Service
public class StressService {

    public void easy(){
        run(100);
    }

    public void hard(){
        run(1000);
    }

    public void run(int num){
        ListNode listNode = new ListNode(0);
        ListNode next = listNode;
        for (int i=0;i<num;i++){
            int random = (int) (Math.random()*num);
            ListNode node = new ListNode(random);
            next.next = node;
            next = next.next;
        }
        ListNode list = listNode;
        System.out.println("\n排序前");
        while (list != null){
            System.out.print(list.val+" ");
            list = list.next;
        }

        ListNode mylist = sortList(listNode);
        System.out.println("\n排序后");
        while (mylist != null){
            System.out.print(mylist.val+" ");
            mylist = mylist.next;
        }
    }


    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sortList(head),sortList(next));
    }

    private ListNode getMid(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head,fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode n1,ListNode n2){
        ListNode node = new ListNode(0);
        ListNode cur1 = n1,cur2=n2,cur=node;
        while (cur1 != null && cur2 != null){
            if (cur1.val > cur2.val){
                cur.next = cur2;
                cur2= cur2.next;
            }else {
                cur.next = cur1;
                cur1= cur1.next;
            }
            cur = cur.next;
        }
        if (cur1 != null){
            cur.next = cur1;
        }
        if (cur2 != null){
            cur.next = cur2;
        }
        return node.next;
    }
}
