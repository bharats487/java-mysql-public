FROM bharats487/servletapplication:1.0.0

ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

RUN sed -i 's/port="8080"/port="8180"/g' $CATALINA_HOME/conf/server.xml
