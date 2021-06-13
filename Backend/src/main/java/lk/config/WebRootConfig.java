//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.0
package lk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JPAConfig.class})
public class WebRootConfig {
}
