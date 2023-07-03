def call(credentialsId){
   withSonarQubeEnv(credentialsId: credentialsId) {
   sh "mvn sonar:sonar"
}

}