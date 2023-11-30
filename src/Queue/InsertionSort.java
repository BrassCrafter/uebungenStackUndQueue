package Queue;
public class InsertionSort {
    public static void sort(Queue<Integer> queue){
        if(!queue.isEmpty()){
            int temp = queue.front();
            queue.dequeue();
            sort(queue);
            insert(queue, temp);
            reverse(queue);
        }
    }
    private static void insert(Queue<Integer> queue, int neu){
        if(queue.isEmpty()){
            queue.enqueue(neu);
        }else{
            int temp = queue.front();
            queue.dequeue();
            if(temp > neu){
                insert(queue, temp);
                queue.enqueue(neu);
            }else{
                insert(queue, neu);
                queue.enqueue(temp);
            }
        }
    }
    private static void reverse(Queue<Integer> queue){
        if(!queue.isEmpty()){
            int temp = queue.front();
            queue.dequeue();
            reverse(queue);
            queue.enqueue(temp);
        }
    }
}
