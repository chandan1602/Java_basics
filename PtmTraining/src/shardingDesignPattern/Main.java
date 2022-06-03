package shardingDesignPattern;

public class Main {
	public static void main(String[] args) {
		Data data1 = new Data(1, "data1", Data.DataType.TYPE_1);
		Data data2 = new Data(2, "data2", Data.DataType.TYPE_2);
		Data data3 = new Data(3, "data3", Data.DataType.TYPE_3);
		Data data4 = new Data(4, "data4", Data.DataType.TYPE_1);
		
		Shard shard1 = new Shard(1);
		Shard shard2 = new Shard(2);
		Shard shard3 = new Shard(3);
		
		
	}
}
