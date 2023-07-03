@Library ('shared-library') _

pipeline {
    agent any

    stages{
        stage('Git Checkout'){
            steps{
                gitCheckout(
                    branch: "master",
                    url: "https://github.com/bharats487/spring-boot-mysql-rest-api-tutorial.git"
                )
            }
        }
        stage('Unit Test maven'){
            steps{
                script{
                    mvnTest()
                }
            }
        }




    }
}