package com.example.jenkinsdemo.service;

import com.example.jenkinsdemo.bean.ListNode;
import com.example.jenkinsdemo.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-18 21:44
 */
@Service
@Slf4j
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
        ListNode head = listNode;
        List<Integer> list = new ArrayList<>(num);
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        log.info("排序前,list->{}", JsonUtil.object2Json(list));
        ListNode mylist = sortList(listNode);
        list.clear();
        while (mylist != null){
            list.add(mylist.val);
            mylist = mylist.next;
        }
        log.info("排序后,list->{}", JsonUtil.object2Json(list));
        list.clear();
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
