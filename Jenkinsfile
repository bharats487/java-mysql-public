@Library ('shared-library') _

pipeline {
    agent any
    parameters {
        choice(name: 'action', choice: 'create\ndelete', description: 'choose create/Destry')
        string(name: 'ImageName', description:'Name of the docker build', defaultvalue: 'serverletapplication')
        string(name: 'ImageTag', description:'tag of the docker build', defaultvalue: 'v1')
        string(name: 'AppName', description:'name of the application', defaultvalue: 'springboot')
    }

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

        stage('static code analysis: sonarqube'){
            steps{
                script{
                    def sonarQubcredentialsId = 'jenkin'
                    staticCodeAnalysis(sonarQubcredentialsId)
                }
            }
        }

        stage('quality Gate status check: sonarqube'){
            steps{
                script{
                    def sonarQubcredentialsId = 'jenkin'
                    QualityGatestatus(sonarQubcredentialsId)
                }
            }
        }
        stage('Maven Build: Maven'){
            steps{
                script{
                    mvnBuild()
                }
            }
        }

        stage('Docker Image Build'){
            steps{
                script{
                    dockerBuild("${param.ImageName}","${param.ImageTag}","${param.AppName}")
                }
            }
        }


    }
}