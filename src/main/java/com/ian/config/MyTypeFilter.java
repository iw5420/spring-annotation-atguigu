package com.ian.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    //match方法, 返回true, 匹配成功, 返回false, 匹配失敗
    /*
    * metadataReader, 讀取到當前正在掃描的類的信息
    * MetadataReaderFactory Factory interface for MetadataReader instances. Allows for caching a MetadataReader per original resource.
    * */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //獲取當前類註解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //獲取當前正在掃描的類的類信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //獲取當前類資源(類的路徑)
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("--->"+className);
        //如果類名有er則返回true
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
