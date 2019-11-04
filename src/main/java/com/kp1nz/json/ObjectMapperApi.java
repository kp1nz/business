package com.kp1nz.json;

import io.netty.util.internal.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author kp1nz
 * @create 2019-01-22 19:19
 */
@Component
public class ObjectMapperApi {
    @Autowired
    ObjectMapper objectMapper;

    /**
     * java对象转字符串
     */
    public <T> String obj2Str(T t) {
        if (t == null) {
            return null;
        }
        try {
            return t instanceof String ? (String) t : objectMapper.writeValueAsString(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> String obj2StrPretty(T t) {
        if (t == null) {
            return null;
        }
        try {
            return t instanceof String ? (String) t : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转java对象
     */
    public <T> T str2Obj(String string, Class<T> clazz) {
        if (StringUtils.isEmpty(string) || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) string : objectMapper.readValue(string, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数组转java对象
     *
     * @P TypeReference 传的时候 new TypeReference<List <List<UserInfo>>(){}
     */
    public <T> T str2Obj(String string, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(string) || typeReference == null) {
            return null;
        }
        try {
            return typeReference.getClass().equals(String.class) ? (T) string : objectMapper.readValue(string, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
