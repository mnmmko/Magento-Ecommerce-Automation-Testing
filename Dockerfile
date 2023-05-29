FROM maven:3.8.6 as test
WORKDIR /Ecomerce
#ARG env
#RUN if ["envs"="envs"];\
#    then mvn clean test -DskipTests=true
#    else mvn clean test -DskipTests=false
#    fi
COPY . .
RUN mvn -f /Ecomerce/pom.xml clean test -DskipTests=true

