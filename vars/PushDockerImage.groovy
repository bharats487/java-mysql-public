def call(credentialsId) {
  stage("Push to DockerHub") {
    withDockerRegistry(credentialsId: credentialsId) {
      sh """
      docker push bharats487/java-app:latest
      """
    }
  }
}
