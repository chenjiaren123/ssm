package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转日期
 */
public class StringToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String souroe) {
        if (souroe==null) throw new  RuntimeException("请您传入数据");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(souroe);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
