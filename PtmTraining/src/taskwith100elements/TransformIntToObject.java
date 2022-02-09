package taskwith100elements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransformIntToObject {
	private List<String> list = new ArrayList<>();
	
	public TransformIntToObject(int dataCount) {
		IntPredicate isOdd = x -> x%2!=0;
		list = IntStream.range(0, dataCount)
				.mapToObj(index -> index + ": TranferedToString")
				.collect(Collectors.toList());
	}
	
	public List<String> getList() {
		return this.list;
	}
}
