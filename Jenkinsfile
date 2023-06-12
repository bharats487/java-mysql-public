pipeline {
  agent any
  
  environment {
    AWS_DEFAULT_REGION = 'your_aws_region'
    EC2_INSTANCE_NAME = 'your_ec2_instance_name'
    DB_HOST = 'your_mysql_host'
    DB_PORT = 'your_mysql_port'
    DB_NAME = 'your_mysql_database_name'
    DB_USERNAME = 'your_mysql_username'
    DB_PASSWORD = 'your_mysql_password'
  }
  
  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', credentialsId: 'git-token', url: 'https://github.com/bharats487/java-mysql.git'
      }
    }
    
    stage('Build') {
      steps {
          withMaven {
              sh "mvn clean package"
                  } 
      }
    }
    
    stage('Deploy to EC2') {
      steps {
       sshagent(['AWS-EC2']) {
           sh "scp -o StrictHostKeyChecking=no /var/jenkins_home/workspace/java-mysql-pipeline/target/servletapplication.war ubuntu@3.84.253.38:/var/lib/tomcat9/webapps/"
}
     }
      }
    }
    
  }

