package data.structure.linkedlist;

// 링크드 리스트는 필요할때마다 객체(Node<T>)를 하나씩 생성한다.
public class SingleLinkedList<T>{
    public Node<T> head = null;

    // node 객체
    public class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){//head 가 null 이라면 첫 노드라는 뜻
            head = new Node<T>(data); //head 에 첫 노드 생성
        }else{ // null 이 아니라면
            Node<T> node = this.head; // node : 탐색할 노드, 일단 헤드부터 시작
            while(node.next != null){ // node.next 가 null 이 아니면 뒤에 node 가 있다는 뜻
                node = node.next; // 탐색할 노드를 다음 노드로 변경
            }
            //node.next == null 인 상태, 뒤에 아무것도 없다는 뜻
            node.next = new Node<T>(data); //새로운 node 를 이어준다.
        }
    }

    //링크드 리스트 모든 데이터 출력
    public void printAll(){
        if(head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data){
        if(this.head == null){ //head 가 null 이라면
            return null;
        }else{ // null 이 아니라면
            Node<T> node = this.head;
            while(node != null){ // 처음부터 끝까지 순회 할 거임
                if(node.data == data){ //일치하는 data 가 있으면
                    return node; //해당 node 리턴
                }else{ //없으면
                    node = node.next; //다음 node
                }
            }
            return null; //링크드 리스트를 다 돌았는데도 없다면 null 리턴
        }
    }

    /**
     * 노드 사이에 새 데이터 끼워 넣는 함수
     * @param data 새로 입력 받을 데이터
     * @param isData 어떤 노드 뒤에 끼울건지(새로 만든 노드 앞에 올 노드)
     */
    public void addNodeInside(T data, T isData){
        Node<T> searchNode = this.search(isData); //내 앞에 오는 노드 찾기
        //새로 만들어서 삽입할 node 를 "나"라고 하겠음.
        if(searchNode == null){ //내 앞에 오는 노드가 없다면
            this.addNode(data); //맨 뒤에다가 붙여준다.
        }else{ //내앞에 오는 노드가 있다면
            //내 앞에 오는 node를 searchNode 라고 하겠음
            //nextNode는 이제 내 뒤에 오는 node임
            //원래는 searchNode 뒤에 nextNode가 와야함
            Node<T> nextNode = searchNode.next;
            //근데 이제 내가 사이에 끼어들거라서
            //searchNode의 뒤는 새로만들어진 내가 될거임
            searchNode.next = new Node<T>(data);
            //searchNode.next 는 나임
            // 나.next는 nextNode(searchNode의 뒤였던 node 이제는 내 뒤임)
            searchNode.next.next = nextNode;
        }
    }

    public boolean delNode(T isData){
        if(this.head == null){
            return false;
        }else{
            Node<T> node = this.head;
            if(node.data == isData){ //삭제할 node 가 head 라면
                this.head = this.head.next;
                return true;
            }else{ //head 가 아니라면
                while(node.next != null){ //모든 node 조회
                    if(node.next.data == isData){
                        node.next = node.next.next;
                        return true;
                    }else{
                        node = node.next;
                    }
                }
                return false; //한바퀴 돌아도 삭제할 애가 없음
            }
        }
    }
}
