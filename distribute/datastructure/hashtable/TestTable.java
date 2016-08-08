 
package hashtable;  
public class TestTable {
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.insert(new Info("a", "小明"));
		ht.insert(new Info("ct", "王红"));
		ht.insert(new Info("b", "张晓芳"));
		System.out.println(ht.find("a").getName());
		System.out.println(ht.find("ct").getName());
		System.out.println(ht.find("b").getName());
		ht.delete("b");
		System.out.println(ht.find("b").getName());
	}

}
  
