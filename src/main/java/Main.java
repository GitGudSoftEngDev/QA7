import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> hip = new Heap<Integer>();
        hip.elements.sort(null);

    }

    public static class Heap<E extends Comparable<E>> {

        List<E> elements = new ArrayList<>();

        void printHeap(){
            for (int i = 0; i < this.elements.size();i++)
            {
                System.out.println(this.elements.get(i));
            }
        }
        boolean isEmpty() {
            return elements.isEmpty();
        }

        E elementAt(int index) {
            return elements.get(index);
        }

        int parentIndex(int index) {
            return (index - 1) / 2;
        }

        int leftChildIndex(int index) {
            return 2 * index + 1;
        }

        int rightChildIndex(int index) {
            return 2 * index + 2;
        }

        void add(E e) {
            elements.add(e);
            int elementIndex = elements.size() - 1;
            while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
                int parentIndex = parentIndex(elementIndex);
                swap(elementIndex, parentIndex);
                elementIndex = parentIndex;
            }
        }

        boolean isRoot(int index) {
            return index == 0;
        }

        boolean isCorrectChild(int index) {
            return isCorrect(parentIndex(index), index);
        }

        boolean isCorrect(int parentIndex, int childIndex) {
            if (!isValidIndex(parentIndex) || !isValidIndex(childIndex)) {
                return true;
            }

            return elementAt(parentIndex).compareTo(elementAt(childIndex)) < 0;
        }

        boolean isValidIndex(int index) {
            return index < elements.size();
        }

        void swap(int index1, int index2) {
            E element1 = elementAt(index1);
            E element2 = elementAt(index2);
            elements.set(index1, element2);
            elements.set(index2, element1);
        }

        E pop() {
            if (isEmpty()) {
                throw new IllegalStateException("You cannot pop from an empty heap");
            }

            E result = elementAt(0);

            int lasElementIndex = elements.size() - 1;
            swap(0, lasElementIndex);
            elements.remove(lasElementIndex);

            int elementIndex = 0;
            while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
                int smallerChildIndex = smallerChildIndex(elementIndex);
                swap(elementIndex, smallerChildIndex);
                elementIndex = smallerChildIndex;
            }

            return result;
        }

        boolean isLeaf(int index) {
            return !isValidIndex(leftChildIndex(index));
        }

        boolean isCorrectParent(int index) {
            return isCorrect(index, leftChildIndex(index)) && isCorrect(index, rightChildIndex(index));
        }

        int smallerChildIndex(int index) {
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);

            if (!isValidIndex(rightChildIndex)) {
                return leftChildIndex;
            }

            if (elementAt(leftChildIndex).compareTo(elementAt(rightChildIndex)) < 0) {
                return leftChildIndex;
            }

            return rightChildIndex;
        }

        static <E extends Comparable<E>> List<E> sort(Iterable<E> elements) {
            Heap<E> heap = of(elements);

            List<E> result = new ArrayList<>();

            while (!heap.isEmpty()) {
                result.add(heap.pop());
            }

            return result;
        }

        static <E extends Comparable<E>> Heap<E> of(Iterable<E> elements) {
            Heap<E> result = new Heap<>();
            for (E element : elements) {
                result.add(element);
            }
            return result;
        }
    }
}