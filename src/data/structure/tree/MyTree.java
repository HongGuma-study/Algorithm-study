package data.structure.tree;

import java.lang.invoke.VarHandle;

public class MyTree {
    Node head = null;
    public class Node{
        Node left;
        Node right;
        int value;
        public Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    //트리에 노드 삽입하기
    public boolean insertNode(int data){
        if(this.head == null){//node 가 하나도 없을때
            this.head = new Node(data);
            return true;
        }else{ //node 가 한 개 이상일 때
            Node findNode = this.head; //이제부터 '나'가 되는 거임
            while(true){ //내 밑에 아무것도 없을때 까지 반복할 거임
                if(data < findNode.value){// data 가 나보다 작으면 왼쪽
                    if(findNode.left != null){ //내 왼쪽에 자식이 있음
                        findNode = findNode.left; //그럼 왼쪽으로 한 칸 내려가
                    }else{ //내 왼쪽에 아무것도 없음
                        findNode.left = new Node(data); //그럼 새로 만들어
                        return true; //while 탈출
                    }
                }else{// data 가 나보다 크면 오른쪽
                    if(findNode.right != null){ //내 오른쪽에 자식이 있음
                        findNode = findNode.right; //그럼 오른쪽으로 한칸 내려가
                    }else{ //내 오른쪽에 자식이 없음
                        findNode.right = new Node(data); //그럼 새로 만들어
                        return true; //while 탈출
                    }
                }
            }
        }
    }

    //node 탐색
    public Node search(int data) {
        if (this.head != null) {//node 가 한 개 이상일 때
            Node findNode = this.head; //head 부터 시작
            while (findNode != null) {
                if (findNode.value == data) { //데이터 찾음
                    return findNode; //찾는 node 리턴
                } else if (data < findNode.value) { //data 가 나보다 작아
                    findNode = findNode.left; //왼쪽으로 내려가
                } else { //data 가 나보다 커
                    findNode = findNode.right; //오른쪽으로 내려가
                }
            }
        } // else : node 가 한 개 이상의 반대는 하나도 없을 때임 하나도 없으니까 당연히 null
        return null; //한바퀴 다 돌았는데 없으면 null
    }

    public boolean delete(int value) {
        boolean searched = false; // node 를 찾읍시다. 못찾으면 false (어짜피 삭제할 노드가 없으니까 괜히 더 실행하지 말고 끝내려고)
        // Node 가 하나라도 들어가 있을 때
        Node currParentNode = this.head;
        Node currNode = this.head;

        // 먼저 내가 찾는 노드가 있는지 탐색
        if (this.head == null) { //노드가 아무것도 없을 때
            return false; //밑에 코드까지 안가고 그냥 return 하고 종료
        } else { //노드가 한 개 이상일 때
            // head.value 는 있는데 left 와 right 가 없다? 그럼 노드가 head 한개임
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null; //head 그냥 지워버리고
                return true; //return 하고 종료
            }
            // 노드가 head 도 아니고 두 개 이상일때
            while (currNode != null) { //node 끝까지 탐색
                if (currNode.value == value) { //일치하는 노드가 있다?
                    searched = true; //찾았습니당 하고
                    break; //while 탈출
                } else if (value < currNode.value) { //찾는 노드가 아니야 그런데 value 가 나보다 작아
                    currParentNode = currNode; //그럼 parent (원래 head 였음) 는 현재 내가 되고
                    currNode = currNode.left; //나는 왼쪽으로 한 칸 내려가
                } else { //찾는 노드가 아니고 value 가 나보다 커
                    currParentNode = currNode; //그럼 parent (원래 head 였던것) 는 현재 내가 되고
                    currNode = currNode.right; //나는 오른쪽으로 한 칸 내려가
                }
            }

            if (!searched) { //그래도 찾는게 없다?
                return false; //걍 return 하고 종료
            }
        }

        // 이제 삭제할 노드를 찾았고 그게 head가 아닐때
        if (currNode.left == null && currNode.right == null) { // 왼쪽, 오른쪽 다 자식이 없으면 leaf 노드임
            if (value < currParentNode.value) { // 삭제할 value 가 내 부모 노드 보다 작다면
                currParentNode.left = null; // 부모 노드의 왼쪽을 삭제
            } else { //삭제할 value 가 내 부모 노드 보다 크다면
                currParentNode.right = null; // 부모 노드의 오른쪽을 삭제
            }
            return true; //삭제 했으니까 더 가지말고 return 후 종료
        } else if (currNode.left != null && currNode.right == null) { // 삭제할 노드가 자식 노드를 왼쪽에 한개만 가지고 있는 경우
            if (value < currParentNode.value) { // 삭제할 value 가 내 부모 노드보다 작으면
                currParentNode.left = currNode.left; // 부모 노드의 왼쪽이 내 자식 노드가 되는 거임
            } else { // 삭제할 value 가 내 부모 노드보다 크다면
                currParentNode.right = currNode.left; // 부모 노드이 오른쪽이 내 자식 노드가 되는 거임
            }
            return true;
        } else if (currNode.left == null && currNode.right != null) { //삭제할 노드가 자식 노드를 오른쪽에 한개만 가지고 있는 경우
            if (value < currParentNode.value) { //삭제할 value 가 내 부모보다 작으면
                currParentNode.left = currNode.right; // 부모의 왼쪽이 내 오른쪽 자식
            } else {//아니면
                currParentNode.right = currNode.right; //부모의 오른쪽이 내 오른쪽 자식
            }
            return true;

        } else { //삭제할 node 의 자식이 2개인 경우
            if (value < currParentNode.value) { //삭제할 node 가 내 부모노드 왼쪽에 있을 때 (value == "나")

                // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node 찾기
                Node changeNode = currNode.right; // 바꿀 노드를 내 오른쪽 노드로 초기화
                Node changeParentNode = currNode.right; //바꿀 노드의 부모 노드를 내 오른쪽 노드로 초기화
                while (changeNode.left != null) { //왼쪽이 안나올때까지 내려가 (내 왼쪽 자식이 내가 되고 내 부모는 '나'가 되고... null 나올때까지 반복)
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 자식 중, 가장 작은 값을 가진 Node 가 들어있음

                if (changeNode.right != null) {
                    // Case3-1-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right; //changeNode 부모 노드의 왼쪽은 changeNode의 오른쪽 자식이 되는 거임
                } else {
                    // Case3-1-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null; //없으면 왼쪽 그냥 비워
                }
                // parent Node 의 왼쪽 Child Node 에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.left = changeNode;
                // parent Node 왼쪽 Child Node 인 changeNode 의 왼쪽/오른쪽 Child Node 를
                // 모두 삭제할 currNode 의 기존 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;


            } else { // 삭제할 Node가 Parent Node 오른쪽에 있을 때
                // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node 찾기
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) { //왼쪽이 안나올 때까지 반복 (왜 왼쪽이냐 tree는 무조건 왼쪽이 작은거 오른쪽이 큰거라서 왼쪽으로 가다보면 작은 숫자가 나 올 수 밖에 없음)
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    // Case3-2-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-2-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // parent Node 의 오른쪽 Child Node 에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.right = changeNode;

                // parent Node 왼쪽 Child Node 인 changeNode 의 왼쪽/오른쪽 Child Node 를
                // 모두 삭제할 currNode 의 기존 왼쪽/오른쪽 Node 로 변경

                // 2021.11.09 업데이트 (참고: 코너 케이스)
                // currNode.right 가 changeNode 일 경우, changeNode 가 currNode 자리로 올라가면서,
                // 오른쪽에 다시 자신의 객체를 가리키는 상황이 될 수 있습니다.
                // 이 경우 의도치 않게, 삭제할 객체를 다시 연결하는 상황이 될 수 있습니다.
                // 특별한 코너 케이스이므로, 참고로만 코드를 업데이트를 드리며,
                // 우선은 트리의 핵심 알고리즘 이해에 보다 초점을 맞추시는 것을 추천드립니다.
                if (currNode.right != changeNode) {
                    changeNode.right = currNode.right;
                }
                changeNode.left = currNode.left;
            }
            return true;
        }
    }
}
