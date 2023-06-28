pipeline {
  agent any
  
  stages {

    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/bharats487/java-mysql-public.git'
      }
    }
    
    stage('Build') {
      steps {
           sh "mvn clean package"
          
      }
    }
    stage('Test package') {
      steps {
           sh "mvn test"
          
      }
    }
    
    stage('SonarQube Analysis') {
        steps{
            withSonarQubeEnv('SonarQube') {
                sh "mvn sonar:sonar"
        }
    }
  }
    stage('Upload to Nexus'){
        steps {
            nexusArtifactUploader artifacts: [[artifactId: 'servletapplication',
            classifier: '',
            file: 'target/servletapplication.war', type: 'war']], 
            credentialsId: 'Nexus', groupId: 'com.abhiram', nexusUrl: '192.168.0.34:8081',
            nexusVersion: 'nexus3', protocol: 'http', 
            repository: 'http://192.168.0.34:8081/#browse/browse:java-app', 
            version: '1.0.0'
        }
    }
    


