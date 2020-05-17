package com.study.hot.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration("defaultFastjsonConfig")
@ConditionalOnClass({JSON.class})
@ConditionalOnMissingBean({FastJsonHttpMessageConverter.class})
@ConditionalOnWebApplication
public class FastjsonAutoConfiguration {
    @Bean
    public FastJsonHttpMessageConverter customFastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setFastJsonConfig(fastjsonConfig());
        converter.setSupportedMediaTypes(getSupportedMediaType());
        //开启fastjson autotype功能（不开启，造成EntityWrapper<T>中的T无法正常解析）
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        return converter;
    }

    public FastJsonConfig fastjsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, //结果是否格式化
                SerializerFeature.WriteMapNullValue, //是否输出值为null的字段
                SerializerFeature.DisableCircularReferenceDetect, // 禁用循环引用
                SerializerFeature.BrowserCompatible // 将中文都会序列化为格式，字节数会多一些，但是能兼容IE 6
        );
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        initOtherValueFilters(fastJsonConfig);
        return fastJsonConfig;
    }

    public List<MediaType> getSupportedMediaType() {
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        //增加Actuator媒体类型
        mediaTypes.add(MediaType.valueOf("application/vnd.spring-boot.actuator.v2+json"));
        return mediaTypes;
    }

    protected void initOtherValueFilters(FastJsonConfig fastJsonConfig) {
        ValueFilter nullValueFilter = (object, name, value) -> (null == value) ? "" : value;
        fastJsonConfig.setSerializeFilters(nullValueFilter);
    }
}

