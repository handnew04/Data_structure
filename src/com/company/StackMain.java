package com.company;

class Stack<T> {

    class Node<T> {
        private T data;
        private Node<T> next; //다음을 노드를 담을 변수

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top = null; //맨위의 노드를 담을 변수

    public void push(T data) { //삽입
        Node<T> item = new Node<>(data);
        if (top != null) { //먼저 쌓여있는 노드가 있다면
            item.next = top; //다음노드 연결자리에 이전의 top 노드를 넣어줌 -> top이 그아래의 노드를 가리키고, 그 아래의 노드가 또 그 아래의 노드를 가리키는 구조
        }
        top = item; //top은 새로만들어진 node item이 들어감
    }

    public void pop() { //삭제 (맨 뒤에 들어간 노드가 삭제 됨)
        if (top == null) { //삭제 할 top 노드가 없다면
            System.out.println("스택이 비어있습니다.");
            return;
        }
        top = top.next;
    }

    public void peek() { //맨위의 top, 맨 뒤에 들어간 노드 읽기
        if (top == null) {
            System.out.println("스택이 비었습니다.");
            return;
        }
        System.out.println("peek : " + top.data);
    }

    public boolean isEmpty() { //비었는지 체크
        if (top == null) {
            return true;
        }
        return false;

    }


}

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> item = new Stack<>();
        item.push(1);
        item.push(2);
        item.push(3);
        item.push(4);
        item.peek(); // 4
        item.pop(); //4 삭제
        item.pop(); //3 삭제
        item.peek(); //2
        System.out.println(item.isEmpty()); //2, 1 있음 -> false
        item.pop(); //2 삭제
        item.pop(); //1 삭제
        System.out.println(item.isEmpty()); //true
    }

}
