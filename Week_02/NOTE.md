# 学习笔记

## **Java HashMap源码浅析**（JDK 1.8.0_131)
  * HashMap 继承自AbstractMap，实现了Map，Cloneable, Serializable接口。
  * 初始容量为16，最大容量为2的30次方，加载因子为0.75。
  * 拓展容量阈值=当前容量 X 加载因子。
  
### 1、存储实现  
  * 内部包含了Node类型的数组table，Node为HashMap的存储单元，继承自Map.Entry<K,V>接口,主要属性包括key,value,hash,next。
  * key,value即为键值对  
  * hash由 key的哈希值 异或 key哈希值无符号右移16位后的值 后哈希值得出，通过和table的length取模，计算在table中的存储位置。  
  * next为下一个Node节点，表名Node实际为一个链表，解决位置冲突问题。当链表长度大于8时，会将链表转化为红黑树。  
  * Node的主要方法有getKey()，getValue()，toString()，hashCode()，setValue(V newValue)，equals(Object o)。
  
### 2、常用方法  
  方法名 | 返回值 |方法说明
  ------ |--------|---------
  **put(K,V)** |V|将K,V键值对存储到HashMap中，并返回之前的K的值，若没有，则返回null。   
  **get(K)**  |V|将K对应的值取出并返回。  
  **size()** |int|返回存储的键值对数量。  
  **isEmpty()**  |boolean|判断HashMap是否含有元素。  
  **containsKey(Object key)**  |boolean|判断是否包含K。  
  **putAll(Map<? extends K, ? extends V> m)**  |无返回值|将Map中的数据，全部添加到此HashMap。  
  **remove(Object key)**  |V|将K对应的数据移除HashMap，并返回移除数据的值。没有此K时，返回null。  
  **clear()**  |无返回值|移除HashMap中的所有元素。  
  **containsValue(Object value)** |boolean|判断HashMap中是否包含有值V。  
  **keySet()** |Set<K>|将K的集合返回。  
  **values()** |Collection<V>|将V的集合返回。  
  **getOrDefault(Object key, V defaultValue)** |V|或HashMap存在K，则返回对应的V，若不存在，则返回指定的defaultValue。  
  **其他** |--|这就不列举了！！！  
  
### 3、发现
  * **table的size永远是2的N次幂，Why？**  
  1、空间最大化使用，数据分布均匀，减少冲突。例如：若数组长度为7，则在记录算位置时，会使用K的哈希值与上6(110)来进行取模，然后最低位始终是0，造成001，011，101，111位置永远无法存储数据，空间浪费了，而且，存储空间相对变小，冲突几率增大，效率就低了。  
  2、扩容时方便。每次扩容左移一位即可，且在链表数据迁移时，不需要重新计算hash。因为扩容后，索引要么为原索引，要么为原索引+旧容量（oldCap）。  
  3、运算效率高。取模通过h&（length-1）即可，比h%length效率高。  
  
### 4、疑问
  * **红黑树是啥？暂时不明白，有待查阅**  
  * **为什么每次调用put,remove等操作后，都要进行afterNodeRemoval、afterNodeInsertion、afterNodeAccess操作**  
  
### 小结
  * **看源码确实能学到很多**  
**-------------------------------------------------------美丽的分割线-------------------------------------------------------**
