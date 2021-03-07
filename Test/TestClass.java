package Test;
import java.util.List;
import java.util.ArrayList;
public class TestClass{
	public void change(int[] input){
		helper(input);
	}
	private void helper(int[] input){
		input[0] = 741;
	}
	public static void main(String[] args) {
		TestClass a = new TestClass();
		int[] input = new int[]{1};
		a.change(input);
		System.out.println(input[0]);
	}

}
