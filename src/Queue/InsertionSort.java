package Queue;
public class InsertionSort {
    public static void sort(Queue<Integer> queue){
        if(!queue.isEmpty()){
            int meins = queue.front();
            queue.dequeue();
            sort(queue);
            insert(queue, meins);
            reverse(queue);
        }
    }
    private static void insert(Queue<Integer> queue, int neu){
        if(queue.isEmpty()){
            queue.enqueue(neu);
        }else{
            int meins = queue.front();
            queue.dequeue();
            if(meins > neu){
                insert(queue, meins);
                queue.enqueue(neu);
            }else{
                insert(queue, neu);
                queue.enqueue(meins);
            }
        }
    }
    private static void reverse(Queue<Integer> queue){
        if(!queue.isEmpty()){
            int meins = queue.front();
            queue.dequeue();
            reverse(queue);
            queue.enqueue(meins);
        }
    }
}
