
import java.util.*;
public class heaps {
    static class MinHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int child = arr.size() - 1;
            int parent = (child - 1) / 2;

            while (child > 0 && arr.get(child) < arr.get(parent)) {
                // Swap child and parent
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                // Move up the tree
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public int peek() {
            if (arr.isEmpty()) {
                throw new NoSuchElementException("Heap is empty");
            }
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // Swap elements
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // Recursively heapify
                heapify(minIdx);
            }
        }

        public boolean isEmpty() {
            return arr.isEmpty();
        }

        public int remove() {
            if (arr.isEmpty()) {
                throw new NoSuchElementException("Heap is empty");
            }

            int data = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);

            heapify(0);
            return data;
        }
    }
    public static void heapifyy(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx=left;
        }
        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx=right;
        }
        //swap
        if(maxIdx!=i){
            int temp=arr[i];
                arr[i]=arr[maxIdx];
                arr[maxIdx]=temp;
                heapifyy(arr,maxIdx,size);

        }

    }
         public static void heapsort(int arr[]){
            //step-1 to create a max heap
            int n=arr.length;
            for(int i=n/2;i>=0;i--){
                heapifyy(arr,i,n);
            }
            //step-2 swap largest with last index

            for(int i=n-1;i>=0;i--){
                int temp=arr[0];
                arr[0]=arr[i];
                arr[i]=temp;
                heapifyy(arr,0,i);
            }
         }
         public static class  point implements Comparable<point>{ 
            int x;
            int y;
            int idx;
            int distsq;
            public point(int x, int y, int distsq, int idx){
                this.x=x;
                this.y=y;
                this.idx=idx;
                this.distsq=distsq;
            }
            @Override
            public int compareTo(point p2){
                return this.distsq-p2.distsq;
            }
         }
         public static int minropes(PriorityQueue<Integer> pq){
            int cost=0;
            while(pq.size()>1){
                int min=pq.remove();
                int min2=pq.remove();
                cost+=min+min2;
                pq.add(min+min2);
            }
            return cost;
         }
         public static class row implements Comparable<row>{
            int soldiers;
            int idx;
            public row(int soldiers,int idx){
                this.soldiers=soldiers;
                this.idx=idx;
            }
            @Override
            public int compareTo(row r2){
                if(this.soldiers==r2.soldiers){
                    return this.idx-r2.idx;
                }
                else{
                    return this.soldiers-r2.soldiers;

                }
            }
         }
          static class Pair implements Comparable<Pair>{
            int number;
            int idx;
            public Pair(int number,int idx){
                this.number=number;
                this.idx=idx;
                }
                @Override
                public int compareTo(Pair p2){
                    return p2.number-this.number;// descending order
                }
         }
    public static void main(String[] args) {
        int window[]={1,3,-1,-3,5,5,6,7};
        int k=3;
        int result[]= new int[window.length-k+1];

        PriorityQueue<Pair> pq= new PriorityQueue<>();
        // first window 
        for(int i=0;i<k;i++){
            pq.add( new Pair(window[i], i));
        }
        // for rest windows
        result[0]=pq.peek().number;

        for(int i=k;i<window.length;i++){
            while(pq.size()>0 && pq.peek().idx<=(i-k)){
                pq.remove();
            }
            pq.add(new Pair(window[i], i));
            result[i-k+1]=pq.peek().number;

        }

        for(int i=0;i<result.length;i++){
             System.out.print(result[i]+" ");

        }
        System.out.println();

        
    }
}
// int soldiers[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        // int k=2;
        // PriorityQueue<row> pq= new PriorityQueue<>();
        // for(int i=0;i<soldiers.length;i++){ 
        //     int count=0;
        //     for(int j=0;j<soldiers[0].length;j++){
        //         count+=soldiers[i][j]==1?1:0;
        //     }
        //     pq.add(new row(count, i));
        // }
         
        // int ropes[]={2,3,3,4,6};
        // PriorityQueue<Integer> pq= new PriorityQueue<>();
        // for(int i=0;i<ropes.length;i++){
        //     pq.add(ropes[i]);
        // }
        // System.out.print(minropes(pq));

        // int pts[][]={{3,3},{5,-1},{-2,4}};
        // int k=2;
        // PriorityQueue<point> pq= new PriorityQueue<>();
        // for(int i=0;i<pts.length;i++){
        //     int distsq=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
        //     pq.add(new point( pts[i][0],pts[i][1],distsq,i));
        // }
        // for(int i=0;i<k;i++){
        //     System.out.println("C"+pq.remove().idx);
        // }
        // int arr[]={1,2,4,5,3};
        // heapsort(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // MinHeap minHeap = new MinHeap();
        // minHeap.add(3);
        // minHeap.add(4);
        // minHeap.add(1);
        // minHeap.add(5);

        // while (!minHeap.isEmpty()) {
        //     System.out.println(minHeap.peek());
        //     minHeap.remove();
        // }
