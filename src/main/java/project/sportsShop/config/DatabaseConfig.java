package project.sportsShop.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;

    @Value("jdbc:mysql://localhost:3306/test1?serverTimezone=UTC&characterEncoding=UTF-8")
    private String url;

    @Value("root")
    private String username;

    @Value("6529")
    private String password;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                                .driverClassName(driver)
                                .url(url)
                                .username(username)
                                .password(password)
                                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
