import org.junit.Assert;

public class SortTester {
    @org.junit.Test
    public void binarySearchTest1(){
        int[] input = {1, 5, 7, 8, 9, 11, 18, 19, 20, 25};
        int target = 11;
        int trueOutputIndex = 5;
        int output = Sort.findTarget(input, target);
        Assert.assertEquals(output, trueOutputIndex);
    }

    @org.junit.Test
    public void binarySearchTest2(){
        int[] input = {1, 2, 3, 4, 5};
        int target = 10;
        int trueOutputIndex = -1;
        int output = Sort.findTarget(input, target);
        Assert.assertEquals(output, trueOutputIndex);
    }
}
