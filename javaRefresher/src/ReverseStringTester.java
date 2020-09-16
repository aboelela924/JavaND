import org.junit.Assert;

public class ReverseStringTester {

    @org.junit.Test
    public void test1(){
        String input = "Hello World!";
        String expectedOutput = "!dlroW olleH";
        String output = Main.reverseString(input);
        Assert.assertEquals(output, expectedOutput);
    }

    @org.junit.Test
    public void test2(){
        String input = "abcde";
        String expectedOutput = "edcba";
        String output = Main.reverseString(input);
        Assert.assertEquals(output, expectedOutput);
    }

}
