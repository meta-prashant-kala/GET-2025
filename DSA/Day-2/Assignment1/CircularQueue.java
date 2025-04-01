package Assignment1;
public class CircularQueue <T> implements Queue <T>{
    Object [] queue;

    int front;
    int rear;

    public CircularQueue(int size){
        queue=new Object[size]; 
        front=-1;
        rear=0;
    }

    public boolean isFull(){
        if(rear==front){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(front==-1 && rear==0){
            return true;
        }
        return false;
    }

    
    public boolean push(T val){
        if(!this.isFull()){
            queue[rear]=val;
            rear=((rear+1)%queue.length);
            if(front==-1){
                front++;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean pop(){
        if(front==-1){
            return false;
        }
        else{
            front=((front+1)%queue.length);
            if(front==rear){
                front=-1;
                rear=0;
            }
            return true;
        }
    };

    public T peek(){
        @SuppressWarnings("unchecked")
        T peek = (T)queue[front];
        return peek;
    } 
}
