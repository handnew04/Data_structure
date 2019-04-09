package Queue_structure;

class Queue<T> {
    class Node<T> {
        T data;
        Node next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;

    public void add(T d) { //추가
        Node<T> item = new Node<>(d);
        if (first == null) { // 큐에 아무것도 없을 때
            first = item; //first 에 아이템이 들어가고
            last = first; //하나 뿐이기에 last 와 first 가 같은 노드
        } else {
            last.next = item; // 이미 노드가 있다면 기존 last 노드의 next에 아이템을 넣고
            last = item; // 아이템이 새 last 가 된다
        }
    }

    public T remove() { //삭제 -> first 삭제
        if (first == null) { // 큐에 아무것도 없을때
            return null;
        }
        T tmp = first.data; //출력할 ,삭제 될 노드

        if (first != last) { // 노드가 두개 이상일 때
            first = first.next; //first 에 그 다음의 노드를 넣어줌
            return tmp; //삭제된 노드의 데이터 출력
        }
        first = null; //노드가 하나일 때 : 둘다 null로 만들고 출력
        last = null;
        return tmp;
    }

    public T peek() {
        if (first != null) {
            return first.data; //first의 데이터 출력
        }
        return null;
    }

    public boolean isEmpty() { //비었는지 체크
        if (first == null) {
            return true;
        }
        return false;
    }

}

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> item = new Queue<>();
        item.add(1);
        item.add(2);
        item.add(3);
        item.add(4);
        item.add(5);
        System.out.println("first : " + item.peek());
        System.out.println("remove : " + item.remove());
        System.out.println("remove : " + item.remove());
        System.out.println("first : " + item.peek());
        System.out.println(item.isEmpty());
        System.out.println("remove : " + item.remove());
        System.out.println("remove : " + item.remove());
        System.out.println("remove : " + item.remove());
        System.out.println(item.isEmpty());
    }
}
