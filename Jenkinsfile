@Library ('shared-library') _

pipeline {
    agent any

    stages{
        stage('Git Checkout'){
            steps{
                gitCheckout(
                    branch: "main",
                    url: "https://github.com/bharats487/java-mysql-public.git"
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

        stage('Sonarqube'){
            steps{
                script{
                    def sonarQubcredentialsId = 'jenkin'
                    staticCodeAnalysis(sonarQubcredentialsId)
                }
            }
        }


    }
}