FROM mjalas/javafx
COPY ./shippable/buildoutput/target/missions-javafx-1.0.jar /home/app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /home/app.jar" ]