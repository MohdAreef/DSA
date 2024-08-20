/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
*/

class MedianFinder {
    PriorityQueue<Integer> minheap, maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if (!maxheap.isEmpty() && num > maxheap.peek()) {
            minheap.add(num);
        } else {
            maxheap.add(num);
        }

        if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
        if (maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        }

    }

    public double findMedian() {
        int size = minheap.size() + maxheap.size();
        if (size % 2 == 0) {
            return ((double) minheap.peek() + (double) maxheap.peek()) / 2;
        } else {
            return (double) maxheap.peek();
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
