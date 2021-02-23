FROM java:8
CMD ["mvn", "clean package","-DskipTests"]
ARG WORK_PATH=/home/app
CMD ["makdir","$WORK_PATH"]
WORKDIR $WORK_PATH
ADD target/k8sdemoclient-0.0.1-SNAPSHOT.jar $WORK_PATH/k8sdemoclient-0.0.1-SNAPSHOT.jar
RUN cd $WORK_PATH
ENTRYPOINT ["java","-jar","k8sdemoclient-0.0.1-SNAPSHOT.jar"]
EXPOSE 9081