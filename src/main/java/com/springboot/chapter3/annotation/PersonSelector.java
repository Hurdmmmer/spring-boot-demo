package com.springboot.chapter3.annotation;

import com.springboot.chapter3.config.AppConfig;
import com.springboot.chapter3.config.TestConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class PersonSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{
                TestConfig.class.getName(),
                AppConfig.class.getName()
        };
    }

}
