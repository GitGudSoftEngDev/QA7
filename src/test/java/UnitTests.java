import java.util.Arrays;
import java.util.List;
import org.junit.*;


public class UnitTests {

    @Test
    public void isEmptyTest() {
        Main.Heap<Integer> hip = new Main.Heap<Integer>();
        Assert.assertTrue(hip.elements.isEmpty());
    }

    @Test
    public void sortWithSameNumbersTest() {
        Main.Heap<Integer> heap = Main.Heap.of(List.of(4, 1, 2, 1, 4, 2));
        Main.Heap<Integer> expected = Main.Heap.of(List.of(1, 1, 2, 2, 4, 4));
        heap.elements.sort(null);
        Assert.assertEquals(expected.elements,heap.elements);
    }

    @Test
    public void sortInvertedHeapTest() {
        Main.Heap<Integer> heap = Main.Heap.of(List.of(1000, 962, 642, 241, 69, 23, 5, 1));
        Main.Heap<Integer> expected = Main.Heap.of(List.of(1, 5, 23, 69 ,241, 642, 962, 1000));
        heap.elements.sort(null);
        Assert.assertEquals(expected.elements,heap.elements);
    }

    @Test
    public void sortEmptyHeapTest() {
        Main.Heap<Integer> heap = new Main.Heap<Integer>();
        Main.Heap<Integer> expected = new Main.Heap<Integer>();
        heap.elements.sort(null);
        Assert.assertEquals(expected.elements,heap.elements);
    }

    @Test
    public void sortAlreadySortedHeapTest() {
        Main.Heap<Integer> heap = Main.Heap.of(List.of(1,2,3,4,5));
        Main.Heap<Integer> expected = Main.Heap.of(List.of(1,2,3,4,5));
        heap.elements.sort(null);
        Assert.assertEquals(expected.elements,heap.elements);
    }

    @Test
    public void sortNegativeElementsHeapTest() {
        Main.Heap<Integer> heap = Main.Heap.of(List.of(-5,-4,-3,-2,-1));
        Main.Heap<Integer> expected = Main.Heap.of(List.of(-5,-4,-3,-2,-1));
        heap.elements.sort(null);
        Assert.assertEquals(expected.elements,heap.elements);
    }


}
