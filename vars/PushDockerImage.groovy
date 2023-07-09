def call(credentialsId, String project, String ImageTag ,String hubUser ) {
  stage("Push to DockerHub") {
    withDockerRegistry(credentialsId: credentialsId) {
      sh """
      docker push ${hubUser}/${project}:${ImageTag}
      docker push ${hubUser}/${project}:latest
      """
    }
  }
}
