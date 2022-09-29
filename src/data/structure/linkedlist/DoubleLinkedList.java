package data.structure.linkedlist;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T>{
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(this.head == null){ //아무것도 없는 상태
            this.head = new Node<T>(data);
            this.tail = this.head;
        }else{
            Node<T> node = this.head;
            while(node.next != null){
                node=node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll(){
        if(this.head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    //앞에서 부터 node 찾기
    public T searchFromHead(T isData){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.next;
                }
            }
            return null;
        }
    }

    //뒤에서 부터 node 찾기
    public T searchFromTail(T isData){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.tail;
            while(node != null){ //node.prev == null 이면 head까지 순회 했다는 뜻임.
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.prev; //node.prev == null 이면 head까지 순회 했다는 뜻임.
                }
            }
            return null;
        }
    }

    //데이터 앞에서 끼워 넣기
    public boolean insertToFront(T existedData,T addData){ //existedData 앞에다가 addData를 넣을꺼임
        if(this.head == null){ //아무것도 없는 상태
            this.head = new Node<T>(addData); //addData 가 첫 노드가 될거임
            this.tail = this.head; //node 가 이거 한개라 head == tail 인 상태
            return true;
        }else if(this.head.data == existedData){ //head 하나 밖에 없는 상태
            Node<T> newHead = new Node<T>(addData); //새로운 헤드를 만듦. 근데 그 head 가 addData 임
            newHead.next = this.head; // 새로만든 head 의 다음 노드는 예전의 head
            this.head = newHead; // 이제 현재 head 는 새로만든 head
            return true;
        }else{ // node 가 head 말고 한개 이상일 때
            Node<T> node = this.head; // head 부터 순회하려고
            while(node != null){ //node == null 아무것도 없는 상태 (모든 node를 다 순회 했다는 뜻)
                if(node.data == existedData){ //내가 찾는 끼어들려고 하는 node
                    Node<T> nodePrev = node.prev; //내가 끼어 들려고 하는 node 의 앞 노드
                    nodePrev.next = new Node<T>(addData); //내가 끼어 들려고 하는 node 의 앞 노드의 다음 노드는 이제 addData임
                    nodePrev.next.next = node; //내 노드의 다음 노드는 내가 끼어 들려고 하는 node
                    nodePrev.next.prev = nodePrev; //내 노드의 앞 노드는 내가 끼어 들려고 하는 node의 앞 노드 였던것
                    node.prev = nodePrev.next; //내가 끼어 들려고 하는 노드의 앞 노드는 이제 나임
                    return true;
                }else{ //내가 찾는 노드가 아니라면?
                    node = node.next; //다음 노드
                }
            }
            return false; //노드를 다 순회 했는데도 없다면 그건 없는 데이터임 false 리턴
        }
    }

    public boolean delNode(T isData){
        if(this.head == null){ //아무것도 없는 상태
            return false;
        }else{
            Node<T> node = this.head;
            if(node.data == isData){
                this.head = this.head.next;
                return true;
            }else{
                while(node.next != null){ //node.next == null 이면 node 가 끝 노드라는 뜻
                    if(node.next.data == isData){ //node 의 다음 node 가 삭제할 node 라면
                        node.next = node.next.next; //node 의 다음 node 는 삭제할 node 의 다음 노드
                        return true;
                    }else{
                        node = node.next;
                    }
                }
                return false;
            }
        }
    }


}
