package tyler2cr.spring.testcontainers;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@DirtiesContext
public abstract class TestContainersTest {

    @Container
    public static OracleContainer oracleDatabase =
            new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe:slim-faststart"))
//                    .withDatabaseName("test")
//                    .withExposedPorts(5432)
//                    .withStartupAttempts(2)
                    .withEnv("ORACLE_PWD", "Str0ngPassw0rd")
                    .withStartupTimeoutSeconds(900)
                    .withConnectTimeoutSeconds(900)
                    .withPassword("Str0ngPassw0rd")
            ;
    
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", oracleDatabase::getJdbcUrl);
        registry.add("spring.datasource.username", oracleDatabase::getUsername);
        registry.add("spring.datasource.password", oracleDatabase::getPassword);
    }
}
