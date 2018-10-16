package com.zian.android.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * class can store the exactly type of list
 *
 * Created by yuzhenbei on 2015/7/25.
 */
public class ListOfJson<T> implements ParameterizedType {

    private Class<?> mType;

    public ListOfJson(Class<T> pType) {
        this.mType = pType;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[] {mType};
    }


    @Override
    public Type getOwnerType() {
        return null;
    }

    /**
     * Returns the declaring type of this parameterized type.
     * <p/>
     * The raw type of {@code Set<String> field;} is {@code Set}.
     *
     * @return the raw type of this parameterized type
     */
    @Override
    public Type getRawType() {
        return List.class;
    }
}