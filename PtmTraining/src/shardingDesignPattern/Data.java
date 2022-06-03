package shardingDesignPattern;

public class Data {
	private int key;
	private String value;
	private DataType type;
	
	
	
	public Data(int key, String value, DataType type) {
		super();
		this.key = key;
		this.value = value;
		this.type = type;
	}



	public int getKey() {
		return key;
	}



	public void setKey(int key) {
		this.key = key;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public DataType getType() {
		return type;
	}



	public void setType(DataType type) {
		this.type = type;
	}



	enum DataType {
		TYPE_1, TYPE_2, TYPE_3
	}
	
	@Override
	public String toString() {
		return "Data {" + "key="
		        + key + ", value='" + value
		        + '\'' + ", type=" + type + '}';
	}
	
}
