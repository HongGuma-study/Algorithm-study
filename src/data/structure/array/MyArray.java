package data.structure.array;

/**
 * jdk에서 제공하는 ArrayList를 만들어보자.
 */
public class MyArray {
    int[] intArr; //int array
    int count; // ?여기서 카운트는 뭘까 0부터 시작하는 것으로 보아 배열의 현재 index 같음 -> 개수라고 함

    public int ARRAY_SIZE; // 배열 사이즈
    public static final int ERROR_NUM = -999999999; //에러 코드

    /**
     * 아무 입력도 안 받은 생성자 (기본 사이즈 배열 생성)
     */
    public MyArray(){
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    /**
     * size를 입력받는 생성자
     * @param size
     */
    public MyArray(int size){
        count = 0;
        ARRAY_SIZE = size;
        intArr = new int[size];
    }

    /**
     * 배열에 원소 추가하는 메소드
     * 맨뒤에서부터 삽입이 된다.
     * @param num 추가할 원소
     */
    public void addElement(int num){
        if(count >= ARRAY_SIZE){
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    /**
     * 배열에 원소 삽입하는 메소드
     * [10],[50],[30],[40],[-1] 이렇게 있을때 1 자리에 새로운 원소를 넣고 싶다면
     * [10],[],[50],[30],[40],[-1] 이런식으로 원소들이 한칸씩 뒤로 이동해야한다.
     * 단 맨뒤에 있는 40부터 이동해야 하기 때문에 for문에서 i = count-1 부터 시작한다.
     * @param position 삽입할 위치 (== index)
     * @param num 삽입할 원소
     */
    public void insertElement(int position, int num){
        int i;

        if(count >= ARRAY_SIZE){ //배열이 꽉찬 경우
            System.out.println("not enough memory");
            return;
        }

        if(position < 0 || position > count){ // index error
            System.out.println("insert error");
            return;
        }

        for(i = count-1; i>=position; i--){ //한칸씩 이동 (내가 중간에 집어 넣으려고, 집어넣으려는 위치 부터 한칸씩 뒤로 밀기)
            intArr[i+1] = intArr[i];
        }

        intArr[position] = num;
        count++;
    }

    /**
     * 원소 삭제하는 메소드
     * [10],[50],[20],[30],[-1]인 배열에서 1자리의 원소를 삭제하고 싶으면
     * [10],[20],[30],[-1] 그냥 뒤에서 앞 자리로 덮어 씌우면 된다.
     * 그래서 for문에서 i=position부터 시작한다.
     * @param position 삭제할 위치
     * @return 에러나면 에러코드 리턴, 아니면 intArr 리턴
     */
    public int removeElement(int position){
        int ret = ERROR_NUM;

        if(isEmpty()){ //배열이 비어있을때
            System.out.println("There is no element");
            return ret;
        }

        if(position < 0 || position >= count){ //index error
            System.out.println("remove Error");
            return ret;
        }

        ret = intArr[position];

        for(int i=position; i<count-1; i++){
            intArr[i] = intArr[i+1];
        }

        count--;
        return ret;
    }

    /**
     * 배열 크기 출력하는 메소드
     * @return 배열의 크기
     */
    public int getSize(){
        return count;
    }

    /**
     * 배열이 비어있는지 확인하는 메소드
     * @return 비어있으면 true 아니면 false
     */
    public boolean isEmpty(){
        if(count == 0) return true;
        else return false;
    }

    /**
     * 배열의 원소를 리턴하는 메소드
     * @param position 배열의 크기? 위치?
     * @return 배열
     */
    public int getElement(int position){
        if(position < 0 || position >= count-1){
            System.out.println("검색 위치 오류. 현재 리스트의 개수는 : "+count+"개 입니다.");
            return ERROR_NUM;
        }
        return intArr[position];
    }

    /**
     * 배열의 모든 원소를 출력하는 메소드
     */
    public void printAll(){
        if(count == 0){
            System.out.println("출력할 내용이 없습니다.");
            return;
        }

        for(int i=0; i<count; i++){
            System.out.println(intArr[i]);
        }
    }

    /**
     * 배열의 모든 원소를 삭제하는 메소드
     */
    public void removeAll(){
        for(int i=0; i<count; i++){
            intArr[i] = 0;
        }
        count = 0;
    }

}
