package shardingDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Shard {
	private final int id;
	private final Map<Integer, Data> dataStore;	
	
	public Shard(final int id) {
		super();
		this.id = id;
		this.dataStore = new HashMap<>();
	}
	
	public void storeData(Data data) {
		dataStore.put(data.getKey(), data);
	}
	
	public void clearData() {
		dataStore.clear();
	}

	public int getId() {
		return id;
	}
	
	public Map<Integer, Data> getDataStore() {
		return dataStore;
	}
	
	
}
