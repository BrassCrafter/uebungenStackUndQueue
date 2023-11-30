package Queue;

public class TestClass {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        fillQueue(queue);
        printInteger(queue);
        InsertionSort.sort(queue);
        System.out.print("\n");
        printInteger(queue);
        //System.out.println(findLargestElement(queue));
    }
    public static void fillQueue(Queue<Integer> pQueue) {
        for (int i = 0; i < 10; i++) {
            double rand = Math.random() * 10000;
            pQueue.enqueue((int) rand);
        }
    }
    public static Integer findLargestElement(Queue<Integer> pQueue){
        Queue<Integer> tempQueue = new Queue<Integer>();
        Integer largestElement = null;

        while (!pQueue.isEmpty()) {
            Integer front = pQueue.front();
            if(largestElement == null || front > largestElement){
                largestElement = front;
            }
            tempQueue.enqueue(front);
            pQueue.dequeue();
        }

        while (!tempQueue.isEmpty()) {
            pQueue.enqueue(tempQueue.front());
            tempQueue.dequeue();
        }

        return largestElement;
    }
    public static void printSTRING(Queue<String> pQueue) {
        Queue<String> tempQueue = new Queue<String>();
        StringBuilder qString = new StringBuilder();
        while (!pQueue.isEmpty()) {
            String element = pQueue.front();
            qString.append(" ").append("'").append(element).append("'");
            tempQueue.enqueue(element);
            pQueue.dequeue();
        }
        while (!tempQueue.isEmpty()) {
            pQueue.enqueue(tempQueue.front());
            tempQueue.dequeue();
        }
        System.out.println("Queue to String:" + qString);
    }
    public static void printInteger(Queue<Integer> queue){
        printINT(queue);
        reverse(queue);
    }
    private static void printINT(Queue<Integer> queue){
        if(!queue.isEmpty()){
            int meins = queue.front();
            queue.dequeue();
            System.out.print(meins + " | ");
            printINT(queue);
            queue.enqueue(meins);
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
