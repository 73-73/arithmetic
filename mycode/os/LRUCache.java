package mycode.os;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pan
 * @create 2020-02-27-18:16
 */
public class LRUCache extends LinkedHashMap {

    private int capacity;

    /**
     * 注意细节，accessOrder参数应该为true
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    public Object put(Object key, Object value) {
        return super.put(key, new Object());
    }

    public Object get(int key) {
        //如果key没有映射值，则返回设置的默认值：-1
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(5, 1);
        lruCache.put(4, 2);
        lruCache.put(3, 2);
        lruCache.put(2, 2);
        lruCache.put(1, 2);
        lruCache.put(6, 2);
        System.out.println(lruCache.toString());
    }
}

