package justas.development.Training_Subscription.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;


//TO AVOID ERROR:
/*2024-11-23T18:10:32.900+01:00  WARN 33531 --- [Training-Subscription] [nio-8090-exec-2]
ration$PageModule$WarningLoggingModifier : Serializing PageImpl instances as-is is not supported,
meaning that there is no guarantee about the stability of the resulting JSON structure!
For a stable JSON structure, please use Spring Data's PagedModel
(globally via @EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO))
or Spring HATEOAS and Spring Data's PagedResourcesAssembler as documented in
https://docs.spring.io/spring-data/commons/reference/repositories/core-extensions.html#core.web.pageables.*/

@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class MyConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
