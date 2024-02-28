# Use a base image with Maven and Java
FROM maven:3.8.3-openjdk-8

# Install Maven
RUN apt-get update && \
    apt-get install -y maven

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the project files into the container
COPY . .

# Build the project (if necessary)
CMD mvn clean install -DskipTests

CMD ["chrome", "--lang=en-US"]

# Set the entry point for running tests
ENTRYPOINT ["mvn", "test"]