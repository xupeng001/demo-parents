package com.demo.linkList;

public class LinkedList {

    private Node head;

    private int  size;

    public LinkedList() {
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new Node(value));
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean remove(int value) {
        if (head == null) {
            return false;
        }
        if (head.getValue() == value) {
            head = head.getNext();
            size--;
            return true;
        }
        Node n = head.getNext();
        Node pn = head;
        while (n != null) {
            if (n.getValue() == value) {
                pn.setNext(n.getNext());
                size--;
                return true;
            }
            pn = n;
            n = n.getNext();

        }
        return false;
    }

    public void dispaly() {
        StringBuffer sb = new StringBuffer();
        Node node = head;
        while (node != null) {
            sb.append("  value : " + node.getValue());
            node = node.getNext();
        }
        System.out.println(sb.toString());
    }
}
