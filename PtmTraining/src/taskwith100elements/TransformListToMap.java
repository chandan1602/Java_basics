package taskwith100elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransformListToMap {
	private Map<Integer, String> list = new HashMap<>();
	
	public TransformListToMap(int dataCount) {
		list = IntStream.range(0, dataCount)
				.collect(HashMap<Integer, String>::new,
						(map, streamValue) -> map.put(map.size(), "evalued"),
						(map, map2) -> {});
	}
	
	public Map<Integer, String> getList() {
		return this.list;
	}
}
