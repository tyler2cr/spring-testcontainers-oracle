# Spring Data with Testcontainers

Run a spring boot test against a postgres database running in a docker container that's managed by the JUnit and TestContainers

# Reason to use instead of an embedded database

Spring Boot supports testing with an embedded database out-of-the-box. It's fast because it's in-memory, and the default
h2 vendor supports most sql use cases. However, for use cases that an embedded h2 database doesn't support, running
tests against a postgres database will provide the advantage of testing postgres-specific features before executing an
end-to-end test.

# Tech stack

- oracle
- testcontainers
- spring boot data jpa

