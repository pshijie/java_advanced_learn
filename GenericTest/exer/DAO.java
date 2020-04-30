package com.psj.GenericTest.exer;

import javafx.scene.chart.ValueAxis;

import java.util.*;

/**
 * @Author:PSJ
 * @Date:2020/4/29 0029
 * @Descrption:com.psj.GenericTest.exer
 * @Version:1.0
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();//必须要初试化

    public void save(String id, T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        if (map.containsKey(id)){
            map.put(id,entity);
        }
    }
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for(T t : values){
            list.add(t);
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}
