package com.dev.Services;

import java.util.*;

/**
 * Created by Sigal on 5/21/2016.
 */

public interface GeneralManager {

    public <T> void updateObjects(List<T> list);

    public <T> T loadObject(Class<T> clazz, int oid);

    public <T> void updateObject(T object);

    public <T> List<T> getList(Class<T> clazz);

    public <T> void delete(Class<T> clazz);


    public <T> List<T> loadList(Class<T> clazz);


}