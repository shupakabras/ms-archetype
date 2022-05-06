Build using `mvn clean install`

To generate new archetype, use 

``
mvn archetype:generate \
    -DarchetypeGroupId=com.ge.ms.archetypes \
    -DarchetypeArtifactId=microservice-archetype \
    -DarchetypeVersion=1.0 \
    -DgroupId=org.example.ms \
    -DartifactId=cool-ms-sample \
    -Dversion=1.0-SNAPSHOT
``