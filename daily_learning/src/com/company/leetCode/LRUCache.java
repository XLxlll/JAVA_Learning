package com.company.leetCode;

import java.util.HashMap;

/**
 * @title: LRUCache --实现一个LRU
 * 本质上是让你实现一种初始化容量大小为capacity数据结构，有两个API，一个是put(),英特是get()，这两个操作的时间复杂度均为O(1)
 * 也就是说查找、插入、删除要快，还有有一定的顺序
 * @Author Geek_Ling
 * @Date: 2020/8/4 8:21
 * @Version 1.0
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
       cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));   // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));      // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
    private int capacity;
    private HashMap<Integer,Node> map;
    private  DoubleListNode cache;
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleListNode();
    }
    public int get(int key){
        int res = -1;
        if (map.containsKey(key)){
            Node node = map.get(key);
            res = node.val;
            put(key,res);

        }
        return res;
    }
    public void put(int key,int value){
        Node node = new Node(key,value);
        //如果当前key在哈希表中，
        if (map.containsKey(key)){
            //删除这个node
            cache.remove(map.get(key));
            //将node移动到表头
            cache.addFirst(node);
          //更新map中的数据
            map.put(key,node);
        }else {
            if (cache.size == capacity){
                //如果当前cache满了,尾部删除,map中也需要删除
               Node removeNode = cache.removeLast();

                map.remove(removeNode.k);
            }
                cache.addFirst(node);
                map.put(key,node);
        }
    }
    //定义一个Node节点
    private class Node{
        int k,val;
        Node pre,next;
        public Node(int k,int val){
            this.k = k;
            this.val = val;
        }
    }
    //定义一个双链表
    private class DoubleListNode{
        private  Node head ;
        private  Node tail;
        private  int  size;
        public DoubleListNode(){
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }
        //在头结点插入x结点
        public void addFirst(Node x){
            x.next = head.next;
            head.next.pre = x;
            head.next = x;
            x.pre = head;
            size++;
        }
        //删除链表中的x结点
        public void remove(Node x){
           x.pre.next = x.next;
           x.next.pre = x.pre;
            size--;
        }
        //删除链表的最后一个结点，并返回这个结点
        public Node  removeLast(){
            if (tail.pre == head) return null;
            Node removeNode = tail.pre;
            remove(removeNode);
            return removeNode;

        }
        public int size(){
            return size;
        }
    }
}
