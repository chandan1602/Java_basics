package taskwith100elements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterEvenNumbers{

	
	private List<Integer> list = new ArrayList<>();
	
	public FilterEvenNumbers(int dataCount) {
		IntPredicate isOdd = x -> x%2==0;
		list = IntStream.range(0, dataCount)
//				.mapToObj(index -> index+"")
				.filter(isOdd::test)
				.mapToObj(x -> x)
				.parallel()
				.collect(Collectors.toList());
	}
	
	public List<Integer> getList() {
		return this.list;
	}
}
