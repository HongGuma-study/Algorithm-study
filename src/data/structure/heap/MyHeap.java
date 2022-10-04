package data.structure.heap;

import java.util.ArrayList;
import java.util.Collections;

public class MyHeap {
    ArrayList<Integer> heapArray= null;

    public MyHeap(Integer data){
        heapArray = new ArrayList<Integer>();

        heapArray.add(null); //null 넣는 이유 (0번째 칸은 비우려고)
        heapArray.add(data); //root 노드
    }

    public boolean insert(Integer data){
        Integer insertedIdx, parentIdx;
        if(heapArray == null){ //heap 에 아무것도 없을 때
            heapArray = new ArrayList<Integer>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }else{
            heapArray.add(data);
            insertedIdx = this.heapArray.size() - 1; //마지막 인덱스 == 삽입한 데이터 인덱스
            while (this.moveUp(insertedIdx)){ //부모랑 자식이랑 값 비교하기
                parentIdx = insertedIdx / 2; //삽입한 데이터의 부모 인덱스
                Collections.swap(this.heapArray,insertedIdx,parentIdx); //자리 바꾸기
                insertedIdx = parentIdx; //인덱스도 바꾸기
            }
            return true;
        }
    }

    /**
     * 값 비교하는 함수
     * @param insertedIdx 삽입한 데이터 인덱스
     * @return 자식이 부모보다 크면 true 작으면 false
     */
    public boolean moveUp(Integer insertedIdx){
        if(insertedIdx <= 1) return false; //idx 가 1 이하면 root 이므로 false
        Integer parentIdx = insertedIdx/2; //부모 idx
        return this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx);
    }

    /**
     * 데이터 출력하는 메소드
     * @return
     */
    public Integer pop(){
        Integer returnedData, poppedIdx, poppedRightIdx, poppedLeftIdx;
        //리턴할 데이터, 리턴할 데이터 index, 리턴할 데이터의 왼쪽 자식 idx, 리턴할 데이터의 오른쪽 자식 idx
        if(this.heapArray == null){ //아무것도 없는 경우
            return null;
        }else{ //1개 이상인 경우
            returnedData = this.heapArray.get(1); //root 가 최대 값이니까 root 노드 return
            this.heapArray.set(1,this.heapArray.get(this.heapArray.size()-1));
            this.heapArray.remove(this.heapArray.size()-1);
            poppedIdx = 1;
            while(this.moveDown(poppedIdx)){
                poppedLeftIdx = poppedIdx * 2;
                poppedRightIdx = poppedIdx * 2 + 1;

                if(poppedRightIdx >= this.heapArray.size()){ //으론쪽 자식만 없을 때
                    if(this.heapArray.get(poppedIdx) < this.heapArray.get(poppedLeftIdx)){
                        Collections.swap(heapArray,poppedIdx,poppedLeftIdx);
                        poppedIdx = poppedLeftIdx;
                    }
                }else{ // 왼쪽 오른쪽 둘 다 있을 때
                    if (this.heapArray.get(poppedLeftIdx) > this.heapArray.get(poppedRightIdx)){ //왼쪽이 더 크다
                        if(this.heapArray.get(poppedIdx) < this.heapArray.get(poppedLeftIdx)){ //왼쪽이 부모보다 크다.
                            Collections.swap(heapArray,poppedIdx,poppedLeftIdx);
                            poppedIdx = poppedLeftIdx;
                        }
                    }else{ //오른쪽이 더 크다.
                        if(this.heapArray.get(poppedIdx) < this.heapArray.get(poppedRightIdx)){ //오른쪽이 부모보다 크다.
                            Collections.swap(heapArray,poppedIdx,poppedRightIdx);
                            poppedIdx = poppedRightIdx;
                        }
                    }
                }
            }
            return returnedData;
        }
    }

    public boolean moveDown(Integer poppedIdx){
        Integer poppedLeftIdx, poppedRightIdx; //popped 의 왼쪽 자식, popped 의 오른쪽 자식

        poppedLeftIdx = poppedIdx * 2;
        poppedRightIdx = poppedIdx * 2 + 1;

        //왼쪽 자식 노드가 없을 때 (== 자식 노드가 하나도 없을 때)
        if(poppedLeftIdx >= this.heapArray.size()){
            return false;
        } else if (poppedRightIdx >= this.heapArray.size()) {//오른쪽 자식 노드만 없을 때 (왼쪽은 있고 오른쪽만 없음)
            return this.heapArray.get(poppedIdx) < this.heapArray.get(poppedLeftIdx);
        } else{//왼쪽 오른쪽 자식 노드가 다 있을 때
            if(this.heapArray.get(poppedLeftIdx) > this.heapArray.get(poppedRightIdx)){
                return this.heapArray.get(poppedIdx) < this.heapArray.get(poppedLeftIdx);
            }else{
                return this.heapArray.get(poppedIdx) < this.heapArray.get(poppedRightIdx);
            }
        }
    }


}
