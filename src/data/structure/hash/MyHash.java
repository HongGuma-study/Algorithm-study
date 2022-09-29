package data.structure.hash;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean saveData(String key, String value){
        int addr = this.hashFunc(key);
        if(this.hashTable[addr] != null){
            if(this.hashTable[addr].key == key){
                this.hashTable[addr].value = value;
                return true;
            }else{
                int currAddr = addr;
                while(this.hashTable[currAddr] != null){
                    if(this.hashTable[currAddr].key == key){
                        this.hashTable[currAddr].value =value;
                        return true;
                    }else{
                        currAddr++; //주소가 배열을 벗어나면
                        if(currAddr >= this.hashTable.length){
                            return false;
                        }
                    }
                }
                this.hashTable[addr] = new Slot(key,value);
            }
        }else{
            this.hashTable[addr] = new Slot(key,value);
        }
        return true;
    }

    public String getData(String key){
        int addr = this.hashFunc(key);
        if(this.hashTable[addr] != null){
            if(this.hashTable[addr].key == key){
                return this.hashTable[addr].value;
            }else{
                int currAddr = addr++;
                while(this.hashTable[currAddr] != null) {
                    if (this.hashTable[currAddr].key == key) {
                        return this.hashTable[currAddr].value;
                    } else {
                        currAddr++;
                        if (currAddr >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        }else{
            return null;
        }
    }

    //해쉬 함수
    public int hashFunc(String key){
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

}
