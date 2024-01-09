package com.jxc.converter;


import io.micrometer.common.util.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

/**
 * 自定义类型转换器：字符串转为Boolean类型
 */
@Component
public class StringToBooleanConverter implements Converter<String, Boolean> {
    //支持Y/N、Yes/No、T/F、True/False、1/0、1/-1转换为对应的Boolean型
    private Collection trueStr;

    public StringToBooleanConverter(Collection trueStr) {
        if(this.trueStr==null || this.trueStr.size()<=0){
            String[] arr = new String[]{"y", "yes","t", "true", "1"};
            this.trueStr = Arrays.asList(arr);
        } else{
            this.trueStr = trueStr;
        }
    }

    @Override
    public Boolean convert(String source) {
        if(StringUtils.isNotEmpty(source) && this.trueStr.stream().anyMatch(item -> item.toString().toUpperCase().equals(source.toUpperCase()))){
            return true;
        } else {
            return false;
        }
    }
}
