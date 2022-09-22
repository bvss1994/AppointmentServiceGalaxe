# Author: Umesh S & Sharif Sultan

From openjdk:8
copy target/AppointmentService-0.0.1-SNAPSHOT.jar AppointmentService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","AppointmentService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8001
