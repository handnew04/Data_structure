package Linked_list_structure;

//단방향 연결리스트

class LinkedList<T> {
    private Node<T> header = null; //메소드에서 사용 될 머리 노드를 담당. 연결리스트의 시작점.
    private Node<T> pointer;

    class Node<T> {
        T data;
        Node next = null;
    }

    public LinkedList() { //LinkedList 클래스의 생성자. 생성시 header의 값이 생김.
        header = new Node();
    }

    public void append(T d) { //추가
        Node<T> item = new Node<>(); //추가 될 노드 생성
        item.data = d; //데이터 입력
        pointer = header; // 포인터에 헤더를 담아줌
        while (pointer.next != null) { // pointer.next 의 값이 null 이 되면 반복문이 멈춤 => 뒤에 연결된 노드가 없음. 즉 마지막 노드 앞 까지 반복문 실행
            pointer = pointer.next; //마지막 노드가 아닐때 그 다음 연결노드로 바꿔줌
        }
        pointer.next = item; //반복문이 끝나고 나면 pointer에 맨마지막 노드가 들어감. 마지막 노드의 next에 새로 만들어진 노드를 추가해줌
    }

    public void delete(T d) { //삭제
        pointer = header; //포인터에 헤더를 담아줌
        while (pointer.next != null) { // 포인터의 next 가 null이 아닐떄까지, -> 마지막 노드 앞 까지 반복문 실행
            if (pointer.next.data == d) { // 포인터의 next.data 값이 삭제할 d 값과 같다면 (포인터가 아닌 next 인것이 중요)
                pointer.next = pointer.next.next; //포인터의 next 값에 바로 뒤의 노드값 대신 뒤 뒤 노드값을 넣음 ( 1-2-3-4-5 라면 3을 삭제시 2의 next에 4를 넣음)
                return; //조건문 성립시 메소드 반복문 멈춤
            }else{
                pointer = pointer.next; //삭제할 d 가 아닌 경우 다음 노드로 넘어감
            }
        }
    }

    public void retrieve() { //연결리스트 읽기
        //pointer = header;
        pointer = header.next; //빈 헤더를 제외하고 그 뒤 노드부터 출력
        while (pointer.next != null) {
            System.out.print(pointer.data + "-> "); //출력
            pointer = pointer.next; //pointer 에 다음 노드를 담아줌 -> 다음 노드로 반복문 진행
        }
        System.out.println(pointer.data); //반복문이 끝나면 pointer 안에 마지막 노드가 들어있음. 출력해줌
    }
}


public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> item = new LinkedList<>();
        item.append(1);
        item.append(2);
        item.append(3);
        item.append(4);
        item.append(5);
        item.retrieve();
        item.delete(3);
        item.retrieve();
        item.delete(5);
        item.retrieve();
    }
}
