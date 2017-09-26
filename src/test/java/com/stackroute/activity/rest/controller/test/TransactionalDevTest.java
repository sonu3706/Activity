/**
 * 
 */
package com.stackroute.activity.rest.controller.test;

import static java.lang.annotation.ElementType.TYPE_PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ContextConfiguration;

import com.stackroute.activity.rest.config.WebConfig;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = {WebConfig.class})
/**
 * @author chandan
 *
 */
public @interface TransactionalDevTest {

}
