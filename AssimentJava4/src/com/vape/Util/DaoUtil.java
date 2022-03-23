package com.vape.Util;

import java.util.List;

public abstract class DaoUtil<E,Key> {
	abstract public void insert(E entity);
	abstract public void update(E entity);
    abstract public void delete(Key key);
    abstract public List<E> selectAll();
    abstract public List<E> selectPage(int x);
    abstract public E selectById(Key key);
    abstract protected List<E> selectBySql(String sql, Object...args);
}
