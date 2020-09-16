import org.junit.Assert;

public class Tester {

    @org.junit.Test
    public void VowelsOnlyTest1() throws Exception{
        String input = "Hello World";
        String output = Main.vowelOnly(input);
        String expected = "eoo";
        Assert.assertEquals(output, expected);
    }

    @org.junit.Test
    public void VowelsOnlyTest2() throws Exception{
        String input = "Udacity Course";
        String output = Main.vowelOnly(input);
        String expected = "Uaioue";
        Assert.assertEquals(output, expected);
    }

}
