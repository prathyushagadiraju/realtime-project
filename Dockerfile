FROM java 1.8 SDK
EXPOSE 8080
ADD target/docker-demo.jar docker-demo.jar 
ENTRYPOINT ["java","-jar","docker-demo.jar"]
CMD ["echo","Docker file for java application"]
